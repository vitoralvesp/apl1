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
