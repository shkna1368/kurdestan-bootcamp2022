package com.kurdestan.opencv.opencv;

import org.opencv.core.*;

import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import java.io.IOException;
import org.opencv.objdetect.CascadeClassifier;


public class Face

//code from :https://lindevs.com/yolov4-object-detection-using-opencv
//https://www.geeksforgeeks.org/image-processing-in-java-face-detection/

  //  https://github.com/opencv/opencv/tree/master/data/haarcascades
{
    static {

        System.load("E:\\DevTools\\opencv\\opencv\\build\\java\\x64\\opencv_java460.dll");


    }

    public static void main(String[] args) {
        CascadeClassifier faceDetector = new CascadeClassifier("E:\\DevTools\\opencv\\yolov4\\haarcascade_frontalface_alt.xml");
        faceDetector.load(
                "E:\\DevTools\\opencv\\yolov4\\haarcascade_frontalface_alt.xml");

        // Reading the input image
        Mat image = Imgcodecs.imread("C:\\Users\\Java\\Desktop\\opencv\\img\\3.jpg");

        // Detecting faces
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image,
                faceDetections);

        // Creating a rectangular box which represents for
        // faces detected
        for (Rect rect : faceDetections.toArray()) {
            Imgproc.rectangle(
                    image, new Point(rect.x, rect.y),
                    new Point(rect.x + rect.width,
                            rect.y + rect.height),
                    new Scalar(0, 255, 0));
        }

        System.out.print("Face Detected");

        HighGui.imshow("Image", image);
        HighGui.waitKey(0);
        HighGui.destroyAllWindows();

        System.exit(0);
    }
}