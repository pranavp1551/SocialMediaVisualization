package prj5;

import java.io.FileNotFoundException;

/**
 * This is the project runner class for the project
 *
 * @author Valery Folomeev vfolomeev
 * @version 11/16/2022
 */
public class Input {

    /**
     * Main method
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 1) {
            Reader userReader = new Reader(args[0]);
        }
        else {
            Reader userReader = new Reader("SampleInput1_2022.csv");
        }
    }
}
