// driver class to run evaluate tree class and print output
public class Driver {
    public static void main(String[] args) {
        var tree = new EvalTree();
        System.out.println("Start Testing");
        System.out.println("----------------------");
        testAlpha();
        testBravo();
        testCharlie();
        testDelta();
        testEcho();
        testFox();
        testGolf();
        testHotel();
        testIndia();
        testJuliet();
        System.out.println("----------------------");
        System.out.println(tree.about());



    }
    //tests
    private static void testAlpha() {
        var tree = new EvalTree();
        tree.root  = new Node("*",
                // left child
                new Node("2.5"),
                // right child
                new Node("+", new Node("1"), new Node("4")));
        System.out.println(tree + " ----> " + tree.evaluate());
    }
    private static void testBravo() {
        var tree = new EvalTree();
        tree.root = new Node("+",
                new Node("*", new Node("5"), new Node("26")),
                new Node("/", new Node("-", new Node("20"), new Node("2")), new Node("2")));
        System.out.println(tree + " ----> " + tree.evaluate());
    }
    private static void testCharlie() {
        var tree = new EvalTree();
        tree.root = new Node("^",
                new Node("+", new Node("5"), new Node("26")),
                new Node("-", new Node("+", new Node("1"), new Node("2")), new Node("2")));
        System.out.println(tree + " ----> " + tree.evaluate());
    }
    private static void testDelta(){
        var tree = new EvalTree();
        tree.root  = new Node("%",
                // left child
                new Node("10"),
                // right child
                new Node("+", new Node("1"), new Node("4")));
        System.out.println(tree + " ----> " + tree.evaluate());
    }

    private static void testEcho() {
        var tree = new EvalTree();
        tree.root  = new Node("/",
                // left child
                new Node("1026"),
                // right child
                new Node("^", new Node("3"), new Node("3")));
        System.out.println(tree + " ----> " + tree.evaluate());

    }
    private static void testFox() {
        var tree = new EvalTree();
        tree.root = new Node("*",
                // left child
                new Node("/", new Node("9020"), new Node("20")),
                // right child
                new Node("+", new Node("200"), new Node("23")));
        System.out.println(tree + " ----> " + tree.evaluate());
    }

    private static void testGolf() {

        var tree = new EvalTree();
        tree.root = new Node("%",
                // left child
                new Node("%", new Node(" 10"), new Node("6")), // 4
                // right child
                new Node("%", new Node("90"), new Node("7"))); // 7
        System.out.println(tree + " ----> " + tree.evaluate());
    }
    private static void testHotel() {
        var tree = new EvalTree();
        tree.root = new Node("+",
                new Node("10"),
                new Node("^", new Node("10"), new Node("8")));
        System.out.println(tree + " ----> " + tree.evaluate());
    }
    private static void testIndia() {
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
        System.out.println(master + " ----> " + master.evaluate());


    }
    // this is a lot of code, but i wanted to build a mega tree
    private static void testJuliet(){
        var master = new EvalTree();
        var leftBranch = new EvalTree();
        var rightBranch = new EvalTree();

        leftBranch.root = new Node("^",
                new Node("+", new Node("5"), new Node("26")),
                new Node("-", new Node("+", new Node("1"), new Node("2")), new Node("2")));

        // 12.5
        rightBranch.root  = new Node("*",
                // left child
                new Node("2.5"),
                // right child
                new Node("+", new Node("1"), new Node("4")));

        var leftMaster = new EvalTree();
        leftMaster.root = new Node("/",
                // left child
                new Node("1026"),
                // right child
                new Node("^", new Node("3"), new Node("3"))); // 38
        var rightMaster = new EvalTree();
        rightMaster.root =  new Node("%",
                // left child
                new Node("%", new Node(" 10"), new Node("6")), // 4
                // right child
                new Node("%", new Node("90"), new Node("7"))); // 7

        master.root = new Node("-", leftBranch.root, rightBranch.root);
        var children = new EvalTree();
        children.root = new Node("+", leftMaster.root, rightMaster.root);

        var totalTree = new EvalTree();
        totalTree.root = new Node("+", master.root, children.root);

        System.out.println(totalTree + " ----> " + totalTree.evaluate());



    }


}