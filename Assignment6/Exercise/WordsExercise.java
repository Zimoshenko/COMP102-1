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
import java.awt.Color;
import javax.swing.JColorChooser;

/** Lets the user place colored words on the window using the mouse.
 *  The program has a textfield where the user can enter a word, and the
 *   program will store the word in a field
 *   (Note: it doesn't draw anything yet).
 *  When the user clicks the mouse, the program draws the word in the field
 *   at the position the mouse was released, using UI.drawString(...)
 *  The program has a button to let the user change the color. It uses JColorChooser
 *   and UI.setColor(...)
 */
public class WordsExercise{

    // Fields to remember the current word
    private String word = "---";

    /** Set up the user interface: set mouse listener, textfield and buttons.
     */
    public WordsExercise(){
        UI.setMouseListener( this::doMouse );
        UI.addButton("Clear", UI::clearGraphics);
        UI.addTextField("Set Word", this::doSetWord );
        UI.addButton("Set Color", this::setColor);
        UI.addButton("Quit", UI::quit);
    }

    public void doSetWord(String v){
        /*# YOUR CODE HERE */

    }

    /* Set the UI color to the value chosen by the user */
    public void setColor(){
        /*# YOUR CODE HERE */

    }


    /** Respond to mouse released events.
     * Draw the current word If currently choosing a center, then remember the position and draw a small
    circle at the point.
    Othewise, draw a line from the current center to this point
     */
    public void doMouse(String action, double x, double y){
        /*# YOUR CODE HERE */

    }

    public static void main(String[] args){
        new WordsExercise();
    }        

}
