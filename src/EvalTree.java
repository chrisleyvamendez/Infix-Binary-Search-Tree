
public class EvalTree {
    Node root;
    public EvalTree() {
    }
    public EvalTree(Node root){
        this.root = root;

    }
    @Override
    public String toString() {
        return root.toString();
    }

    /**
     * Recursively calls evaluate method on the root node
     * @return Double value
     */
    public Double evaluate(){
        return root.evaluate();
    }

}