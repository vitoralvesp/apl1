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

public class Operand extends BNode {

    /* Construtores */
    // Operand(dado, pai) --> acessa os atributos data e parent do node para realizar o casting do operando
    public Operand(float data, BNode parent) {
        super(data, parent);
    }

    // Operand(dado) --> acessa o atributo data do node para realizar o casting do operando
    public Operand(float data) {
        super(data);
    }

    /* Método */
    // see() --> realiza o casting do dado do operando
    @Override
    protected float see() {
        return (float) this.getData();
    }
    
}
