package list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArraylistDemo {


    public static void main(String[] args) {
        List<String> al=new ArrayList<>();
        System.out.println("initial size:"+al.size());

        //add item

        al.add("C");
        al.add("A");
        al.add("E");
        al.add("B");
        al.add("D");
        al.add("F");
        al.add(1,"A2");

        System.out.println("size after additions="+al.size());
        System.out.println("contents:"+al);

        //iterate
        Iterator itr=al.iterator();

        while (itr.hasNext()){
            String element= (String) itr.next();
            System.out.println(element);
        }
        System.out.println("-----------");

        for(String v:al){
            System.out.println(v);
        }
        System.out.println("-------");



        String selectedItem=al.get(0);
        System.out.println("item 0="+selectedItem);

  al.remove("F");
  al.remove(2);
        System.out.println("size:"+al.size());
        System.out.println("content:"+al);

    }
}
