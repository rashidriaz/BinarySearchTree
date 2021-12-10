package theory.dsa.BinarySearchTree;

import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);
   /* public static void main(String[] args) {
            BinaryTree tree = new BinaryTree();
        for (int i = 0; i < 5; i++){
            System.out.print("\nEnter data:\t");
            int data = input.nextInt();
            input.nextLine();
            tree.insert(data);
        }
        tree.printInOrder();
        tree.printPreOrder();
        tree.printPostOrder();

        System.out.print("\nFind number:\t");
        int inputData = input.nextInt();
        input.nextLine();
        boolean numberExists = tree.numberExists(inputData);

        if (numberExists){
            System.out.println("\nThe number " +  inputData + " does exist");
        }else {
            System.out.println("\nThe number " +  inputData + " does not exist");
        }
        System.out.print("\nCount occurrences:\t");
        inputData = input.nextInt();
        input.nextLine();
        System.out.println("Number " + inputData + " occurred " + tree.countOccurrencesOfNumber(10) + "times");

        System.out.println("Maximum: " + tree.getMaximum());
        System.out.println("Minimum: " + tree.getMinimum());

        System.out.print("\nDelete Number\t");
        inputData = input.nextInt();
        input.nextLine();
        try {
            tree.deleteData(inputData);
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        tree.printInOrder();

    }
    */

    public static void main(String[] args) {
        int[] array = {2,1,5,90,18,30,100};
        BinaryTree tree = toBST(array);
        printArray(array);
        tree.printInOrder();
        if (tree.isBalanced()){
            System.out.println("\nTree is balanced");
        }else {
            System.out.println("\nTree is not balanced");
        }
        System.out.println("----------------------------------------");
        int[] array2 = {2,1,5,4,7};
        BinaryTree tree2 = toBST(array2);
        printArray(array2);
        tree2.printInOrder();
        if (tree2.isBalanced()){
            System.out.println("\nTree is balanced");
        }else {
            System.out.println("\nTree is not balanced");
        }
    }


    public static void printArray(int[] array){
        System.out.println("\narray is: \n");
        for (int number: array) {
            System.out.print(number + ",\t");
        }
    }

    public static BinaryTree toBST(int[] array){
       BinaryTree tree = new BinaryTree();
        for (int number : array) {
            tree.insert(number);
        }
        return tree;
    }
}
