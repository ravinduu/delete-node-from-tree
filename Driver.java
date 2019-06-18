public class Driver{
  public static void main(String[] args){
    Tree t = new Tree();

    t.insert(18);
    t.insert(9);
    t.insert(26);
    t.insert(3);
    t.insert(16);
    t.insert(20);
    t.insert(34);
    t.insert(1);
    t.insert(5);
    t.insert(11);
    t.insert(17);
    t.insert(19);
    t.insert(23);
    t.insert(32);
    t.insert(13);
    t.insert(21);
    t.insert(12);

    t.printPostOrder();
    t.printInOrder();
    t.printPreOrder();

    System.out.print("\nDeleting 1..... ");
    t.delete(1);
    t.printPostOrder();

    System.out.print("\nDeleting 34..... ");
    t.delete(34);
    t.printPostOrder();

    System.out.print("\nDeleting 9..... ");
    t.deleteMinRightSubTree(9);
    t.printPostOrder();

    System.out.print("\nDeleting 20..... ");
    t.deleteMaxLeftSubTree(20);
    t.printPostOrder();
  }
}
