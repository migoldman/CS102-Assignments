package utilities;

public interface AssociativeMap<K extends Comparable<K>, D> {
    
    public void insert(K key, D data);
    
    public D delete(K key);
    
    public D lookUp(K key);
    
    public Queue<Association<K,D>> elements();
    
}
