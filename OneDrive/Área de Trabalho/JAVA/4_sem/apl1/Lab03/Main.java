
package Lab03;


public class Main {
    public static void main(String[] args) {
        BNode<String> f = new BNode("F");
        BNode<String> b = new BNode("B",f);
        BNode<String> g= new BNode("G",f);
        BNode<String> a= new BNode("A",b);
        BNode<String> d= new BNode("D",b);
        BNode<String> c= new BNode("C",d);
        BNode<String> e= new BNode("E",d);
        BNode<String> i= new BNode("I",g);
        BNode<String> h= new BNode("H",i);
        
        f.setLeft(b);
        f.setRight(g);
        b.setLeft(a);
        b.setRight(d);
        d.setLeft(c);
        d.setRight(e);
        g.setRight(i);
        i.setLeft(h);
        
        BTree<String> tree = new BTree(f);
        
//        System.out.print("Degree Order = ");
//        tree.levelOrderTraversal();
//        System.out.println();
        System.out.println(f.getData() + ", Degree = " + f.getDegree());
        System.out.println(b.getData() + ", Degree = " + b.getDegree());
        System.out.println(g.getData() + ", Degree = " + g.getDegree());
        System.out.println(a.getData() + ", Degree = " + a.getDegree());
        System.out.println(d.getData() + ", Degree = " + d.getDegree());
        System.out.println(c.getData() + ", Degree = " + c.getDegree());
        System.out.println(e.getData() + ", Degree = " + e.getDegree());
        System.out.println(i.getData() + ", Degree = " + i.getDegree());
        System.out.println(h.getData() + ", Degree = " + h.getDegree());
    }
}
