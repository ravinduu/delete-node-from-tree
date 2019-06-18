public class Tree{
  private Node root = null;

  //method for insert data
  public void insert(int data){
    if(root == null){
      root = new Node(data);
      return;
    }
    insert(root, new Node(data));
  }

  private static void insert(Node node, Node newNode){
    if(node.getData() <= newNode.getData()){
      if(node.right == null) node.right = newNode;
      else insert(node.right,newNode);
    }
    else {
      if(node.left == null) node.left = newNode;
      else insert(node.left,newNode);
    }
  }

  //1) a). Three traversal methods (inorder, preorder, postorder)
  public void printPostOrder(){
    if(root == null){
      System.out.println("Error, tree is empty!!");
      return;
    }
    System.out.println("\n*** Print postOrder ***");
    printPostOrder(root);
    System.out.println();
  }
  private static void printPostOrder(Node node){
    if(node == null) return;

    printPostOrder(node.left);
    printPostOrder(node.right);
    System.out.print(node.getData()+" ");
  }

  public void printInOrder(){
    if(root == null){
      System.out.println("Error, tree is empty!!");
      return;
    }
    System.out.println("\n*** Print intOrder ***");
    printInOrder(root);
    System.out.println();
  }
  private static void printInOrder(Node root){
    if(root == null) return;

    printInOrder(root.left);
    System.out.print(root.getData()+" ");
    printInOrder(root.right);
  }

  public void printPreOrder(){
    if(root == null){
      System.out.println("Error, tree is empty!!");
      return;
    }
    System.out.println("\n*** Print preOrder ***");
    printPreOrder(root);
    System.out.println();
  }
  private static void printPreOrder(Node root){
    if(root == null) return;

    System.out.print(root.getData()+" ");
    printPreOrder(root.left);
    printPreOrder(root.right);
  }

  /*1) b). A method to search and return a reference to the searched node which searches nodes closer to the root node first.*/
  public Node search(int value){
    System.out.println();
    if(root == null){
      System.out.println("Error, Tree is empty!!");
      return null;
    }

    if(root.getData() == value){
      return root;
    }
    else{
      if(root.getData() < value) return search(root.right,value);
      else return search(root.left,value);
    }
  }
  private static Node search(Node node, int value){
    while(node != null){
      if(node.getData() == value) {
        return node;
      }
      else{
        if(node.getData() < value) return search(node.right,value);
        else return search(node.left,value);
      }
    }
    System.out.println("Error, Not Found!!");
    return null;
  }


  //method for delete
  public void delete(int data){
    deleteNode(root,data);
  }
  private static Node deleteNode(Node node, int data){
	  Node parent = null;
		Node curr = node;

		while (curr != null && curr.getData() != data){
			parent = curr;
			if (data < curr.getData()) {
				curr = curr.left;
			}
			else {
				curr = curr.right;
			}
		}

		if (curr == null) {
			return node;
		}

		if (curr.left == null && curr.right == null){

			if (curr != node) {
				if (parent.left == curr) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			}
			else {
				node = null;
			}
      System.out.print("\nSuccesfully Deleted");
		}
		else{
			Node child = (curr.left != null)? curr.left: curr.right;
			if (curr != node){
				if (curr == parent.left) {
					parent.left = child;
				} else {
					parent.right = child;
				}
			}
	    else {
				node = child;
			}
      System.out.print("\nSuccesfully Deleted");
		}
		return node;
	}

  /*1) c). Method to delete a particular node that uses maximum of left sub-tree in order to replace
the deleted node.*/
  public void deleteMaxLeftSubTree(int data){
    deleteMaxLeftSubTree(root,data);
  }
  private static void deleteMaxLeftSubTree(Node node, int data){
    System.out.print("\nDelete using Maximum of Left sub tree method");

    Node curr = node;
    while (curr != null && curr.getData() != data){
			if (data < curr.getData()) {
				curr = curr.left;
			}
			else {
				curr = curr.right;
			}
		}

    Node successor = maxLeft(curr.left);
    int val = successor.getData();
    deleteNode(node, successor.getData());
    curr.setData(val);
  }
  private static Node maxLeft(Node node) {
       while (node.right != null){
           node = node.right;
       }
       return node;
   }

   /*1) d). Method to delete a particular node that uses minimum of right sub-tree in order to replace
the deleted node.*/
   public void deleteMinRightSubTree(int data){
     deleteMinRightSubTree(root,data);
   }
   private static void deleteMinRightSubTree(Node node, int data){
     System.out.print("\nDelete using Minimum of right sub tree method");

     Node curr = node;
     while (curr != null && curr.getData() != data){
 			if (data < curr.getData()) {
 				curr = curr.left;
 			}
 			else {
 				curr = curr.right;
 			}
 		}

     Node successor = minRight(curr.right);
     int val = successor.getData();
     deleteNode(node, successor.getData());
     curr.setData(val);
   }
   private static Node minRight(Node node) {
        while (node.left != null){
            node = node.left;
        }
        return node;
    }
}
