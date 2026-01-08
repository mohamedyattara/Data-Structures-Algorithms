package queue;

import java.util.Comparator;

import heap.Heap;

/**
 * Generic Priority Queue implementation backed by a MinHeap.
 *
 * Lower values have higher priority.
 *
 * Time Complexity: - enqueue: O(log n) - dequeue: O(log n) - peek: O(1)
 *
 * Space Complexity: O(n)
 */
public class PriorityQueue<T extends Comparable<T>> {
    private Heap<T> heap;
    private Comparator<T> order;

    public PriorityQueue(int capacity) {
        this.heap = new Heap<>(capacity, this.order);
    }

    /** Adds an element to the priority queue */
    public void enqueue(T value) {
        this.heap.insert(value);
    }

    /** Removes and returns the highest-priority element (smallest) */
    public T dequeue() {
        return this.heap.extractTop();
    }

    /** Returns the highest-priority element without removing it */
    public T peek() {
        return this.heap.peek();
    }

    public boolean isEmpty() {
        return this.heap.isEmpty();
    }

    public int size() {
        return this.heap.getSize();
    }
}
