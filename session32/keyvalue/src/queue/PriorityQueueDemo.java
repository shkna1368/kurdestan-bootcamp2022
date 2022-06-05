package queue;

import java.util.PriorityQueue;

public class PriorityQueueDemo {

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        priorityQueue.add(10);
        priorityQueue.add(20);
        priorityQueue.add(15);
        System.out.println(priorityQueue.peek());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.peek());
    }
}
