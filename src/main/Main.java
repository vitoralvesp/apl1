package APL1.src.main;

import APL1.src.binaryTree.*;
import APL1.src.operations.*;
import Apl1.src.auxiliar.Tokenizer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Stack;



public class Main {
  
    // infixaParaPosfixa(String expressão, char operandos[], Pilha pilha) 
    //--> Converte uma expressão na forma infixa para posfixa
    public static List<String> infixToPosfix(List<String> exp){
        Stack<String> p = new Stack<>();
        p.clear(); //Limpa a pilha, para não exibir o valor da outra operação.
        
        List<String> posfixa = new ArrayList<>();
        int prioridadeTopo = 0, prioridadeEl;
        
        //Percorrendo a expressão infixa.
        for(String op: exp){
            
             // Condição: se for um operando, copia para a saída.
            if(Character.isDigit(op.charAt(0))) posfixa.add(op);
            
            //Caso contrário, é uma operação ou ().
            else{
                
                // Condição: se c for igual a '(' ou a pilha for vazia, empilha.
                if(op.equals("(") || p.isEmpty()) {
                    
                   // Parêntese aberto reduz a prioridade do topo da pilha.
                    if(op.equals("(")) prioridadeTopo -= 3;
                    p.push(op);
                    
                }
                
                //')' faz com que desempilhe e copie na saída até achar '('.
                else if(op.equals(")")){
                    while(!p.peek().equals("(")) posfixa.add(p.pop());
                    p.pop();
               
                }
                
                // Definição da prioridade das operações.
                else{
                   prioridadeEl = switch(op){
                        case "*", "/" -> 2;
                        case "+", "-" -> 1;
                        default -> 0;
                    };
                
                   prioridadeTopo = switch (p.peek()) {
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

    
    public static BNode createSteps(List<String> ops){
        
        Stack<BNode> p= new Stack<>();
        //Percorrendo a posfixa
        for(String op: ops){
            //Se for operando, empilha seu valor.
            if(Character.isDigit(op.charAt(0))){
                //System.out.println(op + "is Digit!");
                p.push(new Operand(Float.parseFloat(op)));
               
            }
            //Caso contrário, desempilha os operandos, empilha o operador.
            else{
               
                Operator opt = null;
                //Empilha a raiz(operador) da sub-árvore criada.
                switch(op){
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
        
        //Resultado
        return p.pop();
	
}
  
    public static BTree create(List<String> ops, int idx){ 
        return new BTree<>(createSteps(ops)); 
    }

	public static void main(String[] args) {
        
		Scanner scanner = new Scanner(System.in);
		int option;
		List<String> infixNotation = new ArrayList<>();
		List<String> posfixNotation= new ArrayList<>();
                String exp = "";
		BTree<BNode> tree = null;
		
		while(true){
			try {
				
				System.out.println("--------------------------------------------------------");
                System.out.println("MENU:");
                System.out.print("[1] Entrada da expressao aritmetica na notaçao infixa.\n" +
                                 "[2] Criacao da arvore binaria de expressao aritmetica.\n" +
                                 "[3] Exibicao da arvore binaria de expressao aritmetica.\n" +
                                 "[4] Calculo da expressao (realizando o percurso da arvore).\n" +
                                 "[5] Sair.\n\nEscolha uma opcao: ");
                
                option = scanner.nextInt();

                if (option == 5) {
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
                        
                    	scanner.nextLine();
                    	
                    	System.out.print("Digite uma expressao aritmetica na forma infixa: ");
                        exp = scanner.nextLine().replaceAll(" ", "");
                    	infixNotation = new Tokenizer(exp).tokenize();
                        posfixNotation = infixToPosfix(infixNotation);
                        //TODO: VALIDAR!!!
                    	
                    }
                    
                    case 2 -> {
                        if(infixNotation == null) System.out.println("ERRO! Não foi passada a expressão!");
                        else{
                            System.out.println("Criando árvore...");
                            tree = create(posfixNotation,posfixNotation.size()-1);
                            System.out.println("Árvore criada com sucesso!");
                        } 	
                    
                    }
                    
                    case 3 -> {
                        if(tree == null) System.out.println("ERRO! Árvore ainda não foi criada!");
                        else {
                            System.out.println("Pré-ordem: " + tree.preOrderTraversal());
                            System.out.println("Em-ordem: " + tree.inOrderTraversal());
                            System.out.println("Pós-ordem: " + tree.postOrderTraversal());
                        }
                    	
                    	
                    }
                    
                    case 4 -> {
                        if(tree == null) System.out.println("ERRO! Árvore ainda não foi criada!");
                        else System.out.println(exp + " = " + tree.calcular());
                    	
                    
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
