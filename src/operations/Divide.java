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
 *  KISHIMOTO, André. Herança: Estrutura de Dados II. São Paulo , SP - Brasil, 3 set. 2024. Disponível em: https://graduacao.mackenzie.br/mod/resource/view.php?id=327556. Acesso em: 17 set. 2024.
 *  KISHIMOTO, André. Árvore: Estrutura de Dados II. São Paulo , SP - Brasil, 3 set. 2024. Disponível em: https://graduacao.mackenzie.br/mod/resource/view.php?id=327563. Acesso em: 17 set. 2024.
 */

package APL1.src.operations;
import APL1.src.binaryTree.*;

public class Divide extends Operator {

    // Divide(dado, pai) --> acessa os atributos data e parent do node para realizar a operação de divisão
    public Divide(char data, BNode parent) {
        super(data, parent);
    }

    // Divide(dado) --> acessa o atributo data do node para realizar a operação de divisão 
    public Divide(char data) {
        super(data);
    }

    // visit() --> realiza a operação de divisão para os filhos (operandos) da esquerda e direita do node (é considerado 0 se um deles for nulo)
    @Override
    public float visit() {
        BNode leftOp = this.getLeft();
        BNode rightOp = this.getRight();
        float r = leftOp.visit()/rightOp.visit();
        if(r==Float.POSITIVE_INFINITY) return Float.NaN;
        else return r;
    }
}
