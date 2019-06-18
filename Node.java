public class Node{
  private int data;
  protected Node left;
  protected Node right;

  public Node(int data){
    this.data = data;
  }

  public int getData(){
    return this.data;
  }

  public void setData(int data){
    this.data = data;
  }
}
