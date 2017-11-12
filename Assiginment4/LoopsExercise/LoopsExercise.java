// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 - 2017T1
 * Name:
 * Username:
 * ID:
 */

import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;

/** LoopsExercise is a collection of small methods with while loops
 */
public class LoopsExercise{

    /** Constructor: set up user interface */
    public LoopsExercise(){
        UI.initialise();
        UI.addButton("Clear", UI::clearPanes );
        UI.addButton("sumOneToN", this::doSumOneToN );
        UI.addButton("countWordsInSentence", this::doCountWordsInSentence );
        UI.addButton("drawBubbles", this::doDrawBubbles );
        UI.addButton("Quit", UI::quit );
    }

    /* Add up all the integers from 1 to n (using a loop) and prints the sum.
     *    For example, if the argument is 10, it should add up
     *    1+2+3+4+5+6+7+8+9+10 and print out the sum: 55
     */
    public void doSumOneToN() {
        int num = UI.askInt("Max for sumOneToN(int max)");
        this.sumOneToN(num);
    }

    public void sumOneToN(int max){
        /*# YOUR CODE HERE */

    }

    /* Ask the user for words until they enter a word that ends with a full stop.
     * Read all the tokens (words) and print out the number of words in the
     *      sentence.
     * eg, if they enter
     * I am happy today.
     * it should print out
     * Sentence has 4 words
     * You should use a "while(true)" loop with a break, and the UI.askToken() method
     */
    public void doCountWordsInSentence(){
        /*# YOUR CODE HERE */

    }

    /* Asks user for an integer, then draws that many blue bubbles
     * in a vertical line.
     */
    public void doDrawBubbles(){
        int n = UI.askInt("Number of Bubbles: ");
        this.drawBubbles(n);
    }

    public void drawBubbles(int n){
        /*# YOUR CODE HERE */

    }


}
