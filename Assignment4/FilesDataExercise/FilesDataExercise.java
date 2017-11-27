// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 - 2017T1
 * Name:
 * Username:
 * ID:
 */

import ecs100.*;
import java.util.Scanner;
import java.io.*;
import java.awt.Color;

/**
 * Exercises for programs that read data from files.
 */

public class FilesDataExercise{

    /** Constructor: set up user interface */
    public FilesDataExercise(){
        UI.addButton("Clear", UI::clearText );
        UI.addButton("print file", this::doPrintFile );
        UI.addButton("sum numbers", this::doSumNumbers );
        UI.addButton("first words", this::doFirstWords );
        UI.addButton("longest word", this::doLongestWord );
        UI.addButton("large courses", this::doLargeCourses );
        UI.addButton("total order", this::doTotalOrder );
        UI.addButton("Quit", UI::quit );
        UI.setDivider(1);
    }        

    /** 
     *  This method lets you read the contents of a file.
     *        It should
     *  - make a Scanner wrapped around a new File
     *  - then read each line of the file and print it to the UI text pane
     */
    public void doPrintFile(){
        String fileName = UIFileChooser.open("Choose a file");
        UI.println("Printing contents of "+ fileName);
        UI.println("--------------------------------------");
        try {
            Scanner scan = new Scanner(new File(fileName));
            while (scan.hasNextLine()){
                String line = scan.nextLine();
                UI.println(line);
            }
        }
        catch(IOException e){UI.println("File reading failed");}
        UI.println("--------------------------------------");
    }

    /**
     * Read numbers from a file called "numbers.txt" which contains only numbers
     * adding them up, and printing the total at the end. (The total should be 2174)
     */
    public void doSumNumbers(){
        /*# YOUR CODE HERE */

    }

    /**
     * Read a file called "text.txt" and print out just the first token (word) on each line.
     */
    public void doFirstWords(){
        /*# YOUR CODE HERE */

    }

    /**
     * Read words from a file called "text.txt" and print out the longest word.
     */
    public void doLongestWord(){
        /*# YOUR CODE HERE */

    }

    /**
     * Read coursecodes and course sizes (number of students) from file called
     * "course-counts.txt" and count how many courses have more than 100 students
     */
    public void doLargeCourses(){
        /*# YOUR CODE HERE */

    }

    /**
     * Read a file called "order.txt", consisting of lines with:
     *  item  count  unit-price,
     *  and then print total cost of order
     */
    public void doTotalOrder(){
        /*# YOUR CODE HERE */

    }


}
