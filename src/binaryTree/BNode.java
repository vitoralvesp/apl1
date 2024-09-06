package binaryTree;

public class BNode<T> {
    private T data;
    private BNode<T> parent;
    private BNode<T> left;
    private BNode<T> right;

    //Nós em geral
    public BNode(T data, BNode<T> parent) {
        this.data = data;
        this.parent = parent;
        right = left = null;
    }

    //Raiz
    public BNode(T data) {
        this(data,null);
    }
    
   
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BNode<T> getParent() {
        return parent;
    }

    public void setParent(BNode<T> parent) {
        this.parent = parent;
    }

    public BNode<T> getLeft() {
        return left;
    }

    public void setLeft(BNode<T> left) {
        this.left = left;
    }

    public BNode<T> getRight() {
        return right;
    }

    public void setRight(BNode<T> right) {
        this.right = right;
    }
    
    public boolean isRoot(){
        return parent == null;
    }
    
    public boolean isLeaf(){
        return left == right;
    }
    
    public int getDegree(){
        int degree = 0;
        if(left != null) ++degree;
        if(right != null) ++degree;
        return degree;
    }
    
    public int getLevel() {
        if (isRoot()) return 0;
        else return parent.getLevel()+1;
    }
    
    public int getHeight(){
        int h;
        
        //Folha (Sem Filhos)
        if(isLeaf()) h = 0; 
        //Um filho pela direita
        else if(left == null && right != null) h = 1 + right.getHeight();
        //Um filho pela esquerda
        else if(right == null && left != null) h = 1 + left.getHeight();
        //Dois filhos
        else h = (left.getHeight() > right.getHeight())
                ? 1 + left.getHeight()
                : 1 + right.getHeight();
        return h;
    }

    
    protected float see(){return Float.NaN;}

    @Override
    public String toString() {
        return "Data = " + data 
                + ", parent = " + ((parent == null)? "null" : parent.getData())
                + ", left = " + ((left == null)? "null" : left.getData()) 
                + ", right = " + ((right == null)? "null" : right.getData());
    }
    
}
