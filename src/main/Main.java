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

package APL1.src.main;
import APL1.src.binaryTree.*;
import APL1.src.operations.*;
import APL1.src.auxiliar.Tokenizer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Stack;
import java.util.EmptyStackException;

public class Main {
  
    // infixaParaPosfixa(expressão) --> converte uma expressão na forma infixa para posfixa
    private static List<String> infixToPosfix(List<String> exp) {
        Stack<String> p = new Stack<>();
        
        List<String> posfixa = new ArrayList<>();
        int prioridadeTopo = 0, prioridadeEl;
        
        // Percorrendo a expressão infixa.
        for(String op: exp) {
            
            // Condição: se for um operando, copia para a saída.
            if(Character.isDigit(op.charAt(0))) posfixa.add(op);
            
            // Caso contrário, é uma operação ou ().
            else {
                
                // Condição: se c for igual a '(' ou a pilha for vazia, empilha.
                if(op.equals("(") || p.isEmpty()) {
                    
                   // Parêntese aberto reduz a prioridade do topo da pilha.
                    if(op.equals("(")) prioridadeTopo -= 2;
                    p.push(op);
                    
                }
                
                // ')' faz com que desempilhe e copie na saída até achar '('.
                else if(op.equals(")")) {
                    while(!p.peek().equals("(")) posfixa.add(p.pop());
                    p.pop();
               
                }
                
                // Definição da prioridade das operações.
                else {
                   prioridadeEl = switch(op){
                        case "~" -> 3;
                        case "*", "/" -> 2;
                        case "+", "-" -> 1;
                        default -> 0;
                    };
                
                   prioridadeTopo = switch (p.peek()) {
                        case "~" -> 3;
                        case "*", "/" -> 2;
                        case "+", "-" -> 1;
                        default -> 0;
                   };
                   
                   // Condição: se a prioridade do topo for maior, desempilha e 
                   //empilha a nova. Caso contrário, apenas empilha a nova operação.
                    if(prioridadeTopo >= prioridadeEl) posfixa.add(p.pop());
                    p.push(op); 
                }
            }
        }
      
        //Desempilha e copia para a saída as últimas operações.
        while(!p.isEmpty())posfixa.add(p.pop());
        return posfixa;
	    
    }

    // createSteps(operandos) --> realiza o cálculo da espressão aritmética (utiliza uma pilha)
    private static BNode createSteps(List<String> ops) throws NumberFormatException{
        
        Stack<BNode> p= new Stack<>();
	
        // Percorrendo a posfixa
        for(String op: ops) {
		
            // Se for operando, empilha seu valor.
            if(Character.isDigit(op.charAt(0))) {
                p.push(new Operand(Float.parseFloat(op)));
            }
		    
            // Caso contrário, desempilha os operandos, empilha o operador.
            else {
               
                Operator opt = null;
		
                // Empilha a raiz (operador) da sub-árvore criada.
                switch(op) {
				
                    case "+" -> {
                        opt = new Sum(op.charAt(0));
                        p.peek().setParent(opt);
                        //System.out.println(p.peek());
                        opt.setRight(p.pop());
                        p.peek().setParent(opt);
                        opt.setLeft(p.pop());
                    }
				
                    case "-" -> {
                        opt = new Diff(op.charAt(0));                    
                        p.peek().setParent(opt);
                        opt.setRight(p.pop());
                        p.peek().setParent(opt);
                        opt.setLeft(p.pop());
                                               
                    }
                    case "~" -> { // Operador de negação
                        opt = new Diff(op.charAt(0)); 
                        p.peek().setParent(opt);
                        opt.setRight(p.pop());
                    }
				
                    case "*" -> {
                        opt= new Multiply(op.charAt(0));
                        p.peek().setParent(opt);
                        opt.setRight(p.pop());
                        p.peek().setParent(opt);
                        opt.setLeft(p.pop());
                    }
				
                    case "/" -> {
                        opt= new Divide(op.charAt(0));
                        p.peek().setParent(opt);
                        opt.setRight(p.pop());
                        p.peek().setParent(opt);
                        opt.setLeft(p.pop());
                    }
				
                }
                 p.push(opt);
            }
           
        }
        
        // Resultado
        return p.pop();
	
}
  
    private static BTree create(List<String> ops) { 
        return new BTree<>(createSteps(ops)); 
    }

