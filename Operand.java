package APL1;


public class Operand extends BNode<Float> {

    public Operand(float data, BNode parent) {
        super(data, parent);
    }

    public Operand(float data) {
        super(data);
    }

    @Override
    protected float see() {
        return this.getData();
    }
    
}
