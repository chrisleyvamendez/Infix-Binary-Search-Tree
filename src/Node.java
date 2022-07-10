/**
 * Node class for constructing, processing, and evaluating nodes and their children for an infix expression
 */
public class Node {

    public String val;
    Node left, right;

    /**
     * Single argument constructor for root node
     * @param val String value of root node
     */
    public Node (String val){

        this.val = val;
        this.left = null;
        this.right = null;
    }

    /**
     * 3 arg constructor for instantiating the left, right, root node values
     * @param val String value or root
     * @param left String value left child
     * @param right String value right child
     */
    public Node (String val, Node left, Node right){
        this.val = val;
        this.left = left;
        this.right = right;

    }

    /**
     * returns a String representation of the infix operation using inorder DFS
     * @return infix equation
     */
    @Override
    public String toString() {

        // if a child node is found -> return value of curr node
        if(left == null && right == null)
            return val;
        else
            return "(" + left + " " + val + " " + right + ")";
    }

    /**
     * node evaluate functions which checks if a node is an operator || operand
     * all operands are leaf nodes, so function checks for internal nodes and recursively calls their
     * operator functions on their respective left and right trees
     * @return Double value
     */
    public Double evaluate(){
        String str = this.val;
        // only leaf nodes are operands
        if(this.left!=null && this.right!= null){
            switch (str){
                case ("+"): return this.left.evaluate() + this.right.evaluate();
                case ("-"): return this.left.evaluate() - this.right.evaluate();
                case ("/"): return this.left.evaluate() / this.right.evaluate();
                case ("%"): return this.left.evaluate() % this.right.evaluate();
                case ("*"): return this.left.evaluate() * this.right.evaluate();
                case ("^"): return Math.pow(this.left.evaluate(), this.right.evaluate());
            }
        }
        // default return a leaf node (operand) if no internal nodes are found
        return Double.parseDouble(str);
    }
}