package APL1.src.main;

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
 *  Herança em Java
 *  Árvores - fundamentos
 */

import APL1.src.binaryTree.*;
import APL1.src.operations.*;
import Apl1.src.auxiliar.Tokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Teste {
    
      // infixaParaPosfixa(String expressão, char operandos[], Pilha pilha) 
    //--> Converte uma expressão na forma infixa para posfixa
    public static List<String> infixaParaPosfixa(List<String> exp){
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
//        Sum f = new Sum('+');
//        Multiply b = new Multiply('*',f);
//        Operand g= new Operand(5,f);
//        
//        Sum a= new Sum('+',b);
//        Diff d= new Diff('-',b);
//        Operand c= new Operand(3,a);
//        Operand e= new Operand(6,a);
//        Operand h= new Operand(4,d);
//        Operand i= new Operand(1,d);
//        
//        
//        f.setRight(new Operand(5,f));
//        f.setLeft(new Multiply('*',f));
//        b.setLeft(a);
//        b.setRight(d);
//        a.setLeft(c);
//        a.setRight(e);
//        d.setRight(i);
//        d.setLeft(h);
        Scanner in = new Scanner(System.in);
        System.out.print("Expressão: ");
        String teste = in.nextLine();
        List<String> infixa= new Tokenizer(teste).tokenize();
        List<String> posfixa= infixaParaPosfixa(infixa);
            
        BTree<BNode> tree = create(posfixa,posfixa.size()-1);
        System.out.println("Árvore criada!");
        System.out.println(tree.inOrderTraversal() + " = " + tree.calcular());
        System.out.println("Conta final = " + tree.inOrderTraversal());
        
//        System.out.println("Pre = " + tree.preOrderTraversal());
//        System.out.println("Post = " + tree.postOrderTraversal());
//        System.out.println("In = " + tree.inOrderTraversal());
//        tree.levelOrderTraversal();
        
//        System.out.print("Degree Order = ");
//        tree.levelOrderTraversal();
//        System.out.println();
//        System.out.println(f.getData() + ", Degree = " + f.getDegree());
//        System.out.println(b.getData() + ", Degree = " + b.getDegree());
//        System.out.println(g.getData() + ", Degree = " + g.getDegree());
//        System.out.println(a.getData() + ", Degree = " + a.getDegree());
//        System.out.println(d.getData() + ", Degree = " + d.getDegree());
//        System.out.println(c.getData() + ", Degree = " + c.getDegree());
//        System.out.println(e.getData() + ", Degree = " + e.getDegree());
//        System.out.println(i.getData() + ", Degree = " + i.getDegree());
//        System.out.println(h.getData() + ", Degree = " + h.getDegree());
    }
}
