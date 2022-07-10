import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class NodeTest {
    @Test
    void testAdd() {
        var tree = new EvalTree();
        tree.root = new Node("+", new Node("5"), new Node("/", new Node("7"), new Node("2")));
        // we want to verify that it is returning the value we want
        // we need to assert the method call
        assertEquals(8.5, tree.evaluate());
    }
    @Test
    void testProduct(){
        var tree = new EvalTree();
        tree.root  = new Node("*",
                // left child
                new Node("2.5"),
                // right child
                new Node("+", new Node("1"), new Node("4")));
        assertEquals(12.5, tree.evaluate());
    }
    @Test
    void testDelta() {
        var tree = new EvalTree();
        tree.root = new Node("+",
                new Node("*", new Node("5"), new Node("26")),
                new Node("/", new Node("-", new Node("20"), new Node("2")), new Node("2")));
        assertEquals(139, tree.evaluate());
    }
    @Test
    void testPowers() {
        var tree = new EvalTree();
        tree.root = new Node("^",
                new Node("+", new Node("5"), new Node("26")),
                new Node("-", new Node("+", new Node("1"), new Node("2")), new Node("2")));
        assertEquals(31, tree.evaluate());
    }
    @Test
    void testModulo(){
        var tree = new EvalTree();
        tree.root  = new Node("%",
                // left child
                new Node("10"),
                // right child
                new Node("+", new Node("1"), new Node("4")));
        assertEquals(0, tree.evaluate());

    }
    @Test
    void testDivide() {
        var tree = new EvalTree();
        tree.root  = new Node("/",
                // left child
                new Node("1026"),
                // right child
                new Node("^", new Node("3"), new Node("3")));
        assertEquals(38, tree.evaluate());
    }
    @Test
    void testAlpha() {
        var tree = new EvalTree();
        tree.root = new Node("*",
                // left child
                new Node("/", new Node("9020"), new Node("20")),
                // right child
                new Node("+", new Node("200"), new Node("23")));
        assertEquals(100573, tree.evaluate());
    }
    @Test
    void testBravo(){
        var tree = new EvalTree();
        tree.root = new Node("%",
                // left child
                new Node("%", new Node(" 10"), new Node("6")), // 4
                // right child
                new Node("%", new Node("90"), new Node("7"))); // 7
        assertEquals(4, tree.evaluate());
    }
    @Test
    void TestCharlie() {
        var tree = new EvalTree();
        tree.root = new Node("+",
                new Node("10"),
                new Node("^", new Node("10"), new Node("8")));

        assertEquals(100000010, tree.evaluate());
    }
    @Test
    void TestNTrees() {
        var master = new EvalTree();
        var leftBranch = new EvalTree();
        var rightBranch = new EvalTree();

        // == 31
        leftBranch.root = new Node("^",
                new Node("+", new Node("5"), new Node("26")),
                new Node("-", new Node("+", new Node("1"), new Node("2")), new Node("2")));

        // 12.5
        rightBranch.root  = new Node("*",
                // left child
                new Node("2.5"),
                // right child
                new Node("+", new Node("1"), new Node("4")));
        // 31 + 12.5
        master.root = new Node("+", leftBranch.root, rightBranch.root);

        assertEquals(43.5, master.evaluate());


    }


}