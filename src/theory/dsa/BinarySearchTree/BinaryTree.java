package theory.dsa.BinarySearchTree;

public class BinaryTree {
    Node root;


    public void insert(int data){
        if (root == null){
            root = new Node(data);
            return;
        }
        insert(new Node(data), root);

    }

    private void insert(Node data, Node node){
        if (data.getData() < node.getData()){
            if (node.getLeft() == null){
                node.setLeft(data);
                return;
            }
            insert(data, node.getLeft());
        }else {
            if(node.getRight() == null){
                node.setRight(data);
                return;
            }
            insert(data, node.getRight());
        }
    }

    public void printInOrder(){
        System.out.println("\nBinary tree printed in In Order");
        printInOrder(this.root);
    }
    private void printInOrder(Node root){

        if (root.hasLeft()){
            printInOrder(root.getLeft());
        }
        System.out.print(root.getData() + "\t");
        if (root.hasRight()){
            printInOrder(root.getRight());
        }
    }

    public void printPreOrder(){
        System.out.println("\nBinary tree printed in Pre Order");
        printPreOrder(root);
    }

    private void printPreOrder(Node root){
        System.out.print(root.getData() + "\t");
        if(root.hasLeft()){
            printPreOrder(root.getLeft());
        }
        if(root.hasRight()){
            printPreOrder(root.getRight());
        }
    }

    public void printPostOrder(){
        System.out.println("\nBinary tree printed in Post Order");
        printPostOrder(root);
    }

    private void printPostOrder(Node root){
        if(root.hasLeft()){
            printPostOrder(root.getLeft());
        }
        if(root.hasRight()){
            printPostOrder(root.getRight());
        }
        System.out.print(root.getData() + "\t");
    }

    public boolean numberExists(int number){
        return findNode(number, this.root) != null;
    }

    private Node findNode(int number, Node root){
        if (number == root.getData()){
            return root;
        }
        if (number < root.getData()){
            return root.hasLeft()? findNode(number, root.getLeft()) : null;
        }else {
            return root.hasRight() ? findNode(number, root.getRight()) : null;
        }

    }

    public int countOccurrencesOfNumber(int number){
        Node currentNode = this.root;
        int counter = 0;
        while (currentNode != null){
            if (currentNode.getData() == number){
                counter++;
            }else if (currentNode.getData() > number) {
                currentNode = currentNode.getLeft();
                continue;
            }
                currentNode = currentNode.getRight();
        }

        return counter;
    }

    private Node getMinimumNode(Node node){
        Node currentNode = node;

        while (true){
            if (currentNode.hasLeft()){
                currentNode = currentNode.getLeft();
            }else {
                return currentNode;
            }
        }
    }
    public int getMinimum(){
        return getMinimumNode(this.root).getData();
    }

    private Node getMaximumNode(Node node){
        Node currentNode = node;

        while (true){
            if (currentNode.hasRight()){
             currentNode = currentNode.getRight();
            }else{
               return currentNode;
            }
        }
    }
    public int getMaximum(){
       return getMaximumNode(this.root).getData();
    }


    public void deleteData(int number) throws Exception{

       root = deleteData(root, number);
    }

    private Node deleteData(Node node, int number)throws Exception{
        if (root == null){
            throw new Exception("Empty tree");
        }
        if (number < node.getData()){
            node.setLeft(deleteData(node.getLeft(), number));
            return node;
        }
        if (number > node.getData()){
            node.setRight(deleteData(node.getRight(), number));
            return node;
        }
        if (hasBothChild(node)){
            int minimumValueFromRightSubTree = getMinimumNode(node.getRight()).getData();
            node.setData(minimumValueFromRightSubTree);
            node.setRight(deleteData(node.getRight(), minimumValueFromRightSubTree));
            return node;
        }else
        if (hasNoChild(node)){
                return null;
        }
        return node.hasRight()? node.getRight() : node.getLeft();

    }


    public boolean isBalanced(){
        return isBalanced(this.root);
    }

    private boolean isBalanced(Node node){

        if (hasNoChild(node)){
            return true;
        }
        if (hasOnlyOneChild(node)){
            return false;
        }
        return isBalanced(node.getLeft()) && isBalanced(node.getRight());
    }

    private boolean hasOnlyOneChild(Node node){
        return (node.hasLeft() && !node.hasRight()) || (!node.hasLeft() && node.hasRight());
    }

    private boolean hasNoChild(Node node){
        return !node.hasRight() && !node.hasLeft();
    }

    private boolean hasBothChild(Node node){
        return node.hasRight() && node.hasLeft();
    }

}
