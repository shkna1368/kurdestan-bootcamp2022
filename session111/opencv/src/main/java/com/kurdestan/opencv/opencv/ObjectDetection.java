package com.kurdestan.opencv.opencv;

import org.opencv.core.*;
import org.opencv.dnn.DetectionModel;
import org.opencv.dnn.Dnn;
import org.opencv.dnn.Net;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ObjectDetection

//code from :https://lindevs.com/yolov4-object-detection-using-opencv

{
    static {

        System.load("E:\\DevTools\\opencv\\opencv\\build\\java\\x64\\opencv_java460.dll");


    }

    public static void main(String[] args) throws IOException
    {
        Mat img = Imgcodecs.imread("C:\\Users\\Java\\Desktop\\opencv\\img\\im1.jpg");
      // Mat img = Imgcodecs.imread("C:\\Users\\Java\\Desktop\\opencv\\img\\2.jpg");
        //Mat img = Imgcodecs.imread("C:\\Users\\Java\\Desktop\\opencv\\img\\7.jpg");
        //Mat img = Imgcodecs.imread("C:\\Users\\Java\\Desktop\\opencv\\img\\9.jpg");
     //   Mat img = Imgcodecs.imread("C:\\Users\\Java\\Desktop\\opencv\\img\\14.jpg");
       // Mat img = Imgcodecs.imread("C:\\Users\\Java\\Desktop\\opencv\\img\\12.jpeg");
        //Mat img = Imgcodecs.imread("C:\\Users\\s.koohi\\Desktop\\opencv\\3.jpeg");
        //Mat img = Imgcodecs.imread("C:\\Users\\Java\\Desktop\\opencv\\img\\zidane.jpeg");
       // Mat img = Imgcodecs.imread("C:\\Users\\Java\\Desktop\\opencv\\img\\3.jpg");

        List<String> classes = Files.readAllLines(Paths.get("E:\\DevTools\\opencv\\yolov4\\coco.names"));


        //download from https://github.com/alexeyab/darknet/releases
        Net net = Dnn.readNetFromDarknet("E:\\DevTools\\opencv\\yolov4\\yolov4.cfg", "E:\\DevTools\\opencv\\yolov4\\yolov4.weights");

        DetectionModel model = new DetectionModel(net);
        model.setInputParams(1 / 255.0, new Size(416, 416), new Scalar(0), true);

        MatOfInt classIds = new MatOfInt();
        MatOfFloat scores = new MatOfFloat();
        MatOfRect boxes = new MatOfRect();
        model.detect(img, classIds, scores, boxes, 0.6f, 0.4f);

        for (int i = 0; i < classIds.rows(); i++) {
            Rect box = new Rect(boxes.get(i, 0));
            Imgproc.rectangle(img, box, new Scalar(0, 255, 0), 2);

            int classId = (int) classIds.get(i, 0)[0];
            double score = scores.get(i, 0)[0];
            String text = String.format("%s: %.2f", classes.get(classId), score);
            Imgproc.putText(img, text, new Point(box.x, box.y - 5),
                    Imgproc.FONT_HERSHEY_SIMPLEX, 1, new Scalar(0, 255, 0), 2);
        }

        HighGui.imshow("Image", img);
        HighGui.waitKey(0);
        HighGui.destroyAllWindows();

        System.exit(0);
    }
}