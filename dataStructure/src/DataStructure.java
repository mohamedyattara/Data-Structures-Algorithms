import java.util.Comparator;

import heap.Heap;
import queue.PriorityQueue;
import tree.bst;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class DataStructure {

    /**
     * No argument constructor--private to prevent instantiation.
     */
    private DataStructure() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("=== Testing BST ===");
        bst<Integer> tree = new bst<>();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(12);
        tree.insert(3);

        System.out.print("Inorder: ");
        tree.inorder(); // should print 3 5 10 12 15

        System.out.println("Search 12: " + tree.search(12)); // true
        System.out.println("Search 7: " + tree.search(7)); // false

        tree.delete(10); // delete root with 2 children
        System.out.print("Inorder after deleting 10: ");
        tree.inorder(); // should print 3 5 12 15

        System.out.println("\n=== testing Heap ===");
        Comparator<Integer> order = Comparator.naturalOrder();
        Heap<Integer> heap = new Heap<>(10, order);
        heap.insert(20);
        heap.insert(5);
        heap.insert(15);
        heap.insert(10);

        System.out.println("Peek (min): " + heap.peek()); // 5
        System.out.println("Extract min: " + heap.extractTop()); // 5
        System.out.println("Peek after extract: " + heap.peek()); // 10

        // Max-heap example
        Comparator<Integer> order2 = Comparator.reverseOrder();
        Heap<Integer> maxHeap = new Heap<>(10, order2);
        maxHeap.insert(20);
        maxHeap.insert(5);
        maxHeap.insert(15);
        maxHeap.insert(10);

        System.out.println("Peek (max): " + maxHeap.peek()); // 20
        System.out.println("Extract max: " + maxHeap.extractTop()); // 20
        System.out.println("Peek after extract: " + maxHeap.peek()); // 15

        System.out.println("\n=== Testing PriorityQueue ===");
        PriorityQueue<Integer> pq = new PriorityQueue<>(20, order);
        pq.insert(50);
        pq.insert(30);
        pq.insert(40);

        System.out.println("Peek: " + pq.peek()); // 30
        System.out.println("Poll: " + pq.poll()); // 30
        System.out.println("Peek after poll: " + pq.peek()); // 40

    }

}
