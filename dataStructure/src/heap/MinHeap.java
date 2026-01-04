package heap;

/**
 * MinHeap implementation using an array.
 *
 * Heap Property: - Parent <= Left Child - Parent <= Right Child
 *
 * Time Complexity: - insert: O(log n) - extractMin: O(log n) - peek: O(1)
 *
 * Space Complexity: O(n)
 */
public class MinHeap<T extends Comparable<T>> {

    private T[] heap;
    private int size;
    private int capacity;

    /**
     * Constructs a MinHeap with a given capacity.
     */
    @SuppressWarnings("unchecked")
    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = (T[]) new Object[capacity];
    }

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

    private void siftDown(T[] array, int index) {

        int last = array.length - 1;

        int left = this.leftChild(index);
        int right = this.rightChild(index);
        if (left <= last) {
            int smallest = left;
            if (right <= last && array[right].compareTo(array[smallest]) < 0) {
                smallest = right;
            }
            if (array[index].compareTo(array[smallest]) > 0) {
                this.swap(array, index, smallest);
                this.siftDown(array, smallest);
            }
        }
    }

    public void insert(T Value) {
        if (this.size == this.capacity) {
            throw new IllegalStateException("Heap is full");
        }
        this.heap[this.size] = Value;
        int current = this.size;
        this.size++;

        while (current > 0
                && this.heap[current].compareTo(this.heap[this.parent(current)]) < 0) {
            this.swap(this.heap, current, this.parent(current));
            current = this.parent(current);
        }

    }

    public T peek() {
        if (this.size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return this.heap[0];

    }

    public T extractMin() {
        if (this.size == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        T min = this.heap[0];
        this.swap(this.heap, 0, this.size - 1);
        this.size--;
        this.siftDown(this.heap, 0);

        return min;
    }

    public void heapify() {
        for (int i = (this.size / 2) - 1; i >= 0; i--) {
            this.siftDown(this.heap, i);
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int getSize() {
        return this.size;
    }

}
