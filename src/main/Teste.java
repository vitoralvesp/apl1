package APL1.src.main;
import APL1.src.binaryTree.*;
import APL1.src.operations.*;
import java.util.Stack;

public class Teste {
    public static BNode createSteps(String ops[]){
        
        Stack<BNode> p= new Stack<>();
        //Percorrendo a posfixa
        for(String op: ops){
            
            //Se for operando, empilha seu valor.
            if(op.charAt(0)>=48 && op.charAt(0)<=57)
                p.push(new Operand(Float.parseFloat(op)));
            
            //Caso contrário, desempilha os operandos, empilha o resultado.
            else{
                Operator opt = null;
                //Empilha o resultado de acordo com a operação.
                switch(op){
                    case "+" -> {
                        opt = new Sum(op.charAt(0));
                        opt.setRight(p.pop());
                        opt.setLeft(p.pop());
                    }
                    case "-" -> {
                        opt = new Diff(op.charAt(0));
                        opt.setRight(p.pop());
                        opt.setLeft(p.pop());
                    }
                    case "*" -> {
                        opt= new Multiply(op.charAt(0));
                        opt.setRight(p.pop());
                        opt.setLeft(p.pop());
                    }
                    case "/" -> {
                        opt= new Divide(op.charAt(0));
                        opt.setRight(p.pop());
                        opt.setLeft(p.pop());
                    }
                }
                 p.push(opt);
            }
           
        }
        
        //Resultado
        return p.pop();
	
}
  
    public static BTree create(String ops[], int idx){ 
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
        String ops[]={"4.0","3.0","+","2.0","1.0","-","*","3.0","3.0","*","2","-","/"};

        BTree<BNode> tree = create(ops,ops.length-1);
        
        System.out.print(tree.inOrderTraversal());
        //System.out.println(tree.calcular());
        
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
