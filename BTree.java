package APL1;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author lucas
 */
public class BTree<T> {
    private BNode root;

    public BTree(BNode root) {
        this.root = root;
    }

    //arvore vaiza
    public BTree() {
        this(null);
    }
    
    public BNode getRoot() {
        return root;
    }

    public void setRoot(BNode root) {
        this.root = root;
    }
    
    public boolean isEmpty(){
        return root == null;
    }
     
    private int getDegree(BNode root){
        if(root == null || root.isLeaf()) return 0;
        else return Math.max(root.getDegree(),
                             Math.max(getDegree(root.getLeft()),
                                      getDegree(root.getRight())));
    }
    public int getDegree(){
        return getDegree(root);
    }
    
    public int getHeight(){
        return root.getHeight();
    }
    
    
    //Percursos
    private String inOrderTraversal(BNode root){
        if(root == null) return "";
        else return "" + inOrderTraversal(root.getLeft()) +
                    "" + root.getData() +
                    "" + inOrderTraversal(root.getRight());
        
    }
    
    public String inOrderTraversal(){
        return inOrderTraversal(root);
    }
    
    private String preOrderTraversal(BNode root){
        if(root == null) return "";
        else return "" + root.getData() +
                    "" + preOrderTraversal(root.getLeft()) +
                    "" + preOrderTraversal(root.getRight());
    }
    
    public String preOrderTraversal(){
        return preOrderTraversal(root);
    }
    
    private String postOrderTraversal(BNode root){
        if(root == null) return "";
        else return "" + postOrderTraversal(root.getLeft()) +
                    "" + postOrderTraversal(root.getRight()) +
                    "" + root.getData();
    }
    
    public String postOrderTraversal(){
        return postOrderTraversal(root);
    }
    
   public void levelOrderTraversal(){
      Queue<BNode> q = new LinkedList<>();
      q.add(root); 
      while(!q.isEmpty()) {
          if(q.peek().getLeft() != null )q.add(q.peek().getLeft());
          if(q.peek().getRight() != null )q.add(q.peek().getRight());
          System.out.print(q.poll().getData());
   }
  }
   
  private void removeAndSwapNodes(BNode out, Operand in){
        BNode sup = out.getParent();
        in.setParent(sup);
        if(sup.getLeft() == out) sup.setLeft(in);
        else sup.setRight(in);
        out.setParent(null);
  }
  
  //TODO: Consertar
   private void calcular(BNode n) {
        //System.out.println("Nó: " + (n!=null?n.getData():"null"));
        if (n != null && !n.isLeaf()) {
        //Caso base de operacao
            if(n.getLeft() != null && n.getLeft().isLeaf() 
               && n.getRight()!=null && n.getRight().isLeaf()) {
                Operand result = new Operand(n.see());
                System.out.printf("see(%c) = %f\n",n.getData(),n.see());
                //BNode pai = n.getParent();
                if(!n.isRoot())removeAndSwapNodes(n, result);
                //System.out.println("Esq eh folha: " + pai.getLeft().isLeaf() + "\n");
            }
            else{
                calcular(n.getLeft());
                calcular(n.getRight());
            }
       }
   }
   public float calcular(){
       calcular(root);
       return root.see();
   }
    
}
