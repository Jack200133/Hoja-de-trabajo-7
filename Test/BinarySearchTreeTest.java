import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    @Test
    public void add() {
        BinarySearchTree bst = new BinarySearchTree();
        ComparableAssociation A1 = new ComparableAssociation("Jack",3);
        ComparableAssociation A2 = new ComparableAssociation("Chupi",4);

        bst.add(A1);
        bst.add(A2);
        assert(bst.contains(A1));
    }

    @Test
    public void contains() {
        BinarySearchTree bst = new BinarySearchTree();
        ComparableAssociation B1 = new ComparableAssociation("Jack",3);
        ComparableAssociation B2 = new ComparableAssociation("Chupi",4);

        bst.add(B1);
        bst.add(B2);
        assert(bst.contains(B2));
    }
}