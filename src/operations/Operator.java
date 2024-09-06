package APL1.src.operations;
import APL1.src.binaryTree.*;

public class Operator extends BNode<Character> {

    public Operator(char data, BNode<Character> parent) {
        super(data, parent);
    }

    public Operator(char data) {
        super(data);
    }

    @Override
    protected float see() {
      return this.see();
    }
    
    
}
