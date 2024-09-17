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
 *
 */

package APL1.src.operations;
import APL1.src.binaryTree.*;

public class Diff extends Operator {

    /* Construtores */
    // Diff(dado, pai) --> acessa os atributos data e pai do node para efetuar a operação de subtração
    public Diff(char data, BNode parent) {
        super(data, parent);
    }

    // Diff(dado) --> acessa o atributo data do node para efetuar a operação de subtração
    public Diff(char data) {
        super(data);
    }

    // visit() --> realiza a subtração dos operandos da esquerda e direita (se um os dois operandos forem nulos, é considerado como 0) 
    @Override
    protected float visit() {
    	
        Operand leftOp = (Operand)this.getLeft();
        Operand rightOp = (Operand)this.getRight();
        return (leftOp != null ? leftOp.visit() : 0.0f) -
               (rightOp != null ? rightOp.visit() : 0.0f);
    }
}
