package project2;

import java.util.ArrayList;

/**
 * A class which handles solving the smallest number that appears between
 * elements in an array
 * 
 * This class does this by counting items left in an array,
 * can also retain the information of what numbers appear between elements
 * 
 */
public class Nums {

    /**
     * A method which returns int value of numbers within a range
     * 
     * @param start start of range
     * @param end   end of range
     * @return Returns int value of numbers within a range
     */
    public int numbersInRange(int start, int end) {
        // Same numbers have a distance of 0
        if (start == end) {
            return 0;
        } else {
            return listNumbersInRange(start, end).size();
        }
    }

    /**
     * A method to find a list of actual numbers within a range
     * 
     * @param start start of range
     * @param end   end of range
     * @return Returns an ArrayList of numbers within a range
     */
    public ArrayList<Integer> listNumbersInRange(int start, int end) {
        // Resolve min and max so that iteration can be done properly
        int biggerNumber = Math.max(start, end);
        int smallerNumber = Math.min(start, end);

        ArrayList<Integer> list = new ArrayList<>();
        // Iterate betweemn numbers, excluding both start and end from list
        for (int i = smallerNumber; i < biggerNumber; i++) {
            // exclude both start and end of the range
            if (i != smallerNumber && i != biggerNumber) {
                list.add(i);
            }
        }
        return list;
    }

    /**
     * Helper method to clean up an array for operations
     * Array has to have unitue values, so distance betwee nis only canculated once
     * Array is sorted so distance between elements is easy to calculate
     * 
     * @param arr Input array
     * @return Return a sorted ArrayList with only unique values
     */
    private ArrayList<Integer> prepareArray(int[] arr) {
        // Use arrayList because the amount of values after opearations is unknown
        var preparedArray = new ArrayList<Integer>();
        // Cloning array, so original is not touched by sorting
        int[] newArr = arr.clone();

        // Sort array to natural order before doing other operations
        java.util.Arrays.sort(newArr);

        // Iterate array to filter out non unique values
        for (int i = 0; i < newArr.length; i++) {
            // Only add value to preparedArray if value is unique
            if (!preparedArray.contains(newArr[i])) {
                preparedArray.add(newArr[i]);
            }
        }
        return preparedArray;
    }

    /**
     * A method which calculates the smallest distance between elements in a
     * given array
     * 
     * @param arr input array
     * @return Returns an integer value of the smallest distance between elements
     */
    public int getMinDistance(int[] arr) {
        int minDist = 2147483647; // Init at max int value
        var newArr = new ArrayList<Integer>();

        // Do cleanup operations for array
        newArr = prepareArray(arr);

        System.out.println("Original input: " + java.util.Arrays.toString(arr));
        System.out.println("Prepared data: " + newArr.toString());

        int pair = 1; // Pair iterator , eg. 1-2, 2-3, 3-4
        int num1 = 0; // First element
        int num2 = 0; // Second element
        int val = 0; // distance value

        while (pair < newArr.size()) {
            // Start num1 from the 1st index (0), with pair 1
            num1 = newArr.get(pair - 1);
            num2 = newArr.get(pair);

            val = numbersInRange(num1, num2);
            var list = listNumbersInRange(num1, num2);

            System.out.printf("Comparing %d and %d, distance = %d %s\n", num1, num2, val,
                    java.util.Arrays.toString(list.toArray()));

            // If new lowest minDist update value
            if (val < minDist) {
                minDist = val;
                // Exit loop if minDist hits 0, distance between numbers cannot be smaller
                if (minDist == 0) {
                    break;
                }
            }
            pair++;
        }

        return minDist;
    }
}
