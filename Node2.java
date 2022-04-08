/**
 * Obtenido de: https://www.baeldung.com/java-binary-tree
 */

public class Node2 {
    String value;
    Node2 left;
    Node2 right;
    Node2 root;

    public String getValueOf() {
        return value;
    }

    public Node2(String value) {
        this.value = value;
        left = null;
        right = null;
    }

    public int ScompareTo(String s1, String s2) {
        int ans = s1.compareTo(s2);
        return ans;
    }

    public Node2 addRecursive(Node2 current, String value) {

        if (current == null) {
            return new Node2(value);
        }

        if (ScompareTo(value, current.value) < 1) {
            current.left = addRecursive(current.left, value);
            if (ScompareTo(value, current.value) > 0)
                current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public void add(String value) {
        root = addRecursive(root, value);
    }

    private boolean ScompareTo_boolean(String str1, String str2) {
        if (ScompareTo(str1, str2) < 0) {
            return true;
        } else {
            return false;
        }
    }

    // Method to see if the Binary Tree contains an speciphic value. Returns boolean
    // True if it does.
    private boolean containsNodeRecursive(Node2 current, String String) {

        if (current == null) {
            return false;
        }

        if (ScompareTo(value, current.value) == 0) {
            return true;
        }

        return ScompareTo_boolean(value, current.value) ? containsNodeRecursive(current.left, value)
                : containsNodeRecursive(current.right, value);

    }

    public boolean containsNode(String value) {
        return containsNodeRecursive(root, value);
    }

}
