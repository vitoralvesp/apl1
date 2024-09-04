package APL1;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        while(true){
            try{
                System.out.println("###############MENU###############");
                System.out.print("[1] Entrada da expressão aritmética na notação infixa.\n" +
                                 "[2] Criação da árvore binária de expressão aritmética.\n" +
                                 "[3] Exibição da árvore binária de expressão aritmética.\n" +
                                 "[4] Cálculo da expressão (realizando o percurso da árvore).\n" +
                                 "[5] Sair.\nOpção = ");
                int opt = inp.nextInt();
                if(opt == 5) break;
                if(opt < 1 || opt > 5) {
                    System.out.println("Digite um número válido!\n");
                    continue;
                }
                System.out.println("##################################");
                
                switch(opt){
                    case 1 -> {
                        System.out.println("teste");
                    }
                    case 2 -> {
                        
                    }
                    case 3 -> {
                        
                    }
                    case 4 -> {
                        
                    }
                }
            }catch(NumberFormatException e){
                System.out.println("Digite um número válido!\n");
            }
            
        }
    }
}
