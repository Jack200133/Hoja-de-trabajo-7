import java.util.Iterator;
/**
 *
 * @param <E> Parametro para la que la clase sea generica
 * @author Jack (Juan Angel Carrera)
 * @since 11/04/2021
 * @version 11/04/2021
 *
 * Implementacion de los nodos para un arbol binario tomando la refencia dada en clase
 */

public class BinaryTree<E> {
    /**
     * Valor asociado al nodo
     */
    protected  E valor;
    /**
     * Padre del nodo
     */
    protected BinaryTree<E> parent;
    /**
     * Los hijos de este nodo, o un nodo vacio
     */
    protected BinaryTree<E> left, right;

    /**
     * Constructor de arboles vacios
     * La eficiencia de espacio es posible gracias a estos
     *
     * @post Constructor que genera un nodo vacio
     * @return un nodo vacio
     */
    public BinaryTree(){
        valor=null;
        parent = null;
        left = right = this;
    }


    /**
     * Constructor de un arbol sin hijos. El valor del nodo y subarboles son proporcionados
     * por el usuario
     *
     * @post Devuelve un arbol con un valor y dos hijos vacios
     * @param valor Un valor que sera referenciado por el nodo
     */
    public BinaryTree(E valor){
        this.valor = valor;
        right = left = new BinaryTree<E>();
        setLeft(left);
        setRight(right);
    }

    /**
     * Constructor de un arbol con 2 hijos, valor dado por el usuario
     *
     * @post Devuelve la referencia del valor y de los dos hijos
     * @param valor Un valor que sera referenciado por el nodo
     * @param left El subarboles que sera la izquierda del nodo
     * @param right El subarbol que sera la derecha del nodo
     */
    public BinaryTree(E valor, BinaryTree<E> left, BinaryTree<E> right){

        this.valor=valor;
        if(left== null){
            left=new BinaryTree<E>();
        }
        setLeft(left);
        if(right== null){
            right=new BinaryTree<E>();
        }
        setRight(right);
    }

    /**
     * Obtiene el subarbol izquierdo del nodo
     *
     * @post Devuelve la referencia del subarbol izquierdo
     * @return el subarbole izquierdo del nodo
     */
    public BinaryTree<E> getLeft() {
        return left;
    }

    /**
     * Obtiene el subarbol derecho del nodo
     *
     * @post Devuelve la referencia del subarbol derecho
     * @return el subarbol derecho del nodo
     */
    public BinaryTree<E> getRight() {
        return right;
    }

    /**
     * Obtiene la referencia del padre del nodo
     *
     * @post Devuelve la referencia del padre o null
     * @return referencia del padre del nodo
     */
    public BinaryTree<E> getParent() {
        return parent;
    }

    /**
     * devuelve si el arbol esta vacion
     *
     * @post devuelve si el nodo del arbo esta vacio
     * @return verdadero si el arbol vacio
     */
    public boolean isEmpty()
    {
        return valor == null;
    }

    /**
     * Actualiza el subarbol izquierdo del nodo
     *
     * @post Settea el subarbol izquierdo a NewLeft
     * @param newLeft La nueva raiz del subarbol izquierdo
     */
    public void setLeft(BinaryTree<E> newLeft)
    {
        if (isEmpty()) return;
        if (left != null && left.getParent() == this) left.setParent(null);
        left = newLeft;
        left.setParent(this);
    }

    /**
     * Actualiza el subarbol derecho del nodo
     *
     * @post Settea el subarbol derecho a NewRight
     * @param newRight La nueva raiz del subarbol derecho
     */
    public void setRight(BinaryTree<E> newRight)
    {
        if (isEmpty()) return;
        if (right != null && right.getParent() == this) right.setParent(null);
        right = newRight;
        right.setParent(this);
    }

