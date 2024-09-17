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

    // Método abstrato
    @Override
    protected float visit() {
      return Float.NaN;
    }
    
    
}
