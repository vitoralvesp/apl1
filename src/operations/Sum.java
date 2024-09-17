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

public class Sum extends Operator {

    /* Construtores */
    // Sum(dado, pai) --> acessa os atributos data e parent do node para realizar a operação de soma 
    public Sum(char data, BNode parent) {
        super(data, parent);
    }

    // Sum(dado) --> acessa o atributo data do node para realizar a operação de soma
    public Sum(char data) {
        super(data);
    }

    /* Método */
    // visit() --> realiza o cálculo da operação de soma entre os filhos (operandos) da esquerda e direita (se um dos operandos for nulo, é considerado 0)
    @Override
    protected float visit() {
        Operand leftOp = (Operand)this.getLeft();
        Operand rightOp = (Operand)this.getRight();
        return (leftOp != null ? leftOp.visit() : 0.0f) +
               (rightOp != null ? rightOp.visit() : 0.0f);
    }
    
}
