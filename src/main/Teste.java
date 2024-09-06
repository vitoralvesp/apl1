package APL1.src.main;
import APL1.src.binaryTree.*;
import APL1.src.operations.*;

public class Teste {
    public static BNode createSteps(String ops[],int idx){
    if(idx >= 0){
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
                opt.setRight(new Operand(Float.parseFloat(ops[idx-1])));
            }
            else if(ops[idx-1].charAt(0)<=48 || ops[idx-1].charAt(0)>=57) {
                opt.setLeft(createSteps(ops,idx-4));
                opt.setRight(createSteps(ops,idx-1));
            }
            else {
                opt.setLeft(createSteps(ops,idx-2));
                opt.setRight(createSteps(ops,idx-1));
            }
	
            return opt;
        }
        
    }
    
    return null;
	
}
  
    public static BTree create(String ops[], int idx){ 
        return new BTree<BNode>(createSteps(ops,idx)); 
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
        String ops[]={"3.0","6.0","+","4.0","1.0","-","*","5.0","+"};

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
