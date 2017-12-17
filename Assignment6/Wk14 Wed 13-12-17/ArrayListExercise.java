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

 // DRAFT CODE HERE
 * sieve():
 *      Make an ArrayList of integers containing 1 .. 100
 *      Let the use choose a number then remove all multiples of it from the list
 *  Uses an ArrayList. 
 *
 // END OF DRAFT CODE 
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
            while (sc.hasNextDouble()){
                nums.add(sc.nextDouble());
            }
            /*# END OF YOUR CODE */

            sc.close();
        } catch(IOException e){UI.println("Fail: " + e);}
        // plot the numbers
        double x = 0; // x position of first bar (increment by 6 each time)
        /*# YOUR CODE HERE */
        double mid = nums.get((nums.size()-1)/2);
        for (double num : nums){
            UI.fillRect(x, base-num, 25, num);
            x = x+26;
            x



        }
        /*# END OF YOUR CODE */

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
            // DRAFT CODE HERE
            //javax.swing.JOptionPane.showMessageDialog(null, "Demo always loads a-story.txt\nYour program should let the user choose.");
            //Scanner sc = new Scanner(new File("a-story.txt"));
            // END OF DRAFT CODE
            Scanner sc = new Scanner(new File(UIFileChooser.open()));
            /*# YOUR CODE HERE */
            while (sc.hasNext()){
                tokens.add(sc.next());
            }
            sc.close();
            UI.printf("read %d tokens.\n-----------\n", tokens.size());
            for (int i = tokens.size()-1; i>=0; i=i-1){
                UI.println(tokens.get(i));
            }
            /*# END OF YOUR CODE */

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
        double base = 450;
        UI.drawLine(0, base, 600, base);     // draws the base line
        ArrayList<Double> nums = new ArrayList<Double>(); // the ArrayList of numbers

        try{
            Scanner sc = new Scanner(new File(UIFileChooser.open()));
            while (sc.hasNextDouble()){
                nums.add(sc.nextDouble());
            }
            sc.close();
        } catch(IOException e){UI.println("Fail: " + e);}
        // plot the numbers, (small:green;  large:red;  middle:black
        double x = 0; // x position of first bar (increment by 6 each time)
        double mid = nums.get((nums.size()-1)/2);
        for (double num : nums){
            if (num<mid)       { UI.setColor(Color.green); }
            else if (num==mid) { UI.setColor(Color.black); }
            else               { UI.setColor(Color.red); }
            UI.fillRect(x, base-num, 25, num);
            x = x+30;
        }
        /*# END OF YOUR CODE */

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
        ArrayList<Double> nums = new ArrayList<Double>(); // the ArrayList of numbers
        try{
            Scanner sc = new Scanner(new File(UIFileChooser.open()));
            while (sc.hasNextDouble()){
                nums.add(sc.nextDouble());
            }
            sc.close();
        } catch(IOException e){UI.println("Fail: " + e);}

	for (int i = 0; i < nums.size()-1; i++){
	    UI.println(nums.get(i+1) - nums.get(i));
	}
	/*# END OF YOUR CODE */
	
    }

    // DRAFT CODE HERE
    /** CHANGE THIS METHOD
     * Creates a list of integers, and adds each number from 1 to 100 to the list.
     * Prints them out.
     * Then repeatedly asks the user for a number, and removes all multiples of that
     * number (except for the number itself) from the list, and prints this list out again.
     * For example, if the user selects 5, it will remove 10, 15, 20, 25, 30, etc from the list
     * It should quit asking when the user selects 0.
     * Hints:
     *    you should work backwards down the list to remove multiples, not forwards.
     *    if m is a multiple of n, then m%n == 0  (the remainder) 
     */
    public void sieve (){
        ArrayList <Integer> numbers = new ArrayList<Integer>(); 
        /*# YOUR CODE HERE */
        for (int n = 1; n<=100; n++){
            numbers.add(n);
        }
        for (int n : numbers){
            UI.println(n);
        }
        while (true){
            int num = UI.askInt("Select a number (0 to quit): ");
            if (num==0){break;}
            for (int i = numbers.size()-1; i>=0; i--){
                if (numbers.get(i)%num==0 && numbers.get(i)!=num){
                    numbers.remove(i);
                }
            }
            int count = 0;
            for (int n : numbers){
                UI.print(n+" ");
                if (++count==10){UI.println(); count=0;}
            }
            UI.println();
        }
        /*# END OF YOUR CODE */

    }
    // END OF DRAFT CODE 

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

    // DRAFT CODE HERE
    // For the demo  (and change button)
    public void showFiles(){
        for (String fn : new String[]{"little-crowd.txt","big-crowd.txt","numbers.txt","a-story.txt",}){
            showFile(fn);
        }
        UI.println("Demo shows lots of the files, scroll to view them all.");
    }

    public void showFile(String fn){
        UI.println("-----------------v-"+fn+"-v---------------");
        try{
            Scanner sc = new Scanner(new File(fn));
            while (sc.hasNextLine()) {
                UI.println(sc.nextLine());
            }
            sc.close();
            UI.println("-----------------^-"+fn+"-^---------------");
            UI.println();
        } catch(IOException e){System.out.printf("Fail: %s\n", e);}
    }
    // END OF DRAFT CODE

    public static void main(String[] args){
        new ArrayListExercise();
    }	

}
