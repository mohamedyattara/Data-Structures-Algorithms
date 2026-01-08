package tree;

public class bst<T extends Comparable<T>> {

    /** Inner class for BST nodes */
    private static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;

        Node(T value) {
            this.value = value;
            this.left = null;
            this.right = null;

        }
    }

    private Node<T> root;
    private int size;

    public bst() {
        this.root = null;
        this.size = 0;
    }

    public void insert(T value) {
        this.root = this.insertRec(this.root, value);
    }

    private Node<T> insertRec(Node<T> node, T value) {
        if (node == null) {
            return new Node<>(value);
        }

        if (value.compareTo(node.value) < 0) {
            node.left = this.insertRec(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = this.insertRec(node.right, value);
        }

        return node;
    }

    public boolean search(T value) {
        return this.searchRec(this.root, value);
    }

    private boolean searchRec(Node<T> node, T value) {
        if (node == null) {
            return false;
        }

        if (value.compareTo(node.value) == 0) {
            return true;
        } else if (value.compareTo(node.value) < 0) {
            return this.searchRec(node.left, value);
        } else {
            return this.searchRec(node.right, value);
        }
    }

    public void delete(T value) {
        this.root = this.deleteRec(this.root, value);
    }

    private Node<T> deleteRec(Node<T> node, T value) {
        if (node == null) {
            return null;
        }

        if (value.compareTo(node.value) < 0) {
            node.left = this.deleteRec(node.left, value);
        } else if (value.compareTo(node.value) > 0) {
            node.right = this.deleteRec(node.right, value);
        } else {
            // Node to delete found

            // Case 1: No child
            if (node.left == null && node.right == null) {
                return null;
            }

            // Case 2: One child
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            // Case 3: Two children
            T minValue = this.FindMin(node.right);
            node.value = minValue;
            node.right = this.deleteRec(node.right, minValue);

        }

        return node;
    }

    /* ================== Find Min / Max ================== */

    public T FindMin() {
        return this.FindMin(this.root);
    }

    private T FindMin(Node<T> node) {
        if (node == null) {
            return null;
        } else if (node.left == null) {

            return node.value;
        } else {

            return this.FindMin(node.left);
        }

    }

    /* ================== Traversals ================== */

    public void inorder() {
        this.inorderRec(this.root);
        System.out.println();
    }

    private void inorderRec(Node<T> node) {
        if (node != null) {
            this.inorderRec(node.left);
            System.out.print(node.value + " ");
            this.inorderRec(node.right);
        }
    }

    public void preorder() {
        this.preorderRec(this.root);
        System.out.println();
    }

    private void preorderRec(Node<T> node) {
        if (node != null) {
            System.out.print(node.value + " ");
            this.preorderRec(node.left);
            this.preorderRec(node.right);
        }
    }

    public void postorder() {
        this.postorderRec(this.root);
        System.out.println();
    }

    private void postorderRec(Node<T> node) {
        if (node != null) {
            this.postorderRec(node.left);
            this.postorderRec(node.right);
            System.out.print(node.value + " ");
        }
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void clear() {
        this.root = null;
    }

}
