public class BinaryTree<K, V> {
    Nodo root;

    /**
     * Constructor for the class
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Inserts a new node with the given key and value
     * @param key   the key of the new node
     * @param value the value of the new node
     */
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

    /**
     * Searches for a node with the given key
     * 
     * @param key the key of the node to search for
     * @return the node with the given key or null if it doesn't exist
     */
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

    /**
     * Prints the tree inorder (left, root, right)
     * 
     * @param n the node to start from
     */
    public void inOrder(Nodo n) {
        if (n != null) {
            inOrder(n.left);
            System.out.println(n.key + "," + n.value);
            inOrder(n.right);
        }
    }

    /**
     * 
     * @param key the key of the node to start from
     */
    public void delete(K key) {
        Nodo current = root;
        Nodo parent = null;
        while (current != null) {
            if (((String) key).compareTo((String) current.key) == 0) {
                if (parent == null) {
                    root = null;
                } else if (((String) key).compareTo((String) parent.key) < 0) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                return;
            } else if (((String) key).compareTo((String) current.key) < 0) {
                parent = current;
                current = current.left;
            } else {
                parent = current;
                current = current.right;
            }
        }
    }

}
