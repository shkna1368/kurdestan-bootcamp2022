package com.kurdestan.bootcamp.streaming;

import org.apache.commons.compress.utils.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;


@Service
public class VideoStreamService {

    String FILE_PATH="C:\\videos\\nasser.mp4";
    String FILE_PATH_144="C:\\videos\\nasser144.mp4";
    String FILE_PATH_480="C:\\videos\\nasser480.mp4";
    public  void renderMergedOutputModelWithSpeed(String speed , HttpServletRequest request, HttpServletResponse response) throws Exception {
        File movieFIle = null;


        if(speed.equals("fast")){
            movieFIle= new File(FILE_PATH_480);
        }
        else {
            movieFIle= new File(FILE_PATH_144);

        }

        final RandomAccessFile randomFile = new RandomAccessFile(movieFIle, "r");

        long rangeStart = 0;
        long rangeEnd = 0;
        boolean isPart = false;


        try {
            long movieSize = randomFile.length();//
            String range = request.getHeader("range");
            System.out.println("range: {}"+ range);


            if (range != null) {
                if (range.endsWith("-")) {
                    range = range + (movieSize - 1);
                }
                int idxm = range.trim().indexOf("-");
                rangeStart = Long.parseLong(range.substring(6, idxm));
                rangeEnd = Long.parseLong(range.substring(idxm + 1));
                if (rangeStart > 0) {
                    isPart = true;
                }
            } else {
                rangeStart = 0;
                rangeEnd = movieSize - 1;
            }

            long partSize = rangeEnd - rangeStart + 1;
            System.out.println("accepted range: {}"+ rangeStart + "-" + rangeEnd + "/" + partSize + " isPart:" + isPart);
            response.reset();
            response.setStatus(isPart ? 206 : 200);
            response.setContentType("video/mp4");

            response.setHeader("Content-Range", "bytes " + rangeStart + "-" + rangeEnd + "/" + movieSize);
            response.setHeader("Accept-Ranges", "bytes");
            response.setHeader("Content-Length", "" + partSize);

            OutputStream out = response.getOutputStream();
            randomFile.seek(rangeStart);


            int bufferSize = 8 * 1024;
            byte[] buf = new byte[bufferSize];
            do {
                int block = partSize > bufferSize ? bufferSize : (int) partSize;
                int len = randomFile.read(buf, 0, block);
                out.write(buf, 0, len);
                partSize -= block;
            } while (partSize > 0);
            System.out.println("sent " + movieFIle.getAbsolutePath() + " " + rangeStart + "-" + rangeEnd);
        } catch (IOException e) {

            System.out.println("전송이 취소 되었음");
        } finally {
            randomFile.close();
        }
    }

    protected void renderMergedOutputModel(HttpServletRequest request, HttpServletResponse response) throws Exception {
        final File movieFIle = new File(FILE_PATH);
        final RandomAccessFile randomFile = new RandomAccessFile(movieFIle, "r");

        long rangeStart = 0;
        long rangeEnd = 0;
        boolean isPart = false;


        try {
            long movieSize = randomFile.length();//
            String range = request.getHeader("range");
            System.out.println("range: {}"+ range);


            if (range != null) {
                if (range.endsWith("-")) {
                    range = range + (movieSize - 1);
                }
                int idxm = range.trim().indexOf("-");
                rangeStart = Long.parseLong(range.substring(6, idxm));
                rangeEnd = Long.parseLong(range.substring(idxm + 1));
                if (rangeStart > 0) {
                    isPart = true;
                }
            } else {
                rangeStart = 0;
                rangeEnd = movieSize - 1;
            }

            long partSize = rangeEnd - rangeStart + 1;
            System.out.println("accepted range: {}"+ rangeStart + "-" + rangeEnd + "/" + partSize + " isPart:" + isPart);
            response.reset();
            response.setStatus(isPart ? 206 : 200);
            response.setContentType("video/mp4");//

            response.setHeader("Content-Range", "bytes " + rangeStart + "-" + rangeEnd + "/" + movieSize);
            response.setHeader("Accept-Ranges", "bytes");
            response.setHeader("Content-Length", "" + partSize);

            OutputStream out = response.getOutputStream();
            randomFile.seek(rangeStart);


            int bufferSize = 8 * 1024;
            byte[] buf = new byte[bufferSize];
            do {
                int block = partSize > bufferSize ? bufferSize : (int) partSize;
                int len = randomFile.read(buf, 0, block);
                out.write(buf, 0, len);
                partSize -= block;
            } while (partSize > 0);
            System.out.println("sent " + movieFIle.getAbsolutePath() + " " + rangeStart + "-" + rangeEnd);
        } catch (IOException e) {

            System.out.println("error="+e.toString());
        } finally {
            randomFile.close();
        }
    }
    public void download(HttpServletResponse response)  {

        // Get your file stream from wherever.
        //  InputStream myStream = someClass.returnFile();
        InputStream videoFileStream = null;
        try {
            videoFileStream = new FileInputStream(FILE_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Set the content type and attachment header.
        response.addHeader("Content-disposition", "attachment;filename="+"a.mp4");
        response.setContentType("video/mp4");
        // response.setHeader("max-age","8640000");

        // Copy the stream to the response's output stream.
        try {
            IOUtils.copy(videoFileStream, response.getOutputStream());
        } catch (IOException e) {
            System.out.println("2="+e.toString());
            e.printStackTrace();
        }
        try {
            response.flushBuffer();

        } catch (IOException e) {
            System.out.println("3="+e.toString());
            e.printStackTrace();
        }
    }
}