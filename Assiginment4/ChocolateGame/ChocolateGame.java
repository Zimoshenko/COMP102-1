// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 - 2017T1
 * Name:
 * Username:
 * ID:
 */

import ecs100.*;
import java.awt.Color;
import java.util.*;
import java.io.*;

/** ChocolateGame   */
public class ChocolateGame{
    public static final int NUM_ROUNDS = 5;      // Maximum number of rounds in the game
    public static final double CHOC_SIZE = 10;  // Size of the chocolates: needed for completion only

    /**
     * Construct a new ChocolateGame object
     */
    public ChocolateGame(){
        UI.initialise();
        UI.addButton("Play Game (core)", this::doPlayGameCore);
        UI.addButton("Play Game (compl)", this::doPlayGameCompletion);
        UI.addButton("Quit", UI::quit);
        UI.setDivider(0.8);
    }

    /** Plays a guessing game with NUM_ROUNDS rounds.
    Each round, the computer chooses a number of chocolates between 1 and 10
    but doesn't show them to the user.
    The user then has to guess if the number of chocolates is odd or even.
    If the user guesses right, then the player gets to keep the chocolates.
    After NUM_ROUNDS rounds, the game is over, and the player can eat all the chocolates
    they have won.

    The method has to keep track of how many rounds have been played, and
    how many chocolates the player has accumulated.
    Hints:
    use the randomInteger method to select a nubmer between 1 and 10;
    use (number%2 == 0) to determine whether number is even.
     */
    public void doPlayGameCore(){
        UI.clearText();
        /*# YOUR CODE HERE */

    }


    /** Plays a more complicated guessing game with up to NUM_ROUNDS rounds.
    The player starts off with a pile of 10 chocolates.
    Each round, the computer chooses a number of chocolates between 1 and 10
    but doesn't show them to the user.
    The user then has to guess if the number of chocolates is odd or even.
    If the user guesses right, then the player gets the chocolates added to their pile.
    If the user guesses wrong, then the player has to give that many chocolates back to the computer.
    The program should display the pile of chocolates in the graphics pane.
    If the player runs out of chocolates, then the player loses and the game stops.
    After NUM_ROUNDS rounds, the game is over, and the player can eat any chocolates they have left 

     */
    public void doPlayGameCompletion(){
        UI.clearText();
        UI.clearGraphics();
        UI.println("Let's play the chocolate game");
        UI.println("You get to start with 10 chocolates");
        /*# YOUR CODE HERE */
        
    }

    /** Draws the specified number of chocolates in the graphics pane */
    public void displayChocolates(int chocolates) {
        UI.clearGraphics();
        /*# YOUR CODE HERE */

    }

    /** Returns a random integer between 1 and max inclusive */ 
    public int randomInteger(int max) {
        return ( (int)(Math.random()*max + 1) );
    }

}
