package list;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList<String> linkedList=new LinkedList<>();

        linkedList.add("Stev");
        linkedList.add("Carl");
        linkedList.add("Raj");

        linkedList.addFirst("Rebwar");
        linkedList.addLast("Rick");
        linkedList.add(2,"Helen");

        Iterator<String> iterator=linkedList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
