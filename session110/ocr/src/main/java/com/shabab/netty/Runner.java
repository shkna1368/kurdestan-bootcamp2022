package com.shabab.netty;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

import java.io.File;

public class Runner {
    public static void main(String[] args) throws TesseractException {

        String[] source = {"1.jpg","2.jpg","3.jpg"};


        File tmpFolder = LoadLibs.extractTessResources("win32-x86-64"); // Change this argument, depending on your platform
        System.setProperty("java.library.path", tmpFolder.getPath());
        System.out.println("native libraries extracted to: " + tmpFolder.getPath());

        Tesseract tesseract = new Tesseract();
       tesseract.setDatapath("src\\main\\resources\\tessdata");
       tesseract.setLanguage("eng+fas+kur+ara");

        for (int i = 0; i < source.length; i++) {


            File image = new File("C:\\ocr\\"+source[i]);

    /*    tesseract.setPageSegMode(1);
        tesseract.setOcrEngineMode(1);*/
            String result = tesseract.doOCR(image);
            System.out.println(result);
            System.out.println("-----------------------NEXT-------------------");


        }
    }
}
