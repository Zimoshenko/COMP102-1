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
import java.util.*;

/**
 * Runs a simulation of two gliders.
 * Creates two new Glider objects,
 * Repeatedly makes the gliders move.
 * If a glider hits the ceiling, it changes the glider speed to be slow
 * If a glider reaches the right wall, it makes a new glider in its place.
 */

public class GliderSimulation {

    public static final int RIGHT_WALL = 600; // the right edge where the gliders disappear
    public static final int CEILING = 350;    // the ceiling where the gliders should slow down
    public static final double FLOOR = 400;   // position of the floor
    public static final double MAX_HEIGHT = CEILING - 12;   // maximum height of the gliders
    private double obstacleX = randomGen(0.8 * CEILING), obstacleY = randomGen(0.8 * RIGHT_WALL),//to save time, put only one obstacle at this time
            obstacleHeight = randomGen(0.1 * RIGHT_WALL), obstacleWidth = randomGen(0.1 * CEILING);
    private int score = 0;

    public GliderSimulation() {
        UI.addButton("Start", this::throwGliders);
        UI.addSlider("Delay", 10, 80, 40, this::setDelay);
        UI.addButton("Challenge", this::doChallenge);
        UI.addButton("Quit", UI::quit);
        UI.setDivider(0.0); // hide the text area
        this.drawRoom();    // draw the room.
    }

    private int delay = 40;
    private double obstacleXList[], obstacleYList[];

    public void throwGliders() {
        UI.setImmediateRepaint(false);  // makes animation smoother, but needs repaintGraphics().

        while (true) {
            Glider gliderA = this.makeNewGlider();
            Glider gliderB = this.makeNewGlider();
            gliderA.draw();
            gliderB.draw();

            //loop for as long as at least one glider is flying.
            while (gliderA.getHeight() > 0 || gliderB.getHeight() > 0) {
                // make each glider move
                gliderA.move();
                gliderB.move();

                // redraw the gliders
                this.clearRoom();
                gliderA.draw();
                gliderB.draw();
                this.drawRoom();
                UI.repaintGraphics();

                UI.sleep(delay);
                // change the speed if the glider gets too high
                if (gliderA.getHeight() >= MAX_HEIGHT) {
                    gliderA.setSpeed(Math.random() * 4);
                }
                if (gliderB.getHeight() >= MAX_HEIGHT) {
                    gliderB.setSpeed(Math.random() * 4);
                }
                // Make the gliders disappear if past right edge
                if (gliderA.getX() >= RIGHT_WALL) {
                    gliderA = this.makeNewGlider();
                }
                if (gliderB.getX() >= RIGHT_WALL) {
                    gliderB = this.makeNewGlider();
                }
            }
            UI.sleep(1000);  //both gliders on floor. Wait 1 second before restarting.

        }
    }

    /**
     * Helper method that makes a new Glider with random initial values
     */
    public Glider makeNewGlider() {
        double initHeight = 50 + Math.random() * (CEILING - 100); // random height
        double xSpeed = Math.random() * 12;          // random step size between 1 and 12.
        return new Glider(initHeight, xSpeed);
    }

    public void clearRoom() {
        UI.eraseRect(0, FLOOR - CEILING - 1, RIGHT_WALL - 1, CEILING - 2);
    }

    public double randomGen(double max) {
        return Math.random() * max;
    }

    public void placeObstacle() {
        UI.setColor(Color.blue);
//        UI.println("1");
        UI.fillRect(this.obstacleX, this.obstacleY, this.obstacleWidth, this.obstacleHeight);
//need to put out obstacle's position
    }


    public void drawRoom() {
        UI.setColor(Color.black);
        UI.fillRect(0, FLOOR, RIGHT_WALL + 50, 20);    // the ground
        UI.setColor(Color.lightGray);
        UI.fillRect(RIGHT_WALL, FLOOR - CEILING, 50, CEILING);    // the wall
        UI.setColor(Color.lightGray);
        UI.fillRect(0, FLOOR - CEILING - 12, RIGHT_WALL + 50, 12); // the ceiling
        this.placeObstacle();
    }

    public void doChallenge() {
        UI.setImmediateRepaint(false);  // makes animation smoother, but needs repaintGraphics().


        while (true) {
            Glider gliderA = this.makeNewGlider();
            Glider gliderB = this.makeNewGlider();
            gliderA.draw();
            gliderB.draw();
            Boolean countedA = false;
            Boolean countedB = false;


            //loop for as long as at least one glider is flying.
            while (gliderA.getHeight() > 0 || gliderB.getHeight() > 0) {

                // make each glider move
                gliderA.move();
                gliderB.move();


                // redraw the gliders
                this.clearRoom();
                gliderA.draw();
                gliderB.draw();

                this.drawRoom();
                UI.repaintGraphics();

                UI.sleep(delay);
                // change the speed if the glider gets too high
                if (gliderA.getHeight() >= MAX_HEIGHT) {

                    gliderA.setSpeed(Math.random() * 4);
                }
                if (gliderB.getHeight() >= MAX_HEIGHT) {
                    gliderB.setSpeed(Math.random() * 4);
                }
                // Make the gliders disappear if past right edge
                if (gliderA.getX() >= RIGHT_WALL) {
                    gliderA = this.makeNewGlider();
                    score = score + 5;
                    UI.println("Yeah! You made it! Score +5.");
                    UI.println("Total score:" + score);
                }
                if (gliderB.getX() >= RIGHT_WALL) {
                    gliderB = this.makeNewGlider();
                    score = score + 5;
                    UI.println("Yeah! You made it! Score +5.");
                    UI.println("Total score:" + score);

                }

                while (gliderA.getHeight() <= 15) {
                    if (countedA) {
                        break;
                    }
                    score = score - 2;
                    UI.println("Oops! Score -2.");
                    UI.println("Total score:" + score);
                    countedA = true;
                }
                while (gliderB.getHeight() <= 15) {
                    if (countedB) {
                        break;
                    }
                    score = score - 2;
                    UI.println("Oops! Score -2.");
                    UI.println("Total score:" + score);
                    countedB = true;
                }


            }
            UI.sleep(1000);  //both gliders on floor. Wait 1 second before restarting.


        }
    }

    public void setDelay(double v) {
        this.delay = (int) v;
    }

    // Main

    /**
     * Create a new Simulation object
     */
    public static void main(String[] arguments) {
        new GliderSimulation();
    }

}
