package APL1.src.operations;
import APL1.src.binaryTree.*;
public class Operand extends BNode {

    public Operand(float data, BNode parent) {
        super(data, parent);
    }

    public Operand(float data) {
        super(data);
    }

    @Override
    protected float see() {
        return (float) this.getData();
    }
    
}
