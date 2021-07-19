package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MyHeap {
    private int[] array;

    public static void main(String[] args) {
        Integer[] array = new Integer[] {1,2,3,4,5};
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(Arrays.asList(array));
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }
    }
}

class my {

}