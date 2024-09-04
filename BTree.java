package APL1;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author lucas
 */
public class BTree<T> {
    private BNode<T> root;

    public BTree(BNode<T> root) {
        this.root = root;
    }

    //arvore vaiza
    public BTree() {
        this(null);
    }
    
    public BNode getRoot() {
        return root;
    }

    public void setRoot(BNode<T> root) {
        this.root = root;
    }
    
    public boolean isEmpty(){
        return root == null;
    }
     
    private int getDegree(BNode<T> root){
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
    private String inOrderTraversal(BNode<T> root){
        if(root == null) return "";
        else return "" + inOrderTraversal(root.getLeft()) +
                    "" + root.getData() +
                    "" + inOrderTraversal(root.getRight());
        
    }
    
    public String inOrderTraversal(){
        return inOrderTraversal(root);
    }
    
    private String preOrderTraversal(BNode<T> root){
        if(root == null) return "";
        else return "" + root.getData() +
                    "" + preOrderTraversal(root.getLeft()) +
                    "" + preOrderTraversal(root.getRight());
    }
    
    public String preOrderTraversal(){
        return preOrderTraversal(root);
    }
    
    private String postOrderTraversal(BNode<T> root){
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
   private float calcular(BNode<T> n) {
       if(n.isLeaf()) {
           Operand val = (Operand)n;
           return val.getData();
       }
       else{
           Operator op = (Operator)n;
           switch(op.getData()){
                case '+' -> {
                    return calcular(n.getLeft()) + calcular(n.getRight());
               }
                   
                   
                case '-' -> {
                    return calcular(n.getLeft()) - calcular(n.getRight());
               }
                   
                   
                case '*' -> {
                    return calcular(n.getLeft()) * calcular(n.getRight());
               }
                   
                   
                case '/' -> {
                    return calcular(n.getLeft()) / calcular(n.getRight());
               }
           }
       }
       return -1;
   
   }
   public float calcular(){
       return calcular(root);
   }
    
}
