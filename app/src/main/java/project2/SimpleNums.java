package project2;

import java.util.ArrayList;

/**
 * A class which handles solving the smallest number that appears between
 * elements in an array
 * 
 * This class assuming formula from examples
 * between 1 and 4, is 2 and 3
 * 1 (2 3) 4 -> 2
 * 1 (2) 3 -> 1
 * 3 (4) 5 -> 1
 * 7 (8 9 10) 11 -> 3
 * 
 */
public class SimpleNums {

    /**
     * A method which returns int value of numbers within a range
     * 
     * @param start Start of range
     * @param end   End of range
     * @return int value of numbers within a range
     */
    public int numbersInRange(int start, int end) {
        // Same numbers have a distance of 0
        if (start == end) {
            return 0;
        } else {
            int result = 0;

            // Calculate the amount of numbers between two integers
            // -1 so last number in range is not counted
            result = Math.abs(start - end) - 1;

            // return absolute
            return result;
        }
    }

    /**
     * A method which returns smallest int value of numbers within a range in an
     * array.
     * Compares neighbouring values of a sorted and uniquefied array to determine
     * the smallest range
     * 
     * @param arr input array
     * @return smallest int value of numbers within a range in an array
     */
    public int getMinDistance(int[] arr) {
        int minDist = 2147483647; // Init at max int value
        var newArr = new ArrayList<Integer>();

        // Do cleanup operations for array
        newArr = prepareArray(arr);

        int pair = 1; // Pair iterator , eg. 1-2, 2-3, 3-4 in 1-4
        int num1 = 0; // First element
        int num2 = 0; // Second element
        int val = 0; // distance value

        while (pair < newArr.size()) {
            // Start num1 from the 1st index (0), with pair 1
            num1 = newArr.get(pair - 1);
            num2 = newArr.get(pair);

            val = numbersInRange(num1, num2);
            System.out.printf("Comparing %d and %d, distance = %d\n", num1, num2, val);

            // If new lowest minDist update value
            if (val < minDist) {
                minDist = val;
            }
            pair++;
        }

        return minDist;
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

}
