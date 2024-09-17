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

public class Multiply extends Operator {

    // Multiply(dado, pai) --> acessa os atributos data e parent do node para realizar a operação de multiplicação
    public Multiply(char data, BNode parent) {
        super(data, parent);
    }

    // Multiply(dado) --> acessa o atributo data do node para realizar a operação de multiplicação 
    public Multiply(char data) {
        super(data);
    }

    // visit() --> realiza a operação de multiplicação entre os operandos (se um deles for nulo, é considerado como 0)
    @Override
    protected float visit() {
        Operand leftOp = (Operand)this.getLeft();
        Operand rightOp = (Operand)this.getRight();
        return (leftOp != null ? leftOp.visit() : 0.0f) *
               (rightOp != null ? rightOp.visit() : 0.0f);
    }
}