    /**
     * Actualiza el padre del nodo
     *
     * @post Settea el padre subarbol a newParent
     * @param newParent El nuevo padre del nodo
     */
    protected void setParent(BinaryTree<E> newParent)
    {
        if (!isEmpty()) {
            parent = newParent;
        }
    }

    /**
     * Devuelve el numero de descendientes del nodo
     *
     * @post Devuelve el tamaño del subarbol
     * @return tamaño del subarbol
     */
    public int size()
    {
        if (isEmpty()) return 0;
        return getLeft().size() + getRight().size() + 1;
    }

    /**
     * Devuelve la referencia de la raiz del arbol
     *
     * @post Devuelve la raiz del nodo del arbol
     * @return Raiz del arbol
     */
    public BinaryTree<E> root()
    {
        if (getParent() == null) return this;
        else return getParent().root();
    }

    /**
     * Determina  si este nodo es un hijo izquierdo
     *
     * @post Devuelve True si el nodo es el hijo izquierdo del padre
     * @return True si es el hijo izquierdo del padre
     */
    public boolean isLeftChild()
    {
        if (getParent() == null) return false;
        return this == getParent().getLeft();
    }


    /**
     * Determina si este nodo es el hijo derecho
     *
     * @return True si el nodo es el hijo derecho del padre
     */
    public boolean isRightChild()
    {
        if (getParent() == null) return false;
        return this == getParent().getRight();
    }

    /**
     * Devuelve el valor asociado al nodo es
     *
     * @return el valor del nodo
     */
    public E getValor() {
        return valor;
    }

    /**
     * Pone el valor asociado al nodo
     * @param valor El nuevo valor del nodo
     */
    public void setValor(E valor) {
        this.valor = valor;
    }

    /**
     *
     * @return suma de los hashcodes de los valores contenidos
     */
    public int hashCode()
    {
        if(isEmpty()) return 0;
        int resultado = getLeft().hashCode() + getRight().hashCode();
        if(getValor() != null) resultado += getValor().hashCode();
        return resultado;
    }

    /**
     * Calcula la profundidad de un nodo. Esta es calculado de la raiz a la rama
     *
     * @return el tamaño de la raiz del arbol
     */
    public int profundidad() {
        if (getParent() == null) return 0;
        return 1+ parent.profundidad();
    }

    /**
     * Un metodo de soporte para treeString. Devuelve R si el nodo es un
     * hijo derecho, L si es un hijo izquierdo y Root si es el nodo es la raiz
     * @return R si el nodo es un hijo derecho, L si es un hijo izquierdo y Root si es el nodo es la raiz
     */
    private String getMano(){
        if (isRightChild()) return "R";
        if (isLeftChild()) return "L";
        return "Root";
    }

    /**
     *
     * @return Un string que representa la raiz del arbol en este nodo
     */
    public String treeString(){
        StringBuilder s = new StringBuilder();
        s.append("\t|".repeat(Math.max(0, this.profundidad())));

        s.append("<").append(valor).append(" : ").append(getMano()).append(">\n");

        if (!left.isEmpty()) s.append(left.treeString());
        if (!right.isEmpty()) s.append(right.treeString());

        return s.toString();
    }

    /**
     * Devuelve una repsesentacion de la raiz del subarbol en este nodo
     * @return String representando el subarbol
     */
    public String toString() {
        if(isEmpty())return  "BinaryTree: empty";
        StringBuilder s = new StringBuilder();
        s.append("<BinaryTree ").append(getValor());
        if (!getLeft().isEmpty()) s.append(" ").append(getLeft());
        else s.append(" -");
        if (!getRight().isEmpty()) s.append(" ").append(getRight());
        else s.append(" -");
        s.append('>');
        return s.toString();
    }

    public void inorderIterator(BinaryTree nood) {

        if (nood.isEmpty())
            return;

        /* first recur on left child */
        inorderIterator(nood.getLeft());

        /* then print the data of node */
        System.out.print(nood.getValor() + " ");

        /* now recur on right child */
        inorderIterator(nood.getRight());


    }
}
