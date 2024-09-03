package APL1;

public class Multiply extends Operator{

    public Multiply(char data) {
        super(data);
    }
    @Override
    protected float see() {
        Operand leftOp = (Operand)this.getLeft();
        Operand rightOp = (Operand)this.getRight();
        return (leftOp != null ? leftOp.getData() : 0.0f) *
               (rightOp != null ? rightOp.getData() : 0.0f);
    }
}
