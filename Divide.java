package APL1;

public class Divide extends Operator{

    public Divide(char data, BNode parent) {
        super(data, parent);
    }

    public Divide(char data) {
        super(data);
    }
    @Override
    protected float see() {
        Operand leftOp = (Operand)this.getLeft();
        Operand rightOp = (Operand)this.getRight();
        return (leftOp != null ? leftOp.getData() : 0.0f) /
               (rightOp != null ? rightOp.getData() : 0.0f);
    }
}
