// This program is copyright VUW.
// You are granted permission to use it to construct your assignment answer,
// You may not distribute it in any other way without permission.
//
/* Code for COMP102
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;

/** Four methods that use ArrayLists
 * plotNumbers():
 *      read numbers from file into an ArrayList of numbers
 *      then plot them as rectangles 
 *
 * readAndReverse():
 *      read tokens from file into an ArrayList of Strings
 *      then access values in reverse order
 *
 * plotColoredNumbers():
 *      just like plotNumbers, but colors the rectangles, 
 *      green for small, red for large, and black for middle.
 *
 * printDifferences():
 *      read numbers from file into an ArrayList of numbers
 *      Then print out the differences between each adjacent pair of numbers.

 */

public class ArrayListExercise{

    /**
     * Constructor to set up an interface with buttons to call all the methods
     */
    public ArrayListExercise(){
        UI.addButton("Clear", UI::clearPanes);
        UI.addButton("Show file", this::showFile);
        UI.addButton("Plot Numbers", this::plotNumbers);
        UI.addButton("ReadAndReverse", this::readAndReverse);
        UI.addButton("Plot in Color", this::plotColoredNumbers);
        UI.addButton("Print Differences", this::printDifferences);
        UI.addButton("Quit", UI::quit);
    }


    /**
     * Reads a sequence of numbers from a file into an ArrayList
     * Then plots the numbers as a sequence of rectangles of width = 5 and
     * height = the number being plotted,
     * Note: you must read all the numbers before plottin any of them.
     * Test on numbers1.txt
     */
    public void plotNumbers(){
        UI.clearGraphics();
        double base = 450;
        UI.drawLine(0, base, 600, base);     // draws the base line
        ArrayList<Double> nums = new ArrayList<Double>(); // the ArrayList of numbers

        try{
            Scanner sc = new Scanner(new File(UIFileChooser.open()));
            // read numbers from the file into the ArrayList
            /*# YOUR CODE HERE */

            sc.close();
        } catch(IOException e){UI.println("Fail: " + e);}
        // plot the numbers
        double x = 0; // x position of first bar (increment by 6 each time)
        /*# YOUR CODE HERE */

    }


    /** 
     * Asks the user for a file, and reads each token from the file, storing
     *   them in an ArrayList.
     * It prints out the number of tokens it read and 
     *   then prints the tokens in reverse order.
     * Test on a-story.txt and b-story.txt
     */
    public void readAndReverse(){
        UI.clearText();
        ArrayList<String> tokens = new ArrayList<String>(); // the ArrayList of tokens
        try{
            Scanner sc = new Scanner(new File(UIFileChooser.open()));
            /*# YOUR CODE HERE */

        } catch(IOException e){UI.println("File reading failed");}
    }



    /**
     * Reads a sequence of numbers from a file into an ArrayList
     * Finds the number half way through the sequence of numbers
     * [if the size of the list is n, the half way number is at index (n-1)/2 ]
     * Then plots the numbers as a sequence of colored rectangles of width = 5 and
     * height = the number being plotted. 
     * The color is
     *    green if the number is less than the middle number,
     *    black if it is equal to the middle number, 
     *    red if it is larger than the middle number.
     * Note: it has to read all the numbers before it can plot any of them.
     *
     * Use the code from plotNumbers as a starting point.
     */
    public void plotColoredNumbers(){
        UI.clearGraphics();
        /*# YOUR CODE HERE */

    }

    /**
     * Reads a sequence of numbers from a file into an ArrayList,
     * then prints out the differences between adjacent values
     * eg, if the list is  [4, 7, 12, 8], it will print 3 5 -4
     * You can use the code for plotNumbers as a starting point.
     * Test on numbers2.txt
     */
    public void printDifferences(){
        UI.clearText();
        /*# YOUR CODE HERE */
        
    }


    /** ---------- The code below is already written for you ---------- **/

    /**
     * Utility method to list the contents of a file.
     */
    public void showFile(){
        String fname = UIFileChooser.open();
        UI.println("Contents of " + fname+":\n----------------");
        try{
            Scanner sc = new Scanner(new File(fname));
            while (sc.hasNextLine()) {
                UI.println(sc.nextLine());
            }
            sc.close();
            UI.println("--------------");
        } catch(IOException e){System.out.printf("Fail: %s\n", e);}
    }


    public static void main(String[] args){
        new ArrayListExercise();
    }        

}
