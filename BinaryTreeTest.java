import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    BinaryTree<String, String> bt = new BinaryTree<>();

    @org.junit.jupiter.api.Test
    void insert() {
        bt.insert("house", "casa");
        assertEquals(bt.search("house"), "casa");
    }

    @org.junit.jupiter.api.Test
    void search() {
        bt.insert("horse", "caballo");
        assertEquals(bt.search("horse"), "caballo");
    }
}