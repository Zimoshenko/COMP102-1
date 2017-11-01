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

public class ConditionalsExercise{

    /** Constructor: set up the user interface (already written for you) */ 
    public ConditionalsExercise(){
           UI.initialise();
           UI.addButton("Clear", UI::clearPanes );
           UI.addButton("validHour", this::doValidHour);
           UI.addButton("wordGame", this::doWordGame);
           UI.addButton("drawAShape", this::doDrawAShape);
           UI.addButton("longestWord", this::doLongestWord);
           UI.addButton("Quit", UI::quit );
    }

    /** Ask user for an integer
        * if the number is a valid hour (0 to 23), then it prints the number in
        * the form  "The time is 6:00" (if they entered 6
        * otherwise it prints  "That number is not a valid time"
        */
    public void doValidHour(){
           /*# YOUR CODE HERE */
           int time = UI.askInt("Input a integer:");
           if (time<24 && time>0) {
           	UI.printf("The time is %d:00/n",time);
           	
           }
           else {
           	UI.printf("STUPID ASS!/n That number is not a valid time");
           	
           }

    }

    /** Asks the user to enter a word.
        * Says "Yes, that fits" if the word starts with "p" and is 7 characters long,
        * and "Sorry, that word won't work" otherwise.
        */
    public void doWordGame(){
    	String word = UI.askString("Enter a f***ing word:");
    	if (word.startsWith("p") && (word.length()==7)) {
    	UI.println("Yes, that fits");


    		
    	}else{
    	UI.println("Sorry, that word won't work");

           /*# YOUR CODE HERE */
    	}

    }

    /**
        * Asks the user to enter the name of a shape ("flower", "no" or "arrow"),
        * and then draws the appropriate shape by calling this.drawFlower(),
        * this.drawNo(), or this.drawArrow().
        * If the name of the shape is not one of "flower", "no", or "arrow",
        * the program prints "sorry, I don't know that shape".
        */
    public void doDrawAShape(){
           String shape = UI.askString("Which shape");
           if (shape.equals("flower")) {
           	this.drawFlower();
           	
           }else if (shape.equals("no")) {
           	this.drawNo();
           	
           }else if (shape.equals("arrow")) {
           	this.drawArrow();
           	
           }


           /*# YOUR CODE HERE */

    }

    /** Asks the user to enter three words and prints out the longest one.
        * (if two words are equally long, it doesn't matter which it prints).
        * You can call the length() method on a string to find out how long it is.
        * Note that there are three possible cases to check for.
        */
    public void doLongestWord(){
    	String word1 = UI.askString("Enter your f* 1st word");
        String word2 = UI.askString("Enter your f* 2nd word");
        String word3 = UI.askString("Enter your f* 3rd word");
        

           /*# YOUR CODE HERE */

    }

    /** ---------- The code below is already written for you ---------- **/
    // The flag methods called by doDrawAFlag.

    /** Draws a flower */
    public void drawFlower(){
           double x = 250;  //center of the flower
           double y = 200;
           double radius =50;
           double offset = 30;
           UI.setColor(Color.red);
           UI.fillOval(x-offset-radius, y-radius, radius*2.0, radius*2);
           UI.fillOval(x+offset-radius, y-radius, radius*2.0, radius*2);
           UI.fillOval(x-radius, y-offset-radius, radius*2.0, radius*2);
           UI.fillOval(x-radius, y+offset-radius, radius*2.0, radius*2);
           UI.setColor(Color.black);
           UI.fillOval(x-offset, y-offset, offset*2.0, offset*2);
    }

    /** Draws a "No" shape */
    public void drawNo(){
           double x = 200;  // center
           double y = 100;
           double diam = 100;
           double offset = diam/2*Math.cos(Math.PI/4);
           UI.clearGraphics();
           UI.setColor(Color.red);
           UI.setLineWidth(10);
           UI.drawOval(x-diam/2, y-diam/2, diam, diam);
           UI.drawLine(x-offset, y-offset, x+offset, y+offset);;
           UI.setLineWidth(1);
    }

    /** Draws an arrow */
    public void drawArrow(){
           double x = 100;  //start of arrow
           double y = 100; 
           double length = 200;
           double offset = 30;
           UI.clearGraphics();
           UI.setColor(Color.green);
           UI.setLineWidth(20);
           UI.drawLine(x, y, x+ length, y);
           UI.drawLine(x, y, x+offset, y-offset);
           UI.drawLine(x, y, x+offset, y+offset);
           UI.setLineWidth(1);
    }


}
