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


/** Describes Car objects that can be moved and turned to left or right.
    Designed for a simulation of roads and traffic lights.
    You can make a new car (specify the (x,y) position, and its colour)
    drive(double dist) makes it move it forward by some distance,
    left() and right() make it turn it left or right.
 */

public class Car{
    // Fields
    private double x, y;
    private int direction;    // 0 is to the East, 1 to the South, 2 to West, 3 to North
    private Color color;
    private double width = 15;
    private double length = 35;
    private double offset = 4;  // offset of the roof from the center


    // Constructors
    /** Construct a new Car object; parameters are the position and colour of the car.
    */
    public Car(double x, double y, Color col){
	this.x = x;
	this.y = y;
	this.color = col;
	this.direction = 0;
	this.draw();
    }

    /** Make the car move a distance in its current direction*/
    public void drive(double dist){
	this.erase();
	if (this.direction == 0){
	    this.x = this.x + dist;
	}
	else if (this.direction == 1){
	    this.y = this.y + dist;
	}
	else if (this.direction == 2){
	    this.x = this.x - dist;
	}
	else if (this.direction == 3){
	    this.y = this.y - dist;
	}
	this.draw();
    }

    /** turn the car 90 degrees to the left */
    public void left(){
	this.erase();
	this.direction = (this.direction + 3) % 4;
	this.draw();
    }
    
    /** turn the car 90 degrees to the right */
    public void right(){
	this.erase();
	this.direction = (this.direction + 1) % 4;
	this.draw();
    }
    
    // internal methods.
    /** draw the car: a rectangle with a darker rectangle for the roof, slightly offset
	towards the back of the car*/
    private void draw(){
	// draw the body of the car
	UI.setColor(this.color);
	if (this.direction % 2 == 0){   // direction is 0 or 2, ie left or right
	    UI.fillRect(this.x-this.length/2, this.y-this.width/2, this.length, this.width);
	}
	else {// direction up or down
	    UI.fillRect(this.x-this.width/2, this.y-this.length/2, this.width, this.length);
	}
	// draw the roof of the car
	UI.setColor(this.color.darker());
	double w = this.width/2;
	if (this.direction == 0){
	    UI.fillRect(this.x-w-this.offset, this.y-w, this.width, this.width);
	}
	else if (this.direction == 1){
	    UI.fillRect(this.x-w, this.y-w-this.offset, this.width, this.width);
	}
	else if (this.direction == 2){
	    UI.fillRect(this.x-w+this.offset, this.y-w, this.width, this.width);
	}
	else if (this.direction == 3){
	    UI.fillRect(this.x-w, this.y-w+this.offset, this.width, this.width);
	}
	UI.sleep(100);
    }

    /** erase the car */
    private void erase(){
	if (this.direction % 2 == 0){   // direction is 0 or 2, ie left or right
	    UI.eraseRect(this.x-this.length/2, this.y-this.width/2, this.length, this.width);
	}
	else {// direction up or down
	    UI.eraseRect(this.x-this.width/2, this.y-this.length/2, this.width, this.length);
	}

    }

}
