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

/** Lets the user draw "stars" - lots of lines from a center - using the mouse.
 * The program has two "modes":
 *   setting the center of the star,
 *   setting the points on the star.
 * When the user clicks the mouse:
 *   If the mode is setting the center, it draws a little circle of size 4 at the
 *     position the mouse was released, and stores the position  as the current center
 *   If the mode is setting the points, it draws a line from the
 *    the current center to the position where the mouse was released 
 *  
 * When the user clicks the "Set Center" button, the program changes the mode to setting center
 *  (Note: clicking the button does not draw anything!)
 * When the user clicks the "Set Points" button, the program changes the mode to setting points
 *  (Note: clicking the button does not draw anything!)
 * The user can click the "Clear" button to clear the graphics window
 */
public class StarExercise{

    //three fields to record current state:
    //  position of current center, and
    //  whether the user is currently choosing the center or a point
    /*# YOUR CODE HERE */

    /** Set up the user interface: set mouse listener and buttons.
     *  "Clear" should clearing the graphics window.
     *  "Set Center" and "Set Points" do not draw anything. They only record what mode
     *  the user is now in - choosing a center point or not.
     */
    public StarExercise(){
        /*# YOUR CODE HERE */
        UI.addButton("Quit", UI::quit);
    }

    public void doSetCenter(){
        /*# YOUR CODE HERE */
    }

    public void doSetPoints(){
        /*# YOUR CODE HERE */
    }



    /** Respond to mouse released events.
     * If mode is setting the center, then remember the position and draw a small
     * circle at the point.
     * Othewise, draw a line from the current center to this point
     */
    public void doMouse(String action, double x, double y){
        if (action.equals("released")){
            /*# YOUR CODE HERE */
        }
    }

    public static void main(String[] args){
        new StarExercise();
    }        

}
