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
