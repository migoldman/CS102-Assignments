package utilities;


public class AssociativeMapBST<K extends Comparable<K>, D> 
                               implements AssociativeMap<K,D> {
    
    BSTree<Association<K,D>> bsTree;
    
    public AssociativeMapBST() {
        bsTree = new BSTree<Association<K,D>>();
    }
    
    public void insert(K key, D data) {
        bsTree.insert(new Association<K,D>(key,data));
    }
    
    public D delete(K key) {
        Association<K,D> value = bsTree.delete(new Association<K,D>(key));
        if (value==null) return null;
        else return value.data;        
    }
    
    public D lookUp(K key) {
        Association<K,D> value = bsTree.member(new Association<K,D>(key));
        if (value==null) return null;
        else return value.data;
    }
    
    public Queue<Association<K,D>> elements() {
        return bsTree.elements();
    }
    
}
