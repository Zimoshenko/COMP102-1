// This program is copyright VUW.
// You are granted permission to use it to construct your assignment answer,
// You may not distribute it in any other way without permission.
//
/* Exercise for COMP102
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;
import java.awt.Color;

/** The CirclesExercise program is a simple program that lets the user place small 
 *  and large circles on the graphics pane using the mouse
 *  It needs a field to remember the size for new circles .
 *  It should have three buttons: Small, Large, and Clear.
 *   The "Small" button should change the size to 10, 
 *   The "Large" button should change the size to 30. 
 *   The "Clear" button should clear the graphics window.
 *  When the user releases the mouse at any point on the graphics pane, the program
 *  should draw a blue circle at that point. The size of the circle should be the remembered size.
*/

public class CirclesExercise{
    //field to record the size for new circles (10 or 30)
    //initial size should be 10
    /*# YOUR CODE HERE */

    // Constructor
    /** Construct a new CirclesExercise object  and set up the GUI:
     *  - set the mouse listener
     *  - add three buttons
     */
    public CirclesExercise(){
        /*# YOUR CODE HERE */

        UI.addButton("Quit", UI::quit );
    }

    /** Respond to the Large button */
    public void doLarge(){
        /*# YOUR CODE HERE */

    }

    /** Respond to the Small button */
    public void doSmall(){
        /*# YOUR CODE HERE */

    }

    /** Respond to mouse events.
     *  This program only does something when the action is "released":
     *  It should draw a blue circle of the current size centered at
     *   the position the mouse was released (x, y)
     */
    public void doMouse(String action, double x, double y) {
        if (action.equals("released")){
            /*# YOUR CODE HERE */

        }
    }

    // Main: calls the constructor, which will set up the interface
    public static void main(String[] arguments){
        new CirclesExercise();
        UI.println("Click the mouse in the graphics pane");
    }        

}
