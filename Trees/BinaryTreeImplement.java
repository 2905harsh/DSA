import java.util.Scanner;

class BinaryTreeImplement{

  public BinaryTreeImplement(){

  }

  private static class Node{
     int value;
     Node left;
     Node right;
     public Node(int value){
          this.value=value;
     }
  }

  private Node root;
  
  //insert elements
  public void populate(Scanner sc){
    System.out.println("Enter the root Node Value");
    int value = sc.nextInt();
    root = new Node(value);
    populate(sc,root);
  }

  private void populate(Scanner sc , Node node){

    System.out.println("Do you want to add left of " + node.value);
    boolean left = sc.nextBoolean();

    if(left){
      System.out.println("ENTER THE VALUE OF THE LEFT OF " + node.value);
      int value = sc.nextInt();
      node.left = new Node(value);
      populate(sc,node.left);
    }

    System.out.println("Do you want to add right of " + node.value);
    boolean right = sc.nextBoolean();

    if(right){
      System.out.println("ENTER THE VALUE OF THE RIGHT OF " + node.value);
      int value = sc.nextInt();
      node.right = new Node(value);
      populate(sc,node.right);
    }
  }

  public void display(){
    display(root,"");
  }
  private void display(Node node , String indent){
    if(node==null) return ; 
    System.out.println(indent + node.value);
    display(node.left,indent+"\t");
    display(node.right,indent+"\t");

  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    BinaryTreeImplement tree = new BinaryTreeImplement();
    tree.populate(sc);
    System.out.println("The Binary Tree is : ");
    tree.display();
  }
  
}