/**
 * Obtenido de:
 * https://www.youtube.com/watch?v=22AE6WklXBg&ab_channel=Codingraph
 */
public class Nodo<K, V> {
    Nodo root;
    Nodo right;
    Nodo left;
    K key;
    V value;

    /**
     * Constructor for the class
     * 
     * @param key
     */
    public Nodo(K key) {
        this.key = key;
        root = null;
        right = null;
        left = null;
        value = null;
    }

}
