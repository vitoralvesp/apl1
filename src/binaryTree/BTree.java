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
 * 
 */

package APL1.src.binaryTree;
import APL1.src.operations.*;
import java.util.LinkedList;
import java.util.Queue;


public class BTree<T> {
    
    private BNode<T> root;
	
    /* Construtores */
    // BTree(raiz) --> cria uma raiz para a árvore binária
    public BTree(BNode<T> root) {
        this.root = root;
    }

    // BTree() --> construtor para árvore vazia
    public BTree() {
        this(null);
    }
    
    /* Setters */
    // setRoot(raiz) --> atribui uma nova raiz para a árvore
    public void setRoot(BNode<T> root) {
        this.root = root;
    }
    
    /* Getters */
    // getRoot() --> retorna a raiz da árvore binária
    public BNode<T> getRoot() {
        return root;
    }
    
    // getDegree(raiz) --> função recursiva auxiliar para calcular o grau da árvore
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
    
    // inOrderTraversal(raiz) --> função recursiva auxiliar para percorrer a árvore em percurso EM ORDEM
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
    
    // preOrderTraversal(raiz) --> função recursiva auxiliar para percorrer a árvore em percurso PRÉ-ORDEM
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
    
    // postOrderTraversal(raiz) --> função recursiva auxiliar para percorrer a árvore em percurso PÓS-ORDEM
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
	if(!out.isRoot()){
            BNode<T> sup = out.getParent();
            in.setParent(sup);
            if(sup.getLeft() == out) sup.setLeft(in);
            else sup.setRight(in);
            out.setParent(null);
        } else root = in;
        
    }
  
    // calcular(BNode<T> n) --> função recursiva auxiliar para calcular uma expressão aritmética em uma árvore binária
    private void calcular(BNode<T> n) {
        if (n != null && !n.isLeaf()) {
            // Caso base de operacao
            if(n.getLeft() != null && n.getLeft().isLeaf() 
               && n.getRight()!=null && n.getRight().isLeaf()) {
                Operand result = new Operand(n.visit());
                
               removeAndSwapNodes(n, result);
                
            } else {
                calcular(n.getLeft());
                calcular(n.getRight());
                Operand result = new Operand(n.visit());
                removeAndSwapNodes(n, result);
            }
       }
    }
   
    // calcular() --> retorna o cálculo de uma expressão aritmética em uma árvore
    public T calcular() {
       calcular(root);
       return root.getData();
   }
    
}
