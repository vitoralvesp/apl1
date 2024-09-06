package binaryTree;
import operations.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lucas
 */

public class BTree<T> {
    
	private BNode<T> root;
    
    /* Construtores */
    public BTree(BNode<T> root) {
        this.root = root;
    }

    // Construtor para árvore vazia
    public BTree() {
        this(null);
    }
    
    
    /* Setters */
    // setRoot(BNode<T> root) --> atribui uma nova raiz para a árvore
    public void setRoot(BNode<T> root) {
        this.root = root;
    }
    
    
    /* Getters */
    // getRoot() --> retorna a raiz da árvore binária
    public BNode<T> getRoot() {
        return root;
    }
    
    // getDegree(BNode<T> root) --> função recursiva auxiliar para calcular o grau da árvore
    private int getDegree(BNode<T> root) {
        if(root == null || root.isLeaf()) return 0;
        else return Math.max(root.getDegree(),
                             Math.max(getDegree(root.getLeft()),
                                      getDegree(root.getRight())));
    }
    
    // getDegree() --> retorna o grau da árvore binária 
    public int getDegree() {
        return getDegree(root);
    }
    
    // getHeight() --> retorna a altura da árvore binária
    public int getHeight() {
        return root.getHeight();
    }
    
    
    /* Métodos Adicionais */
    // isEmpty() --> retorna true se uma árvore é vazia ou false caso contrário
    public boolean isEmpty() {
        return root == null;
    }
    
    
    // inOrderTraversal(BNode<T> root) --> função recursiva auxiliar para percorrer a árvore em percurso EM ORDEM
    private String inOrderTraversal(BNode<T> root) {
        if(root == null) return "";
        else return "" + inOrderTraversal(root.getLeft()) +
                    "" + root.getData() +
                    "" + inOrderTraversal(root.getRight());
        
    }
    
    // inOrderTraversal() --> retorna o percurso da árvore binária EM ORDEM
    public String inOrderTraversal() {
        return inOrderTraversal(root);
    }
    
    // preOrderTraversal(BNode<T> root) --> função recursiva auxiliar para percorrer a árvore em percurso PRÉ-ORDEM
    private String preOrderTraversal(BNode<T> root) {
        if(root == null) return "";
        else return "" + root.getData() +
                    "" + preOrderTraversal(root.getLeft()) +
                    "" + preOrderTraversal(root.getRight());
    }
    
    // preOrderTraversal() --> retorna o percurso da árvore binária em PRÉ-ORDEM
    public String preOrderTraversal() {
        return preOrderTraversal(root);
    }
    
    // postOrderTraversal(BNode<T> root) --> função recursiva auxiliar para percorrer a árvore em percurso PÓS-ORDEM
    private String postOrderTraversal(BNode<T> root) {
        if(root == null) return "";
        else return "" + postOrderTraversal(root.getLeft()) +
                    "" + postOrderTraversal(root.getRight()) +
                    "" + root.getData();
    }
    
    // postOrderTraversal() --> retorna o percurso da árvore binária em PÓS-ORDEM
    public String postOrderTraversal() {
        return postOrderTraversal(root);
    }
    
    // levelOrderTraversal() --> retorna o percurso da árvore em percurso por nível
    public void levelOrderTraversal() {
      Queue<BNode<T>> q = new LinkedList<>();
      q.add(root); 
      while(!q.isEmpty()) {
          if(q.peek().getLeft() != null )q.add(q.peek().getLeft());
          if(q.peek().getRight() != null )q.add(q.peek().getRight());
          System.out.print(q.poll().getData());
      }
    }
    
    // removeAndSwapNodes(BNode<T> out, Operand in) --> remove e troca os nodes de posição na árvore
    private void removeAndSwapNodes(BNode<T> out, Operand in) {
	  	BNode<T> sup = out.getParent();
        in.setParent(sup);
        if(sup.getLeft() == out) sup.setLeft(in);
        else sup.setRight(in);
        out.setParent(null);
    }
  
    // calcular(BNode<T> n) --> função recursiva auxiliar para calcular uma expressão aritmética em uma árvore binária
    // STATUS: Não Finalizada
    private void calcular(BNode<T> n) {
        //System.out.println("Nó: " + (n!=null?n.getData():"null"));
        if (n != null && !n.isLeaf()) {
            //Caso base de operacao
            if(n.getLeft() != null && n.getLeft().isLeaf() 
               && n.getRight()!=null && n.getRight().isLeaf()) {
                Operand result = new Operand(n.see());
                //System.out.printf("see(%c) = %f\n",n.getData(),n.see());
                //BNode pai = n.getParent();
                if(!n.isRoot())removeAndSwapNodes(n, result);
                //System.out.println("Esq eh folha: " + pai.getLeft().isLeaf() + "\n");
            }
            else{
                calcular(n.getLeft());
                calcular(n.getRight());
                Operand result = new Operand(n.see());
                //System.out.printf("see(%c) = %f\n",n.getData(),n.see());
                //BNode pai = n.getParent();
                if(!n.isRoot())removeAndSwapNodes(n, result);
            }
       }
    }
   
    // calcular() --> retorna o cálculo de uma expressão aritmética em uma árvore
    public float calcular() {
       calcular(root);
       return root.see();
   }
    
}
