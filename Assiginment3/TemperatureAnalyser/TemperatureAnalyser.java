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

/** The program contains several methods for analysing the readings of the temperature levels over the course of a day.
 *  There are several things about the temperature levels that a user may be interested in: 
 *    The average temperature level.
 *    How the temperatures rose and fell over the day.
 *    The maximum and the minimum temperature levels during the day.
 */
public class TemperatureAnalyser {

    /** Constructor: set up user interface */
    public TemperatureAnalyser() {
        UI.initialise();
        UI.addButton("Analyse", this::doAnalyse);
        UI.addButton("Quit", UI::quit);
    }

    /* doAnalyse reads a sequence of temperature levels from the user and prints out
        *    average, maximum, and minimum level and plots all the levels
        *    by calling appropriate methods
        */
    public void doAnalyse() {
        UI.clearPanes();
        ArrayList<Double> listOfNumbers = UI.askNumbers("Enter levels, end with 'done': ");
        // ArrayList<Double> listOfNumbers = {1,1,4,5,1,4,1,9,1,9};
        if (listOfNumbers.size() > 0) {
            this.printAverage(listOfNumbers);
            this.plotLevels(listOfNumbers);

            double max = this.maximumOfList(listOfNumbers);
            double min = this.minimumOfList(listOfNumbers);

            UI.println("Maximum level was: " + max);
            UI.println("Minimum level was: " + min);
        } else {
            UI.println("No readings");
        }
    }

    /** Print the average level
        *   - There is guaranteed to be at least one level,
        *   - The method will need a variable to keep track of the sum, which 
        *        needs to be initialised to an appropriate value.
        *  CORE
        */
    public void printAverage(ArrayList<Double> listOfNumbers) {
        //UI.println("method printAverage() is not implemented yet");  // remove when you have implemented your method
        /*# YOUR CODE HERE */
        double total = 0;
        //    double averageTemp = 0;
        for (double temp : listOfNumbers) {
            total = total + temp;
            //UI.println(total);               
        }
        double averageTemp = total / listOfNumbers.size();
        UI.println("Average temperature = " + averageTemp);

    }

    /**
        * Plot a bar graph of the sequence of levels,
        * using narrow rectangles whose heights are equal to the level.
        * [Core]
        *   √ Plot the bars.
        * [Completion]
        *   √ Draws a horizontal line for the x-axis (or baseline) without any labels.
        *   - Any level greater than 400 should be plotted as if it were just 400, putting an
        *            asterisk ("*") above it to show that it has been cut off.
        * [Challenge:] 
        *   - The graph should also have labels on the axes, roughly every 50 pixels.
        *   √ The graph should also draw negative temperature levels correctly.
        *   - Scale the y-axis and the bars so that the largest numbers and the smallest just fit on the graph.
        *        The numbers on the y axis should reflect the scaling.
        *   - Scale the x-axis so that all the bars fit in the window.
        */
    public void plotLevels(ArrayList<Double> listOfNumbers) {
        //UI.println("method plotLevels() is not implemented yet");  // remove when you have implemented your method
        double base = 420; //base of the graph
        double left = 50; //left of the graph
        double step = 40; //distance between plotted points
        double gap = 0;
        double thickness = 30;
        double ratio = 1;

        /* draw x-axis */
        UI.setColor(Color.pink);
        UI.drawLine(left, base, 9999, base);

        /* draw bars+ */
        for (double temp : listOfNumbers) {
            if (temp >= 0) {
                if (temp > 400) {
                    UI.setColor(Color.black);
                    UI.fillRect(left + gap, base - (temp * ratio), thickness, temp * ratio);
                    UI.setColor(Color.red);
                    UI.drawString(String.valueOf(temp), left + gap, base - (temp * ratio));

                } else {
                    UI.setColor(Color.black);
                    UI.fillRect(left + gap, base - (temp * ratio), thickness, temp * ratio);
                    UI.setColor(Color.red);
                    UI.drawString(String.valueOf(temp), left + gap, base - (temp * ratio));
                }
            } else {
                UI.setColor(Color.black);
                UI.fillRect(left + gap, base, thickness, (Math.abs(temp) * ratio));
                UI.setColor(Color.red);
                UI.drawString(String.valueOf(temp), left + gap, base + (Math.abs(temp) * ratio) + 10);
            }
            gap = gap + step;

        }

        UI.println("Finished plotting");
    }

    /** Find and return the maximum level in the list
        *   - There is guaranteed to be at least one level,
        *   - The method will need a variable to keep track of the maximum, which
        *        needs to be initialised to an appropriate value.
        *  COMPLETION
        */
    //Need a bubble sort algorithm?

    public double maximumOfList(ArrayList<Double> listOfNumbers) {
        // double[] _listOfNumbers = listOfNumbers;
        UI.println("method maximumOfList() is not implemented yet"); // remove when you have implemented your method
        /*# YOUR CODE HERE */
        // Arrays.sort(_listOfNumbers);
        double lastNumber = 0;
        double biggestNumber = 0;
        for (double currentNumber : listOfNumbers) {
            if (currentNumber >= lastNumber) {
                biggestNumber = currentNumber;
                lastNumber = currentNumber;
            }

        }

        return biggestNumber; // You need to replace this line - it is just here to make the template compile.
    }

    /** Find and return the minimum level in the list
        *   - There is guaranteed to be at least one level,
        *   - The method will need a variable to keep track of the minimum, which
        *        needs to be initialised to an appropriate value.
        *  COMPLETION
        */
    public double minimumOfList(ArrayList<Double> listOfNumbers) {
        //UI.println("method minimumOfList() is not implemented yet"); // remove when you have implemented your method
        /*# YOUR CODE HERE */
        double lastNumber = 0;
        double smallestNumber = 0;
        for (double currentNumber : listOfNumbers) {
            if (currentNumber <= lastNumber) {
                smallestNumber = currentNumber;
            }
            lastNumber = currentNumber;
        }

        return smallestNumber; // You need to replace this line - it is just here to make the template compile.
    }

    /* public boolean name() {
    
    } */

}
