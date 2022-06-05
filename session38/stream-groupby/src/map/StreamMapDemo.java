package map;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamMapDemo {

    public static void main(String[] args) {
        List<Double> myList=new ArrayList<>();
        myList.add(7.0);
        myList.add(18.0);
        myList.add(10.0);
        myList.add(24.0);
        myList.add(17.0);
        myList.add(5.0);

        Stream<Double> sqrt=myList.stream().map((a)->Math.sqrt(a));
        double result=sqrt.reduce(1.0,(a,b)->a*b);

        System.out.println(result);
    }
}
