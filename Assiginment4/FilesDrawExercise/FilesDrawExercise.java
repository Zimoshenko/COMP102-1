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

public class FilesDrawExercise{

    public static final double DIAM = 20;  // The diameter of the circles in doDrawCircles.

    /** Constructor: set up user interface */
    public FilesDrawExercise(){
        UI.addButton("Clear", UI::clearPanes );
        UI.addButton("print file", this::printFile );
        UI.addButton("draw circles", this::doDrawCircles );
        UI.addButton("draw names", this::doDrawNames );
        UI.addButton("Quit", UI::quit );
    }        

    /**
     *  This method lets you read the contents of a file.
     *        It should
     *  - make a Scanner wrapped around a new File
     *  - then read each line of the file and print it to the UI text pane
     *  The first line of the file has the number of lines in the file
     */
    public void printFile(){
        String fileName = UIFileChooser.open("Choose a file");
        UI.println("Printing contents of "+ fileName);
        UI.println("--------------------------------------");
        try {
            Scanner scan = new Scanner(new File(fileName));
            int numLines = scan.nextInt();
            UI.println("First line is: "+ numLines );

            int count = 0;
            while (count < numLines){
                String line = scan.nextLine();
                UI.println(line);
            }
        }
        catch(IOException e){UI.println("File reading failed");}
        UI.println("--------------------------------------");
    }

    /**
     * Reads a file called "circle-positions.txt"
     * The first line of the file has the number of circles to draw
     * Each later line contains two numbers - the x and y positions of a circle
     * The method should read the first number, and then
     *  have a while loop that will draw that many circles
     * Each time round the loop, it will read two numbers and
     *   draw a circle of radius 20 at that position.
     * eg, if a line of the file has 120 350 on it, then
     *  it draws a circle centered at (120, 350).
     * You can make them all the same colour or random colours
     */
    public void doDrawCircles(){
        /*# YOUR CODE HERE */

    }

    /**
     * Read a file called "names.txt" containing  of names and positions,
     * and draw them on the graphics pane.
     * The first line of the file has the number of names in the file
     * Each remaining line of the file has two numbers (x and y) and a name,
     * followed by three integers specifying the color to draw the name.
     * For each line, it sets the color, then draws the name at the position.
     * If the three colour integers are in r, g, and b, then you can set the colour
     * using  UI.setColor(new Color(r, g, b)));
     */
    public void doDrawNames(){
        /*# YOUR CODE HERE */

    }


}
