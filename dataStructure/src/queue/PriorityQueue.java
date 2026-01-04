package queue;

import heap.MinHeap;

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
    private MinHeap<T> heap;

    public PriorityQueue(int capacity) {
        this.heap = new MinHeap<>(capacity);
    }

    /** Adds an element to the priority queue */
    public void enqueue(T value) {
        this.heap.insert(value);
    }

    /** Removes and returns the highest-priority element (smallest) */
    public T dequeue() {
        return this.heap.extractMin();
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