    // verificar(expressão) --> verifica se a expressão aritmética é válida
    private static boolean verify(List<String> sentence){
        Stack<String> p = new Stack<>();
        int index = 0; // indice do elemento analisado
        
        // Analisa a simetria dos sinais de abertura e fechamento.
        for(String op: sentence) {
            
            // Insere os caracteres que abrem.
            // Verifica se não ocorre o caso x(...) ao invés de x*(...)
            if(op.equals("("))
                if((index > 0  && !Character.isDigit(sentence.get(index-1).charAt(0)))
                   || index==0)
                    p.push(op);
                else {
                    System.out.println("Index = " + index);
                    System.out.println("Valor = " + sentence.get(index-1).charAt(0));
                    return false;
                }
            
            // Analisa os caracteres que fecham.
            else if(op.equals(")")){
                
                // Condição: Se todos não forem fechados, retorna falso.
                if(p.isEmpty() || (op.equals(")")  && !p.peek().equals("("))
                   || sentence.get(index-1).charAt(0) == '(')
                    return false;
                
                // Remove os que fecham corretamente.
                p.pop(); 
            }
            index++;
        }
        // Se a pilha estiver vazia, é válido, pois todos foram fechados.
        return p.isEmpty(); 
    }
    
	public static void main(String[] args) {
        
		Scanner scanner = new Scanner(System.in);
		int option;
		List<String> infixNotation = new ArrayList<>();
		List<String> posfixNotation= new ArrayList<>();
                String exp = "";
                boolean isChecked = true;
		BTree<BNode> tree = new BTree<>();
		BTree<BNode> tree_calc = new BTree<>();
		
		while(true) {
			try {
				
				System.out.println("--------------------------------------------------------");
                System.out.println("\nMENU:");
                System.out.print("[1] Entrada da expressao aritmetica na notaçao infixa.\n" +
                                 "[2] Criacao da arvore binaria de expressao aritmetica.\n" +
                                 "[3] Exibicao da arvore binaria de expressao aritmetica.\n" +
                                 "[4] Calculo da expressao (realizando o percurso da arvore).\n" +
                                 "[5] Sair.\n\nEscolha uma opcao: ");
                
                option = scanner.nextInt();

                if (option == 5) {
                        System.out.println("Programa encerrado!");
                	scanner.close();
                	break;
                }
                
                if(option < 1 || option > 5) {
                	System.out.println("--------------------------------------------------------\n");
                    System.out.println("\nOPCAO INVALIDA!!! Digite um numero valido de 1 a 5...\n");
                    continue;
                }
                System.out.println("--------------------------------------------------------\n");
                
                switch(option) {
                
                    case 1 -> {
                        
                    	scanner.nextLine(); // Limpando o Scanner
                    	tree.setRoot(null); // Limpando a árvore
                        
                    	System.out.print("Digite uma expressao aritmetica na forma infixa: ");
                        exp = scanner.nextLine().replaceAll(" ", "");
                    	infixNotation = new Tokenizer(exp).tokenize();                
                        if(infixNotation != null) {
                            isChecked = verify(infixNotation);
                            if(!isChecked) 
                                System.out.println("\nERRO!Parênteses não correspondentes!\n"
                                    + "--ou não use x(...) ao invés de x*(...)");
                                                   
                            else posfixNotation = infixToPosfix(infixNotation);
                        }
                                                                       
                        System.out.println("\nEncerrando leitura...");
                    	
                    }
                    
                    case 2 -> {
                        if(infixNotation == null || !isChecked) System.out.println("ERRO! Não foi passada a expressão!");
                        else{
                            try{
                                System.out.println("Criando árvore...");
                                tree = create(posfixNotation);
				tree_calc = create(posfixNotation);
                                System.out.println("Árvore criada com sucesso!");
                            } catch(Exception e) {
                                if(e instanceof EmptyStackException) 
                                    System.out.println("ERRO! Operações binárias devem ter dois operandos!");
                                else
                                    System.out.println("ERRO! Número inválido!");
                               
                            }
                            
                        } 	
                    
                    }
                    
                    case 3 -> {
                        if(tree.getRoot() == null) System.out.println("ERRO! Árvore ainda não foi criada!");
                        else {
                            System.out.println("Pré-ordem: " + tree.preOrderTraversal());
                            System.out.println("Em-ordem: " + tree.inOrderTraversal());
                            System.out.println("Pós-ordem: " + tree.postOrderTraversal());
                        }
                    	
                    	
                    }
                    
                    case 4 -> {
                        if(tree.getRoot() == null) 
                            System.out.println("ERRO! Árvore ainda não foi criada!");
                        else if(tree.calculate() == Float.NaN) 
                            System.out.println("ERRO! Divisão por zero!");
                        else System.out.println(exp + " = " + tree.calculate());
                        
                                          	
                    
                    }
                }
            
	    } catch(InputMismatchException e) {
                    System.out.println("--------------------------------------------------------\n");
                    System.out.println("\nENTRADA INVALIDA!!! Tente novamente apenas com números inteiros de 1 a 5...\n");
                    scanner.nextLine();
                
                }
            
        }
    }
}
