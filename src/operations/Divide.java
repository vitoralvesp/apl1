package APL1.src.operations;

/**
 *
 * @author Lucas Pires de Camargo Sarai - 10418013
 * @author Vitor Alves Pereira - 10410862
 * 
 * Ciência da Computação
 * 3D
 * EDI
 * 
 * Referências:
 *  Herança em Java
 *  Árvores - fundamentos
 */

import APL1.src.binaryTree.*;

public class Divide extends Operator {

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
        return (leftOp != null ? leftOp.see() : 0.0f) /
               rightOp.see();
    }
}
