package utilities;

public class BTree<D> {    
    public D data;
    public BTree<D> left, right;
    
    public BTree(D data) {
        this(data,null,null);
    }    
    
    public BTree(D data, BTree<D> left, BTree<D> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }    
}
