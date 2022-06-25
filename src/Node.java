
public class Node {

    public String val;
    Node left, right;
    public Node (String val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
    public Node (String val, Node left, Node right){
        this.val = val;
        this.left = left;
        this.right = right;

    }
    @Override
    public String toString() {
        if(this.left== null && this.right == null) return this.val;
        else return "(" + left.toString() + " " + this.val + " " + right.toString() + ")";
    }
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
        return Double.parseDouble(str);
    }
}