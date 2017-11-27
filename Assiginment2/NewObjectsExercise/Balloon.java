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


/** Describes Balloon objects that can be blown up until they pop.
    Designed for the Balloon game (assignment later in course)
    You can make a new balloon (specify the position)
    expand() will make the balloon a little bigger and then pause briefly.
    pop()    will pop the balloon, turning it grey for a short time, then making it disappear
                   after you have popped
 */
public class Balloon{
    // Fields
    private double radius;
    private double centerX, centerY;
    private Color color;


    // Constructors
    /** Construct a new Balloon object; parameters specify the center of the balloon
	Draws the balloon on the screen, and pauses briefly.
    */
    public Balloon(double x, double y){
	this.centerX = x;
	this.centerY = y;
	this.radius = 10 + 10*Math.random();    // random number between 10 and 19
	this.color =this.randomBrightColor();
	this.draw();
	UI.sleep(500);
    }

    /** Make the balloon larger by a random amount between 10 and 20 units
	It pauses for a short time after expanding it.
        */
    public void expand(){
	if (radius > 0){
	    this.radius = this.radius + 10 + 10*Math.random();
	    this.draw();
	    UI.sleep(500);
	}
    }

    /** Pops the balloon: draws it in gray, pauses, then makes it disappear.
        *  The balloon cannot be expanded or re-popped after the first time it has popped.
        */
    public void pop(){
	if (radius > 0){
	    this.color =Color.lightGray;
	    UI.setColor(this.color);
	    UI.fillOval(centerX-radius, centerY-radius, radius*2, radius*2);
	    UI.sleep(500);
	    UI.eraseOval(centerX-radius, centerY-radius, radius*2, radius*2);
	    this.radius = 0;
	    UI.sleep(500);
	}
    }
    
    // internal methods.
    /** draw the balloon on the screen and pause briefly. */
    private void draw(){
	UI.setColor(this.color);
	UI.fillOval(centerX-radius, centerY-radius, radius*2, radius*2);
	UI.setColor(Color.black);
	UI.drawOval(centerX-radius, centerY-radius, radius*2, radius*2);
    }
    
    /** Construct a bright colour:
	one colour component is 255, another at 0, and the third
	colour component should be anwhere between 0 and 255.
	Method assigns 255, a random value, and 0 to red, green, blue,
	then randomly switches them around.
    */
    private Color randomBrightColor(){
	int red = 255;
	int green=(int)(256*Math.random());
	int blue=0;
	if (Math.random()<0.5){  // maybe switch red and green
	    red=green;
	    green = 1;
	}
	if (Math.random()<0.67){  // maybe switch blue
	    if (Math.random()<0.5){ // maybe switch blue and red
		blue = red;
		red = 0;
	    } else {                         // switch blue and green
		blue = green;
		green = 0;
	    }
	}
	return new Color(red, green, blue);
    }


}
