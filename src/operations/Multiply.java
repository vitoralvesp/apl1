package operations;
import binaryTree.*;

public class Multiply extends Operator {

    public Multiply(char data, BNode parent) {
        super(data, parent);
    }

    public Multiply(char data) {
        super(data);
    }
    @Override
    protected float see() {
        Operand leftOp = (Operand)this.getLeft();
        Operand rightOp = (Operand)this.getRight();
        return (leftOp != null ? leftOp.see() : 0.0f) *
               (rightOp != null ? rightOp.see() : 0.0f);
    }
}
