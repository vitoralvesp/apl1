package APL1.src.operations;
import APL1.src.binaryTree.*;

public class Diff extends Operator {

    public Diff(char data, BNode parent) {
        super(data, parent);
    }

    public Diff(char data) {
        super(data);
    }
    
    @Override
    protected float see() {
    	
        Operand leftOp = (Operand)this.getLeft();
        Operand rightOp = (Operand)this.getRight();
        return (leftOp != null ? leftOp.see() : 0.0f) -
               (rightOp != null ? rightOp.see() : 0.0f);
    }
}
