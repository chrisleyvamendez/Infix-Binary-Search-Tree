
public class Driver {
    public static void main(String[] args) {
        System.out.println("working");

        EvalTree tree = new EvalTree();
        tree.root = new Node("+", new Node("5"), new Node("/", new Node("7"), new Node("2")));
        System.out.println(tree);


        System.out.println(tree.evaluate());


    }

}