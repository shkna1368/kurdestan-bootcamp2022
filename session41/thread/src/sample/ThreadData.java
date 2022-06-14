package sample;

import java.util.ArrayList;
import java.util.List;

public class ThreadData implements Runnable{
  private   List<String> data;

    public List<String> getData() {
        return data;
    }

    public ThreadData setData(List<String> data) {
        this.data = data;
        return this;
    }

    public ThreadData() {
        data=new ArrayList<>();
    }

    @Override
    public void run() {

        for (int i=0;i<10000000;i++){


            data.add("data "+i);
        }

    }

    public  void remove(int i){
       synchronized (this){
           data.remove(i);
       }



    }
}
