package utilities;

public class BSTree<T extends Comparable<T>> implements PriorityQueue<T>, SortedSet<T> {

    private BSTreeNode<T> root;

    public BSTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public T insert(T d) {
        if (isEmpty()) {
            root = new BSTreeNode<T>(d);
        } else {
            root.insert(d);
        }
        return d;
    }

    public T delete(T d) {
        if (!isEmpty()) {
            root = root.delete(d);
        }
        return d;
    }

    public T member(T d) {
        if (isEmpty()) {
            return null;
        }
        return root.member(d);
    }

    public T min() {
        return root.min();
    }

    public T delete() {
        return deleteMin();
    }

    public T deleteMin() {
        T temp = root.min();
        root = root.deleteMin();
        return temp;
    }

    public T max() {
        return root.max();
    }

    public T deleteMax() {
        T temp = root.max();
        root = root.deleteMax();
        return temp;
    }
    
    public Queue<T> elements() {
        Queue<T> elementQueue = new QueueListDL<T>();
        if (root!=null) {
            root.enQueueElements(elementQueue);
        }
        return elementQueue;
    }
}
