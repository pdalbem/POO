import java.util.Comparator;
import java.util.PriorityQueue;

class MyComparator implements Comparator<String> {
    @Override
    public int compare(String x, String y) {
        return x.length() - y.length();
    }
}

public class priorityqueue_basics_1 {
    public static void main(String[] args) {

        // declaring the priority queue
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // adding elments to the priority queue
        priorityQueue.add(100);
        priorityQueue.add(20);
        priorityQueue.add(10);
        priorityQueue.add(140);

        PriorityQueue<String> queue = new PriorityQueue<String>(15, new MyComparator());
        queue.add("Tyrion Lannister");
        queue.add("Daenerys Targaryen");
        queue.add("Arya Stark");
        queue.add("Petyr 'Littlefinger' Baelish");

        /*
         * What I am doing here is removing the highest
         * priority element from Queue and displaying it.
         * The priority I have set is based on the string
         * length. The logic for it is written in Comparator
         */
        while (queue.size() != 0) {
            System.out.println(queue.poll());

        }

        // check whether the priorityqueue contains the element or not based on object passed
        priorityQueue.contains(10);

        // alternative of add method
        priorityQueue.offer(10000);

        // returns the head of the priorityqueue
        priorityQueue.peek();

        // remove the head of the queue
        priorityQueue.poll();

        // remove the element based on the object
        priorityQueue.remove(20);

        // get the size of the priority queue
        priorityQueue.size();

        // convert the priority queue to array
        priorityQueue.toArray();

        // remove entire content from the priority queue
        priorityQueue.clear();
    }
}
