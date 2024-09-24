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
    public float visit() {
    	
        BNode leftOp = this.getLeft();
        BNode rightOp = this.getRight();
        return (leftOp == null ? 0.0f : leftOp.visit())-rightOp.visit();
    }
}
