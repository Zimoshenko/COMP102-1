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

    public static final double width = 200;
    public static final double height = 133;

    /** Constructor: set up user interface */
    public TricolourFlagDrawer() {
        UI.initialise();
        UI.addButton("Clear", UI::clearPanes);
        UI.addButton("Core", this::doCore);
        UI.addButton("Completion", this::doCompletion);
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
    public void drawThreeColourFlagCompletion(boolean verticalMode, double left, double top, Color stripe1, Color stripe2, Color stripe3) {
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
        }else{
            /*double _width = width;
            width = height;
            height = _width; */
            width = 150;
            height = 33.3;
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

}
