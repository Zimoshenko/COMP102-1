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
import javax.swing.JColorChooser;

/** TricolourFlagDrawer: draws a series of tricolour flags */
public class TricolourFlagDrawer {

    public static final double width_1 = 150;
    public static final double height_1 = 100;

    /** Constructor: set up user interface */
    public TricolourFlagDrawer() {
        UI.initialise();
        UI.addButton("Clear", UI::clearPanes);
        UI.addButton("Core", this::doCore);
        UI.addButton("Completion", this::doCompletion);
        UI.addButton("Challenge", this::doChallenge);
        UI.addButton("Quit", UI::quit);
    }

    /**
        * asks user for a position and three colours, then calls the 
        * drawThreeColourFlagCore method, passing the appropriate arguments
        *
        * CORE
        */
    public void doCore() {
        double left = UI.askDouble("left of flag");
        double top = UI.askDouble("top of flag");
        UI.println("Now choose the colours");
        Color stripe1 = JColorChooser.showDialog(null, "First Stripe", Color.white);
        Color stripe2 = JColorChooser.showDialog(null, "Second Stripe", Color.white);
        Color stripe3 = JColorChooser.showDialog(null, "Third Stripe", Color.white);
        this.drawThreeColourFlagCore(left, top, stripe1, stripe2, stripe3);
    }

    public void Completion() {//
        this.drawThreeColourFlagCompletion(true, 20, 50, Color.black, Color.yellow, Color.red); // Belgium, vertical
        this.drawThreeColourFlagCompletion(false, 250, 100, Color.black, Color.red, Color.yellow); // Germany
        this.drawThreeColourFlagCompletion(true, 140, 430, Color.blue, Color.white, Color.red); // France
        this.drawThreeColourFlagCompletion(true, 290, 270, Color.red, Color.yellow, Color.green.darker()); // Guinea
        this.drawThreeColourFlagCompletion(false, 470, 30, Color.red, Color.white, Color.blue); // The Netherlands
        this.drawThreeColourFlagCompletion(false, 50, 250, Color.white, Color.blue, Color.red); // Russia        

    }

    /**
        * draws a three colour flag consisting of three vertical equal-width stripes
        * at the given position
        *
        * CORE
        */
    public void drawThreeColourFlagCore(double left, double top, Color stripe1, Color stripe2, Color stripe3) {
        /*# YOUR CODE HERE */
        double width = 100.0;
        double height = 2 * width;
        UI.setColor(stripe1);
        UI.fillRect(left, top, width, height);
        UI.setColor(stripe2);
        UI.fillRect(left + width, top, width, height);
        UI.setColor(stripe3);
        UI.fillRect(left + 2 * width, top, width, height);

    }

    /**
        * draws multiple flag made up of three equal size stripes by calling the
        * drawThreeColourFlagCompletion method, passing the appropriate arguments
        *
        * COMPLETION
        */

    public void doCompletion() {

        this.drawThreeColourFlagCompletion(true, 20, 50, Color.black, Color.yellow, Color.red); // Belgium, vertical
        this.drawThreeColourFlagCompletion(false, 250, 100, Color.black, Color.red, Color.yellow); // Germany
        this.drawThreeColourFlagCompletion(true, 140, 430, Color.blue, Color.white, Color.red); // France
        this.drawThreeColourFlagCompletion(true, 290, 270, Color.red, Color.yellow, Color.green.darker()); // Guinea
        this.drawThreeColourFlagCompletion(false, 470, 30, Color.red, Color.white, Color.blue); // The Netherlands
        this.drawThreeColourFlagCompletion(false, 50, 250, Color.white, Color.blue, Color.red); // Russia

    }

    /**
        * draws a three colour flag consisting of three equal-size stripes
        * at the given position
        * The stripes can be either vertical or horizontal
        *
        * COMPLETION
        */
    public void drawThreeColourFlagCompletion(boolean verticalMode, double left, double top, Color stripe1,
            Color stripe2, Color stripe3) {
        /*# YOUR CODE HERE */
        double width = 50.0;
        double height = 2 * width;
        if (verticalMode) {
            UI.setColor(stripe1);
            UI.fillRect(left, top, width, height);
            UI.setColor(stripe2);
            UI.fillRect(left + width, top, width, height);
            UI.setColor(stripe3);
            UI.fillRect(left + 2 * width, top, width, height);
            UI.setColor(Color.black);
            UI.drawRect(left, top, width * 3, height);
        } else {
            /*double _width = width;
            width = height;
            height = _width; */
            width = 150;
            height = (100 / 3);
            UI.setColor(stripe1);
            UI.fillRect(left, top, width, height);
            UI.setColor(stripe2);
            UI.fillRect(left, top + height, width, height);
            UI.setColor(stripe3);
            UI.fillRect(left, top + 2 * height, width, height);
            UI.setColor(Color.black);
            UI.drawRect(left, top, width, height * 3);
        }

    }

    public void doChallenge() {
        this.drawFlagAndName(true, 0, 0, Color.black, Color.yellow, Color.red, "Belgium");// Belgium
        this.drawFlagAndName(false, 0, 100, Color.black, Color.red, Color.yellow,"Germany"); // Germany
        this.drawFlagAndName(true, 0, 200, Color.blue, Color.white, Color.red,"France"); // France
        this.drawFlagAndName(true, 150, 0, Color.red, Color.yellow, Color.green.darker(),"Guinea"); // Guinea
        this.drawFlagAndName(false, 150, 100, Color.red, Color.white, Color.blue,"Netherlands"); // The Netherlands
        this.drawFlagAndName(false, 150, 200, Color.white, Color.blue, Color.red,"Russia"); // Russia 
        this.drawFlagAndName(false, 300, 200, Color.red, Color.white, Color.red,"Austria");//Flag of Austria
        this.drawFlagAndName(true, 300, 100, Color.red.darker(), Color.white, Color.red.darker(),"Peru");//Peru
        this.drawFlagAndName(true, 300, 0, Color.black, Color.white, Color.red,"Roman");// Roman 
        this.drawGrid();

    }

    public void drawFlagAndName(boolean verticalMode, double left, double top, Color stripe1, Color stripe2,
            Color stripe3, String flagName) {
        this.drawThreeColourFlagCompletion(verticalMode, left, top, stripe1, stripe2, stripe3);
        double x = left + (width_1 / 10) * 3.3;
        double y = top + (height_1 / 10) * 5;
        if (stripe2 == Color.red || stripe2 == Color.red.darker()) {
            UI.setColor(Color.white);

        } else {
            UI.setColor(Color.red.brighter());
        }

        UI.drawString(flagName, x, y);

    }

    public void drawGrid() {

        /*
        -print a 3*3 grid
         height=300, width=450\
         each block width = 150, height = 100
        */
        UI.setColor(Color.black.brighter());
        double left = 0;
        double top = 0;
        double height = 300;
        double width = height * 1.5;
        double _width = (width / 3.0);
        double _height = (height / 3.0);
        while (_width <= width) {
            UI.drawRect(left, top, _width, height);
            _width = _width + (width / 3.0);
        }
        while (_height <= height) {
            UI.drawRect(left, top, width, _height);
            _height = _height + (height / 3.0);

        }

    }


}
