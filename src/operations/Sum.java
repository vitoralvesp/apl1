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
 * KISHIMOTO, André. Herança: Estrutura de Dados II. São Paulo , SP - Brasil, 3 set. 2024. Disponível em: https://graduacao.mackenzie.br/mod/resource/view.php?id=327556. Acesso em: 17 set. 2024.
 *  KISHIMOTO, André. Árvore: Estrutura de Dados II. São Paulo , SP - Brasil, 3 set. 2024. Disponível em: https://graduacao.mackenzie.br/mod/resource/view.php?id=327563. Acesso em: 17 set. 2024.
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
    public float visit() {
        BNode leftOp = this.getLeft();
        BNode rightOp = this.getRight();
        return leftOp.visit()+rightOp.visit();
    }
    
}
