package filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {
        List<Integer> myList=new ArrayList<>();
        myList.add(7);
        myList.add(18);
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);
        Stream<Integer> integerStream=myList.stream();
        Optional<Integer> optionalInteger=integerStream.min(Integer::compareTo);
        if (optionalInteger.isPresent()){
            System.out.println(optionalInteger.get());
        }

        Optional<Integer> optionalInteger2=myList.stream().max(Integer::compareTo);
        if (optionalInteger2.isPresent()){
            System.out.println(optionalInteger2.get());
        }



        //filter
        System.out.println("-----------");
        var oddValue=myList.stream().sorted().filter((n)->(n%2)==1);
        oddValue.forEach(integer -> System.out.println(integer));

        System.out.println("-----------");

         oddValue=myList.stream().sorted().filter((n)->(n%2)==1)

                 .filter((n)->n>5);
        oddValue.forEach(integer -> System.out.println(integer));

        System.out.println("-----------");

        Optional<Integer> optionalValue=myList.stream().reduce((a,b)->a*b);
        int val=myList.stream().reduce(1,(a,b)->a*b);
        if (optionalValue.isPresent()){
            System.out.println(optionalValue.get());
        }
        System.out.println(val);



    }
}
