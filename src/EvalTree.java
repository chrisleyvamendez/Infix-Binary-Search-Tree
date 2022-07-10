/**
 * Evaluate Tree class which acts as an interface for the user to run evaluate + print
 * the node's functions
 */
public class EvalTree {
    Node root;

    /**
     * No arg constructor
     */
    public EvalTree() {}

    /**
     * single argument constructor for instantiating node
     * @param root -> sets the value for the root
     */
    public EvalTree(Node root){
        this.root = root;
    }

    /**
     * Calls on the toString method from the root node
     * @return root.toString();
     */
    @Override
    public String toString() {
        return root.toString();
    }

    /**
     * Recursively calls evaluate method on the root node
     * @return Double value after calling on root nodes evaluate method
     */
    public Double evaluate(){
        return root.evaluate();
    }

    /**
     * Information class about the name, project, and professor
     * @return multiline String
     */
    public String about(){
        return """
                Christian Leyva
                Evaluate Tree Project
                """;
    }

}