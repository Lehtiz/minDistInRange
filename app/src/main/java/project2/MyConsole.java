package project2;

import java.io.Console;
import java.util.ArrayList;

/**
 * Class that handles console input
 */
public class MyConsole {

    /**
     * Method that handles console input and returns an arraylist of inputted int
     * values
     * 
     * @return return ArrayList of user input
     */
    public ArrayList<Integer> consoleInput() {
        var nums = new ArrayList<Integer>();
        Console consoleInput = System.console();
        String input = "";
        System.out.println("Input numbers to evaluate, input empty to finish input");
        boolean loop = true;

        while (loop) {
            try {
                input = consoleInput.readLine();
            } catch (Exception e) {
                throw new IllegalArgumentException("Illegal input");
            }

            if (input.length() > 0) {
                try {
                    nums.add(Integer.parseInt(input));
                } catch (Exception e) {
                    throw new NumberFormatException("Input has to be natural numbers");
                }
            } else {
                System.out.println("finished");
                loop = false;
            }
        }
        return nums;
    }
}
