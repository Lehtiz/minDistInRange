package project2;

import java.util.ArrayList;

/**
 * Simple program to calculate the smallest amount of numbers between array
 * elements
 */
public class App {

    /**
     * A method that uses Nums class to perform calculation
     * 
     * @param nums Arraylist of users numbers
     */
    private static void doOperation(ArrayList<Integer> nums) {

        // SimpleNums myNums = new SimpleNums();

        // translate into an array
        int[] arr = new int[nums.size()];
        arr = nums.stream().mapToInt(i -> i).toArray();

        // System.out.println("Smallest distance between elements in array is " + myNums.getMinDistance(arr));
    }

    /**
     * Main program
     * 
     * @param args args
     */
    public static void main(String[] args) {
        var arr = new ArrayList<Integer>();
        MyConsole cInput = new MyConsole();

        // Get user input
        arr = cInput.consoleInput();

        doOperation(arr);
    }

}
