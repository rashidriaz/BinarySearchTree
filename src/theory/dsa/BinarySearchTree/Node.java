package theory.dsa.BinarySearchTree;

public class Node {
    private int data;
    private Node left;
    private Node right;

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
    public void setData(int data){
        this.data = data;
    }

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public boolean hasLeft(){
        return this.left != null;
    }
    public boolean hasRight(){
        return this.right != null;
    }
}
