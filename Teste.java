package APL1;

public class Teste {
    public static void main(String[] args) {
        Diff f = new Diff('+');
        Operand b = new Operand(3.5f,f);
        Operand g= new Operand(1.5f,f);
//        BNode<String> a= new BNode("A",b);
//        BNode<String> d= new BNode("D",b);
//        BNode<String> c= new BNode("C",d);
//        BNode<String> e= new BNode("E",d);
//        BNode<String> i= new BNode("I",g);
//        BNode<String> h= new BNode("H",i);
        
        f.setLeft(null);
        f.setRight(g);
//        b.setLeft(a);
//        b.setRight(d);
//        d.setLeft(c);
//        d.setRight(e);
//        g.setRight(i);
//        i.setLeft(h);
        System.out.println(f.see());
        //BTree<BNode> tree = new BTree(f);
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