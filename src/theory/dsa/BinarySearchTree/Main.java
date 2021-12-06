package theory.dsa.BinarySearchTree;

import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
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
}
