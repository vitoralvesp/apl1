package APL1;

public class Teste {
    public static void main(String[] args) {
        Sum f = new Sum('+');
        Multiply b = new Multiply('*',f);
        Operand g= new Operand(5,f);
        Sum a= new Sum('+',b);
        Diff d= new Diff('-',b);
        Operand c= new Operand(3,a);
        Operand e= new Operand(6,a);
        Operand h= new Operand(4,d);
        Operand i= new Operand(1,d);
        
        f.setRight(g);
        f.setLeft(b);
        b.setLeft(a);
        b.setRight(d);
        a.setLeft(c);
        a.setRight(e);
        d.setRight(i);
        d.setLeft(h);
        
        BTree<BNode> tree = new BTree(f);
        
        //System.out.print(tree.inOrderTraversal()+" = ");
        System.out.println(tree.calcular());
        
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