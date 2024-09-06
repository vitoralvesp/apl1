package main;
import binaryTree.*;
import operations.*;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Main {
    
	public static void main(String[] args) {
        
		Scanner scanner = new Scanner(System.in);
		int option;
		String infixNotation;
		String[] infixNotationArr;
		int infixNotationLength;
		BTree tree;
		BNode node;
		
		while(true) {
			
			infixNotation = "";
			infixNotationLength = 0;
			infixNotationArr = new String[] {};
			node = new BNode("+");
            
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
                    	infixNotation = scanner.nextLine().replaceAll("\\s", "");
                    	infixNotationArr = infixNotation.split(infixNotation);
                    	break;
                    	
                    }
                    
                    case 2 -> {
                        
                    	// infixNotationLength = infixNotation.length();
                    	for (String character : infixNotationArr) {
                    		
                    		if (character == "+" || 
                    			character == "-" ||
                    			character == "*" ||
                    			character == "/" )
                    			node.setData(character);
                    		else {
                    			
                    			                  			
                    			
                    		}
                    		
                    		                   		
                    		
                    	}
                    		
                    	                   	
                    	break;
                    	
                    }
                    
                    case 3 -> {
                        
                    	System.out.println("Case 3\n");
                    	break;
                    	
                    }
                    
                    case 4 -> {
                        
                    	System.out.println("Case 4\n");
                    	break;
                    
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
