package sample;

import java.util.ArrayList;
import java.util.List;

public class DataDemo {

    public static void main(String[] args) {
        Long startTime=System.currentTimeMillis();

        List<String> allData=new ArrayList<>();


       ThreadData threadData1=new ThreadData();
       ThreadData threadData2=new ThreadData();


      // threadData1.run();
      // threadData2.run();
        Thread tr1=new Thread(threadData1,"tr1");
        Thread tr2=new Thread(threadData2,"tr2");

        tr1.start();
        tr2.start();

        try {
            tr1.join();
            tr2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        allData.addAll(threadData1.getData());
        allData.addAll(threadData2.getData());

        System.out.println("all data size:"+allData.size());

        Long endTime=System.currentTimeMillis();

        System.out.println("Duration:"+(endTime-startTime));

    }
}
