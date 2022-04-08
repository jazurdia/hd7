public class BinayTree<K, V> {
    Nodo root;

    public BinayTree() {
        root = null;
    }

    public void insert(K key, V value) {
        Nodo n = new Nodo(key);
        n.value = value;

        if (root == null) {
            root = n;
        } else {
            Nodo current = root;
            while (current != null) {
                n.root = current;
                if (((String) key).compareTo((String) current.key) <= 0) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }

            if (((String) key).compareTo((String) n.root.key) < 0) {
                n.root.left = n;
            } else {
                n.root.right = n;
            }

        }

    }

    public V search(K key) {
        Nodo current = root;
        while (current != null) {
            if (((String) key).compareTo((String) current.key) == 0) {
                return (V) current.value;
            } else if (((String) key).compareTo((String) current.key) < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return null;
    }

}
