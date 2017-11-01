// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a ${course} assignment.
// You may not distribute it in any other way without permission.

/* Code for ${course} - 2017T2
 * Name:
 * Username:
 * ID:
 */

import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;

/** ForeachLoopsExercise is a collection of small methods with foreach loops
 */
public class ForeachLoopsExercise{

    /** Constructor: set up user interface */
    public ForeachLoopsExercise(){
           UI.initialise();
           UI.addButton("Clear", UI::clearPanes );
           UI.addButton("squareNumbers", this::doSquareNumbers);
           UI.addButton("addBigNumbers", this::doAddBigNumbers);
           UI.addButton("THWords", this::doTHWords);
           UI.addButton("drawDots", this::doDrawDots);
           UI.addButton("Quit", UI::quit );
    }

    /* Ask the user to enter a sequence of numbers
        * then print out the square of each number.
        *        For example, if they enter 4 21 20 9 done
        *        it should print  16 441 400 81 (either on one line or on separate lines)
        */
    public void doSquareNumbers(){
           /*# YOUR CODE HERE */

    }

    /* Read a sequence of numbers, using UI.askNumbers(),
        * then print the sum of all the numbers bigger than 9.
        *    For example, if they enter 4 21 20 9 12 done
        *    it should print   53
        *    (21+20+12=53)
        */
    public void doAddBigNumbers(){
           /*# YOUR CODE HERE */

    }

    /* Read a sequence of words, and print out all the words containing "th".
        *    For example, if they enter: Mathilde is the happiest person other than Matthew"
        *    it should print "Mathilde the other than Matthew"
        */
    public void doTHWords(){
           /*# YOUR CODE HERE */

    }

    /* Read a sequence of x coordinates then draw dots (10 pixels diameter) at each x coordinate
        * as long as it is between 0 and 300. The y value should be 50.
        */
    public void doDrawDots(){
           UI.clearGraphics();
           double y = 50;
           /*# YOUR CODE HERE */

    }


}
