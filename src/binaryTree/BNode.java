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

package APL1.src.binaryTree;

public class BNode<T> {
	
    private T data;
    private BNode<T> parent;
    private BNode<T> left;
    private BNode<T> right;

    /* Construtores */
    // BNode(dado do tipo genérico T, pai do tipo BNode) --> Construtor para as folhas
    public BNode(T data, BNode<T> parent) {
        this.data = data;
        this.parent = parent;
        right = left = null;
    }

    // BNode(dado do tipo genérico T) --> Construtor para a raiz
    public BNode(T data) {
        this(data, null);
    }
    
    /* Setters */
    // setData(dado do tipo genérico T) --> atribui um dado de qualquer tipo ao node
    public void setData(T data) {
        this.data = data;
    }
    
    // setParent(pai do tipo BNode) --> atribui um novo pai para um node
    public void setParent(BNode<T> parent) {
        this.parent = parent;
    }
    
    // setLeft(filho à esquerda do tipo BNode) --> atribui um novo filho para um node na subárvore à esquerda
    public void setLeft(BNode<T> left) {
        this.left = left;
    }
    
    // setRight(filho à direita do tipo BNode) --> atribui um novo filho para um node na subárvore à direita
    public void setRight(BNode<T> right) {
        this.right = right;
    }
    
    /* Getters */
    // getData() --> retorna o dado do node
    public T getData() {
        return data;
    }
    
    // getParent() --> retorna o node pai
    public BNode<T> getParent() {
        return parent;
    }
     
    // getLeft() --> retorna o filho da subárvore à esquerda 
    public BNode<T> getLeft() {
        return left;
    }
    
    // getRight() --> retorna o filho da subárvore à direita 
    public BNode<T> getRight() {
        return right;
    }
    
    /* Métodos Adicionais */
    // isRoot() --> retorna true se um node é uma raiz e false caso contrário
    public boolean isRoot() {
        return parent == null;
    }
    
    // isRoot() --> retorna true se um node é uma folha e false caso contrário
    public boolean isLeaf() {
        return left == right;
    }
    
    // getDegree() --> retorna o grau de um node, podendo ser 0, 1 ou 2
    public int getDegree() {
        int degree = 0;
        if(left != null) ++degree;
        if(right != null) ++degree;
        return degree;
    }
    
    // getLevel() --> retorna o nível de um node
    public int getLevel() {
        if (isRoot()) return 0;
        else return parent.getLevel() + 1;
    }
    
    // getHeight() --> retorna a altura de um node
    public int getHeight() {
        int h;
        
        if(isLeaf()) h = 0; // Folha (Sem Filhos)
        else if(left == null && right != null) h = 1 + right.getHeight(); // Um filho pela direita
        else if(right == null && left != null) h = 1 + left.getHeight(); // Um filho pela esquerda
        else h = (left.getHeight() > right.getHeight()) // Dois filhos
                ? 1 + left.getHeight()
                : 1 + right.getHeight();
        return h;
    }

    protected float see() { return Float.NaN; }
    
    
    @Override
    public String toString() {
        return "Data = " + data 
                + ", parent = " + ((parent == null)? "null" : parent.getData())
                + ", left = " + ((left == null)? "null" : left.getData()) 
                + ", right = " + ((right == null)? "null" : right.getData());
    }
    
}
