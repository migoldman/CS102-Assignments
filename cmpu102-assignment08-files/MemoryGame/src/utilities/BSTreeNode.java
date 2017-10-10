package utilities;

class BSTreeNode<T extends Comparable<T>> {

    private T data;
    private BSTreeNode<T> left;
    private BSTreeNode<T> right;

    public BSTreeNode(T d) {
        data = d;
        left = null;
        right = null;
    }

    public void insert(T d) {
        int cmp = d.compareTo(data);
        if (cmp == 0) {
            data = d;
            return;
        }
        if (cmp < 0) {
            if (left != null) {
                left.insert(d);
            } else {
                left = new BSTreeNode<T>(d);
            }
        } else if (right != null) {
            right.insert(d);
        } else {
            right = new BSTreeNode<T>(d);
        }
    }

    public BSTreeNode<T> delete(T d) {
        int cmp = d.compareTo(data);
        if (cmp == 0) {
            return deleteRoot();
        } else {
            if (cmp < 0) {
                if (left != null) {
                    left = left.delete(d);
                }
            } else {
                if (right != null) {
                    right = right.delete(d);
                }
            }
            return this;
        }
    }

    private BSTreeNode<T> deleteRoot() {
        if (left != null) {
            data = left.max();
            left = left.deleteMax();
            return this;
        } else {
            return right;
        }
    }

    public T member(T d) {
        int cmp = d.compareTo(data);
        if (cmp == 0) {
            return data;
        }
        if (cmp < 0) {
            if (left == null) {
                return null;
            } else {
                return left.member(d);
            }
        } else {
            if (right == null) {
                return null;
            } else {
                return right.member(d);
            }
        }
    }

    public T min() {
        if (left == null) {
            return data;
        } else {
            return left.min();
        }
    }

    public BSTreeNode<T> deleteMin() {
        if (left == null) {
            return right;
        } else {
            left = left.deleteMin();
            return this;
        }
    }

    public T max() {
        if (right == null) {
            return data;
        } else {
            return right.max();
        }
    }

    public BSTreeNode<T> deleteMax() {
        if (right == null) {
            return left;
        } else {
            right = right.deleteMax();
            return this;
        }
    }

    public T value() {
        return data;
    }

    public BSTreeNode<T> left() {
        return left;
    }

    public BSTreeNode<T> right() {
        return right;
    }

    public void enQueueElements(Queue<T> queue) {
        if (left != null) {
            left.enQueueElements(queue);
        }
        queue.enQueue(data);
        if (right != null) {
            right.enQueueElements(queue);
        }
    }
}
