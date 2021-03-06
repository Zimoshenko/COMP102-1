// This program is copyright VUW.
// You are granted permission to use it to construct your assignment answer,
// You may not distribute it in any other way without permission.
//
/* Code for COMP 102
 * Name:
 * ID:
 */

import ecs100.*;

import java.awt.Color;

public class CircuitDrawer {

    // fields to store data:
    //  - the tool that the user has selected (which control what component will be
    //    drawn by the mouse)
    //    The tools are "resistor", "wire", "capacitor", "source", "label", or "eraser"
    //  - the mode: whether the component should be horizontal or vertical
    //  - the contents of the label
    //  - the position the mouse was pressed,
    /*# YOUR CODE HERE */
    private double x, y;
    private String operation;
    private boolean horizontalMode = true;

    //Constructor

    /**
     * Sets up the user interface - mouselistener, buttons, and (completion only) textField
     */
    public CircuitDrawer() {
        UI.setMouseListener(this::doMouse);
        UI.addButton("Clear", UI::clearGraphics);
        /*# YOUR CODE HERE */

        UI.addButton("Quit", UI::quit);

        UI.setDivider(0.0);  // Hide the text area.
    }

    // Methods to change the tool that controls will be drawn next
    // These methods just save information to the fields.
    /* Respond to the resistor button */
    public void doSetResistor() {
        /*# YOUR CODE HERE */
        this.operation = "Resistor";


    }

    /* Respond to the wire button */
    public void doSetWire() {
        /*# YOUR CODE HERE */
        this.operation = "Wire";

    }

    /* Respond to the capacitor button */
    public void doSetCapacitor() {
        /*# YOUR CODE HERE */
        this.operation = "Capacitor";


    }

    /* Respond to the source button */
    public void doSetSource() {
        /*# YOUR CODE HERE */
        this.operation = "Source";

    }

    /* Respond to the eraser button */
    public void doSetEraser() {
        /*# YOUR CODE HERE */
        this.operation = "Eraser";

    }

    /**
     * Respond to the text field (completion only)
     */
    public void doSetLabel(String v) {
        /*# YOUR CODE HERE */
        this.operation = "Label";
    }

    /**
     * Respond to the horiz/vert button (completion only)
     * Switches the mode from horizontal to vertical, or back
     * Ideally, (Challenge) it should show the user what the current state is,
     * eg by drawing a horizonal/vertical bar in the top left corner,
     * or by calling setText on the button to change the label
     */
    public void doSwitchDirection() {
        /*# YOUR CODE HERE */
        if (this.horizontalMode = true) {
            this.horizontalMode = false;
        } else {
            this.horizontalMode = true;
        }

    }


    /**
     * Respond to mouse events
     * When pressed, remember the position.
     * When released, draw what is specified by current tool
     * Uses the value stored in the field to determine which kind of component to draw (or to erase)
     * It should call the drawWire, drawResistor, drawCapacitor, drawSource, drawLabel,
     * or doErase, methods passing the x and y where the mouse was released.
     */
    public void doMouse(String action, double x, double y) {
        /*# YOUR CODE HERE */
        if (action.equals("released")) {
            this.x = x;
            this.y = y;
        }
        if (this.operation.equals("Resistor")) {
            this.drawResistor(x, y);
        } else if (this.operation.equals("Wire")) {
            this.drawWire(x, y);

        } else if (this.operation.equals("Capacitor")) {
            this.drawCapacitor(x, y);

        } else if (this.operation.equals("Source")) {
            this.drawSource(x, y);
        } else if (this.operation.equals("Eraser")) {
            this.doErase(x, y);
        } else if (this.operation.equals("Label")) {
            this.drawLabel(x, y);

        }


    }


    /**
     * Draw a resistor centered at the point x, y.
     * HINT: Draw a line, then fill a white rectangle, then draw a black rectangle
     * Core: only horizontal required
     * Completion: horizontal or vertical depending on the mode.
     */
    public void drawResistor(double x, double y) {
        double length = 31;    // size in the longer  dimension
        double width = 11;     // size in the shorter dimension 
        double stub = 10;      // the length of the wires on each end
        /*# YOUR CODE HERE */


        //TODO:Draw Resistor
        if (horizontalMode) {//TODO:Horiz/Vert mode

        } else {

        }

    }

    /**
     * Draw a wire from the point where the user pressed the mouse to the point x,y.
     * Core: may be a straight line.
     * Completion: The wire should have a horizontal part followed by a vertical part
     * If the distance between the two points is very small, it just puts a circle at (x y)
     */
    public void drawWire(double x, double y) {
        /*# YOUR CODE HERE */
        //TODO:Draw Wire

    }


    /**
     * Draw a capacitor centered at the point x, y.
     * (Two parallel lines with wires on each side)
     * HINT: draw a line for the wires, then draw a black rectangle, then
     * fill a white rectangle that is narrower but longer.
     * Core: only horizontal required
     * Completion: horizontal or a vertical, depending on the mode.
     */
    public void drawCapacitor(double x, double y) {
        /*# YOUR CODE HERE */
        //TODO:Draw Capacitor


        if (horizontalMode) {

        } else {

        }

    }

    /**
     * Draw a source centered at the point x, y.
     * (Circle with wires on each side)
     * Core: only horizontal required
     * Completion: horizontal or vertical, depending on the mode.
     */
    public void drawSource(double x, double y) {
        /*# YOUR CODE HERE */
        //TODO:Draw Source

        if (horizontalMode) {

        } else {

        }

    }


    /**
     * Erase a circular region around the position x, y
     * Should be big enough to erase a single component.
     */
    public void doErase(double x, double y) {
        /*# YOUR CODE HERE */
        //TODO:Eraser
    }


    /**
     * Draw a label at position x, y.  Always horizontal.
     * Uses the label that was stored in a field.
     * Completion only.
     */
    public void drawLabel(double x, double y) {
        /*# YOUR CODE HERE */
        //TODO:Draw Label

        if (horizontalMode) {

        } else {

        }

    }


    // Main:  constructs a new CircuitDrawer object
    public static void main(String[] arguments) {
        new CircuitDrawer();
    }

}
