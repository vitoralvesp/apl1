package APL1;

public class Diff extends Operator{

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
