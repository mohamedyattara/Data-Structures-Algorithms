package heap;

import java.util.Comparator;

/**
 * MinHeap implementation using an array.
 *
 * Heap Property: - Parent <= Left Child - Parent <= Right Child
 *
 * Time Complexity: - insert: O(log n) - extractMin: O(log n) - peek: O(1)
 *
 * Space Complexity: O(n)
 */
public class Heap<T> {

    private T[] heap;
    private int size;
    private int capacity;
    private Comparator<T> order;

    /**
     * Constructs a MinHeap with a given capacity.
     */
    @SuppressWarnings("unchecked")
    public Heap(int capacity, Comparator<T> order) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = (T[]) new Object[capacity];
        this.order = order;
    }

    /**
     * helper Methods
     */
    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * Restores heap property by pushing element down.
     */
    private void siftDown(T[] array, int index, Comparator<T> order) {

        int last = this.size - 1;

        int left = this.leftChild(index);
        int right = this.rightChild(index);
        if (left <= last) {
            int smallest = left;
            if (right <= last && order.compare(array[right], (array[smallest])) < 0) {
                smallest = right;
            }
            if (order.compare(array[index], (array[smallest])) > 0) {
                this.swap(array, index, smallest);
                this.siftDown(array, smallest, order);
            }
        }
    }

    /**
     * core operation
     */
    /**
     * Inserts a value into the heap.
     */
    public void insert(T value) {
        if (this.size == this.capacity) {
            throw new IllegalStateException("Heap is full");
        }
        // Place value at the end
        this.heap[this.size] = value;
        int current = this.size;
        this.size++;
        // Bubble up
        while (current > 0 && this.order.compare(this.heap[current],
                (this.heap[this.parent(current)])) < 0) {
            this.swap(this.heap, current, this.parent(current));
            current = this.parent(current);
        }

    }

    /**
     * Returns the minimum element without removing it.
     */
    public T peek() {
        if (this.size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return this.heap[0];

    }

    /**
     * Removes and returns the minimum element.
     */
    public T extractTop() {
        if (this.size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        T top = this.heap[0];
        // Move last element to root
        this.swap(this.heap, 0, this.size - 1);
        this.size--;
        // Restore heap property
        this.siftDown(this.heap, 0, this.order);

        return top;
    }

    public void heapify() {
        for (int i = (this.size / 2) - 1; i >= 0; i--) {
            this.siftDown(this.heap, i, this.order);
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getSize() {
        return this.size;
    }

}
