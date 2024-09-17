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
    // visit() --> realiza o casting do dado do operando
    @Override
    protected float visit() {
        return (float) this.getData();
    }
    
}
