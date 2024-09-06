package APL1;

import java.util.Scanner;
import java.util.InputMismatchException;



public class Main {
  
  public static BNode createSteps(String ops[],int idx){
    if(ops[idx].charAt(0)>=48 && ops[idx].charAt(0)<=57) 
	return new Operand(Float.parseFloat(ops[idx]));
    else {
	Operator opt = switch (ops[idx]) {
            case "+" -> new Sum('+');
            case "-" -> new Diff('-');
            case "*" -> new Multiply('*');
            default -> new Divide('/');
        };

	if (ops[idx-2].charAt(0)>=48 && ops[idx-2].charAt(0)<=57 && 
            ops[idx-1].charAt(0)>=48 && ops[idx-1].charAt(0)<=57){
            opt.setLeft(new Operand(Float.parseFloat(ops[idx-2])));
            opt.setRight(new Operand(Float.parseFloat(ops[idx-2])));
	}
	else {
            opt.setLeft(createSteps(ops,idx-2));
            opt.setRight(createSteps(ops,idx-1));
         
	}
	
	return opt;
    }
	
}
  
    public static BTree create(String ops[], int idx){ 
        return new BTree<BNode>(createSteps(ops,idx)); 
    }

	public static void main(String[] args) {
        
		Scanner scanner = new Scanner(System.in);
                int MAXSIZE = 20;
		int option;
		String infixNotation = "";
		String infixNotationArr[];
		int infixNotationLength;
		BTree tree;
		BNode node;
		
		while(true){
			infixNotationLength = 0;
			infixNotationArr = new String[MAXSIZE];
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
                    	infixNotation = scanner.nextLine().replaceAll(" ", "");
                        System.out.println("String: " + infixNotation);
                    	infixNotationArr = infixNotation.split("");
                        System.out.print("[");
                        for(String s: infixNotationArr){
                            System.out.print(s+", ");
                        }
                        System.out.println("]");
                    	break;
                    	
                    }
                    
                    case 2 -> {
                        
                    	// infixNotationLength = infixNotation.length();
                    	for (String character : infixNotationArr) {
                    		
                    		if (character.equals("+") || 
                    			character.equals("-") ||
                    			character.equals("*") ||
                    			character.equals("/") )
                    			node.setData(character);
                    		else {
                    			
                    		break;                  			
                    			
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
