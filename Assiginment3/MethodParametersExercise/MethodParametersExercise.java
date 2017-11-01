// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a ${course} assignment.
// You may not distribute it in any other way without permission.

/* Code for ${course} - 2017T2
 * Name:
 * Username:
 * ID:
 */


import ecs100.*;
import java.awt.Color;

/** The MethodParametersExercise class has several methods
 *  that each perform some repetitive task.
 *  The repetitive component is done by calling a separate
 *   method several times (with different arguments each time).

 *  - doNameTags() prints out a series of nametags for workshop participants,
 *    by calling printNameTag(....) several times.
 *    Each nametag has the participant's name and workshop ID number.

 *  - bottleSong() prints out the words to a traditional repetitive song,
 *    by calling bottleSongVerse(....) method nine times.

 *  - signalZeroFlag() draws the flag used by the US navy to signal
 *    the value "zero", which is a white square with five small
 *    blue crosses, laid out like the dots on the "5" side of ordinary dice.
 *    It calls the drawCross method five times. 
 */

public class MethodParametersExercise {

    /** Constructor: set up the user interface (already written for you) */ 
    public MethodParametersExercise(){
           UI.initialise();
           UI.addButton("Clear", UI::clearPanes );
           UI.addButton("NameTags", this::doNameTags );
           UI.addButton("BottleSong", this::doBottleSong );
           UI.addButton("SignalFlag", this::doSignalZeroFlag );
           UI.addButton("Quit", UI::quit );
    }

    /** Prints out a series of nametags for workshop participants.
        *  Each nametag has the participant's name and workshop ID number.
        */
    public void doNameTags(){
           this.printNameTag("John Smith", 325);
           this.printNameTag("Jason Strickland",218);
           this.printNameTag("Jane Salisor", 15);
           this.printNameTag("Jie Song", 123);
           this.printNameTag("Julia Sargeant", 248);
           UI.println();
    }

    /** Prints a nametag (as in Lab Exercise 0)
        *  A nametag has the participant's name and workshop ID number.
        */
    public void printNameTag(String name, int number ){
           /*# YOUR CODE HERE */
           UI.println("=========================");//width should be 25
           UI.println("|Name:                  |");
           String firstLine = ("|"+ name);
           while ((firstLine.length()<24)) {
            firstLine = (firstLine+ " ");
          }if (firstLine.length()<25) {
            
          }
           



    }

    public void doBottleSong(){
           this.bottleSongVerse(10); // prints verse with 10 bottles...
           this.bottleSongVerse(9);
           this.bottleSongVerse(8);
           this.bottleSongVerse(7);
           this.bottleSongVerse(6);
           this.bottleSongVerse(5);
           this.bottleSongVerse(4);
           this.bottleSongVerse(3);
           this.bottleSongVerse(2);
           UI.println();
           UI.println(); 
    }

    /** bottleSongVerse
        * The verses uses the number of bottles remaining
        */
    public void bottleSongVerse(/*# YOUR CODE HERE */ ){
           /*# YOUR CODE HERE */

    }

    /** Draws the flag used by the US navy to signal the value "zero":
        *    a white square with five little blue crosses on it (laid out like the
        *    dots on the "5" side of ordinary dice).
        *    See http://www.navy.mil/navydata/communications/flags/num0.gif
        */
    public void doSignalZeroFlag(){
           //variables
           double flagSize = UI.askDouble("Size of flag:");
           double flagLeft = 200;
           double flagTop = 100;
           double centerX = flagLeft+flagSize/2.0;
           double centerY = flagTop+flagSize/2.0;
           double offset = 0.3*flagSize;
           double crossSize = 0.16*flagSize;
           double crossThick = 0.05*flagSize;

           //flag background
           UI.setColor(Color.white);
           UI.fillRect(flagLeft, flagTop, flagSize, flagSize);
           UI.setColor(Color.black);
           UI.drawRect(flagLeft, flagTop, flagSize, flagSize);

           //draw crosses
           this.drawCross(centerX, centerY, crossSize, crossThick);                         //first cross
           this.drawCross(centerX-offset, centerY-offset, crossSize, crossThick);  //top left cross
           this.drawCross(centerX+offset, centerY-offset, crossSize, crossThick);  //top right cross
           this.drawCross(centerX-offset, centerY+offset, crossSize, crossThick);  //bottom left cross
           this.drawCross(centerX+offset, centerY+offset, crossSize, crossThick);  //bottom right cross
    }

    /** drawCross is passed the position of the centre of the cross and its dimensions */
    public void drawCross(/*# YOUR CODE HERE */ ){
           /*# YOUR CODE HERE */

    }


}
