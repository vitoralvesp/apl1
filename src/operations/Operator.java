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

package APL1.src.operations;
import APL1.src.binaryTree.*;

public class Operator extends BNode<Character> {

    /* Construtores */
    // Operator(dado, pai) --> acessa os atributos data e parent do node para descobrir o operador
    public Operator(char data, BNode<Character> parent) {
        super(data, parent);
    }

    // Operator(dado) --> acessa o atributo data do node para descobrir o operador
    public Operator(char data) {
        super(data);
    }

    /* Método */
    // see() --> 
    @Override
    protected float see() {
      return this.see();
    }
    
    
}
