import javax.swing.plaf.nimbus.NimbusLookAndFeel;

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
