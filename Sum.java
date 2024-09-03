package APL1;

public class Sum extends Operator {

    public Sum(char data) {
        super(data);
    }

    @Override
    protected float see() {
        Operand leftOp = (Operand)this.getLeft();
        Operand rightOp = (Operand)this.getRight();
        return (leftOp != null ? leftOp.getData() : 0.0f) +
               (rightOp != null ? rightOp.getData() : 0.0f);
    }
    
    
    
}
