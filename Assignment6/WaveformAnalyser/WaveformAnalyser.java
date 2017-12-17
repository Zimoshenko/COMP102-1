// This program is copyright VUW.
// You are granted permission to use it to construct your assignment answer,
// You may not distribute it in any other way without permission.
//
/* Code for COMP102
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;

import java.io.*;
import java.util.*;
import java.awt.Color;

import static java.lang.Double.MAX_VALUE;
import static java.lang.Double.MIN_VALUE;

/**
 * This program reads data from a waveform (eg, a sound wave)
 * into an ArrayList, displays it, and performs analysis on it.
 * <p>
 * The methods you are to complete all focus on the ArrayList of data.
 * CORE
 * doRead:              reads numbers into an ArrayList.
 * doDisplay:           displays the waveform.
 * doReportDistortion:  prints out the fraction of time the signal is distorted.
 * doSpread:            displays the spread with two horizontal lines and returns its value.
 * COMPLETION
 * doDisplayDistortion: shows in red the distorted part of the signal.
 * doHighlightPeaks:    plots the peaks with small green circles.
 * CHALLENGE
 * doNormalise:         normalises all the values down so there is no distortion.
 * upperEnvelope:       displays the upper envelope.
 * lowerEnvelope:       displays the lower envelope.
 * doSave:              saves the current waveform values into a file.
 */

public class WaveformAnalyser {
    // Fields 
    private ArrayList<Double> waveform = new ArrayList<Double>();   // the field to hold the ArrayList of values

    // Constant: the threshold for the distortionLevel and showDistortion methods
    public static final double THRESHOLD = 200;

    // Constants: the dimensions of the graph for the displayWaveform method
    public static final int GRAPH_LEFT = 10;
    public static final int ZERO_LINE = 260;

    // Constant fields holding the size of the circles for the highlightPeaks method
    public static final int SIZE_CIRCLE = 10;
    //for future use
    private int count = 0;
    private double max, min = 0;
    private ArrayList<Double> normalisedWaveform = new ArrayList<Double>();
    private ArrayList<Integer> peaks = new ArrayList<>();

    /**
     * Constructor:
     * Set up the ten buttons and mouselistener
     */
    public WaveformAnalyser() {
        //core
        UI.addButton("Read Data", this::doRead);
        UI.addButton("Display Waveform", this::doDisplay);
        UI.addButton("Report Distortion", this::doReportDistortion);
        //completion
        UI.addButton("Spread", this::doSpread);
        UI.addButton("Display Distortion", this::doDisplayDistortion);
        UI.addButton("Peaks", this::doHighlightPeaks);
        //challenge
        UI.addButton("Normalise", this::doNormalise);
        UI.addButton("Envelope", this::doEnvelope);
        UI.addButton("Save", this::doSave);
        UI.addButton("Quit", UI::quit);
    }


    /**
     * [CORE]
     * Clears the panes,
     * Creates an ArrayList stored in a field, then
     * Asks user for a waveform file (eg waveform1.txt)
     * Reads data from the file into the ArrayList
     */
    public void doRead() {
        UI.clearPanes();
        String fname = UIFileChooser.open();
//        String fname = "waveform2.txt";//for convenience while working on other parts
        /*# YOUR CODE HERE */
        try {
            this.waveform.clear();//Clear the ArrayList before read to prevent duplicated data
            Scanner scanner = new Scanner(new File(fname));

            while (scanner.hasNextDouble()) {
                this.waveform.add(scanner.nextDouble());
            }

            UI.println("Read " + this.waveform.size() + " data points from " + fname);

            scanner.close();

        } catch (IOException e) {
            UI.println("ERROR:" + e);

        }


    }

    /**
     * [CORE]
     * Displays the waveform as a line graph,
     * The n'th value in waveform is displayed at
     * x-position is GRAPH_LEFT + n
     * y-position is ZERO_LINE - the value
     * Plots a line graph of all the points with a blue line between
     * each pair of adjacent points
     * Draw the horizontal line representing the value zero.
     * Uses GRAPH_LEFT and ZERO_LINE for the dimensions and positions of the graph.
     * Don't worry if the lines go off the window
     */
    public void doDisplay() {
        if (this.waveform.isEmpty()) { //there is no data to display
            UI.println("No waveform to display");
            return;
        }
        UI.clearGraphics();

        // draw x axis (showing where the value 0 will be)
        UI.setColor(Color.black);
        UI.drawLine(GRAPH_LEFT, ZERO_LINE, GRAPH_LEFT + this.waveform.size(), ZERO_LINE);

        // plot points: blue line between each pair of values
        /*# YOUR CODE HERE */
        int n = 0;
        int _n = 0;
        double current, last = 0;
        for (double num : this.waveform) {
            current = num;
            UI.drawLine((GRAPH_LEFT + n), ZERO_LINE - current, (GRAPH_LEFT + _n), ZERO_LINE - last);
            last = current;
            _n = n;
            n++;

        }
    }

    /**
     * [CORE]
     * Computes and prints out the fraction of time the signal is distorted.
     * This fraction of time is defined as the number of distorted values, divided by the number of values.
     * A distorted value is defined as one whose absolute
     * value is greater than the value of THRESHOLD
     * [Hint] You may find Math.abs() useful for this method - it computes the absolute value
     */
    public void doReportDistortion() {
        if (this.waveform.isEmpty()) { //there is no data to analyse
            UI.println("No signal to analyse and report on");
            return;
        }
        /*# YOUR CODE HERE */
        int distoredTimes = 0;
        for (double num : this.waveform) {
            if (Math.abs(num) > THRESHOLD) {
                distoredTimes++;
            }
        }
        double fraction = ((double) distoredTimes / waveform.size());
//        UI.println(fraction);
//        UI.println(distoredTimes);

        UI.printf("Fraction of time the signal is distorted: %.3f\n", fraction);
    }

    /**
     * [CORE]
     * The spread is the difference between the maximum and minimum values of the waveform.
     * Finds the maximum and minimum values, then
     * Displays the spread by drawing two horizontal lines on top of the waveform:
     * one green line for the maximum value, and
     * one red line for the minimum value.
     */
    public void doSpread() {
        if (this.waveform.isEmpty()) { //there is no data to display
            UI.println("No waveform to display");
            return;
        }
        this.doDisplay();
        /*# YOUR CODE HERE */
        double max = MIN_VALUE;
        double min = MAX_VALUE;

        for (double num : this.waveform) {
            if (num > max) {
                max = num;
                continue;
            }
            if (num < min) {
                min = num;
            }
        }
//        UI.println("min" + min);
//        UI.println("max" + max);
        UI.setColor(Color.green);
        UI.drawLine(GRAPH_LEFT, ZERO_LINE - max, GRAPH_LEFT + this.waveform.size(), ZERO_LINE - max);
        UI.setColor(Color.red);
        UI.drawLine(GRAPH_LEFT, ZERO_LINE - min, GRAPH_LEFT + this.waveform.size(), ZERO_LINE - min);

    }

    /**
     * [COMPLETION]  [Fancy version of doDisplay]
     * Display the waveform as a line graph.
     * Draw a line between each pair of adjacent points
     * * If neither of the points is distorted, the line is BLUE
     * * If either of the two end points is distorted, the line is RED
     * Draw the horizontal lines representing the value zero and thresholds values.
     * Uses THRESHOLD to determine distorted values.
     * Uses GRAPH_LEFT and ZERO_LINE for the dimensions and positions of the graph.
     * [Hint] You may find Math.abs(int a) useful for this method.
     * You may assume that all the values are between -250 and +250.
     */
    public void doDisplayDistortion() {
        if (this.waveform.isEmpty()) { //there is no data to display
            UI.println("No waveform to display");
            return;
        }
        UI.clearGraphics();

        // draw zero axis
        UI.setColor(Color.black);
        UI.drawLine(GRAPH_LEFT, ZERO_LINE, GRAPH_LEFT + this.waveform.size(), ZERO_LINE);

        // draw thresholds
        /*# YOUR CODE HERE */
        UI.setColor(Color.green);
        UI.drawLine(GRAPH_LEFT, ZERO_LINE - THRESHOLD, GRAPH_LEFT + this.waveform.size(), ZERO_LINE - THRESHOLD);
        UI.drawLine(GRAPH_LEFT, ZERO_LINE + THRESHOLD, GRAPH_LEFT + this.waveform.size(), ZERO_LINE + THRESHOLD);


        /*for future use*/



        /*draw waves*/
        UI.setColor(Color.black);
        int n = 0;
        int _n = 0;
        double current, last = 0;
        for (double num : this.waveform) {
            current = num;
            if ((Math.abs(current) > THRESHOLD) || (Math.abs(last) > THRESHOLD)) {//color will be read either current or last is bigger than THRESHOLD
                UI.setColor(Color.red);
            } else {
                UI.setColor(Color.blue);
            }
            UI.drawLine((GRAPH_LEFT + n), ZERO_LINE - current, (GRAPH_LEFT + _n), ZERO_LINE - last);
            last = current;
            _n = n;
            n++;
        }

    }

    /**
     * [COMPLETION]
     * Plots the peaks with small green circles.
     * A peak is defined as a value that is greater or equals to both its
     * neighbouring values.
     * Note the size of the circle is in the constant SIZE_CIRCLE
     * You may assume that peaks values differ from their neighbouring points.
     */
    public void doHighlightPeaks() {
        this.doDisplayDistortion(); //use doDisplay if doDisplayDistortion isn't complete
        /*# YOUR CODE HERE */
        int n = 0;
        this.peaks.clear();
//        UI.println("Computing");
        while (n < this.waveform.size() - 1) {
            if (n < 2) {
                n++;
                continue;
            }
            if ((this.waveform.get(n)) > this.waveform.get(n - 1)) {
                if (this.waveform.get(n) > this.waveform.get(n + 1)) {
                    peaks.add(n);
                }
            }
            n++;
        }

        //draw circles
        for (int num : peaks) {
            UI.setColor(Color.green);
            UI.drawOval(GRAPH_LEFT + num - SIZE_CIRCLE / 2, ZERO_LINE - this.waveform.get(num) - SIZE_CIRCLE / 2, SIZE_CIRCLE, SIZE_CIRCLE);
        }


    }

    /**
     * [CHALLENGE]
     * Finds the largest value (positive or negative) in the waveform, and
     * normalises all the values down so that the largest value is now equal to
     * the distortion threshold.
     * Then redraws the waveform.
     */
    public void doNormalise() {
        /*# YOUR CODE HERE */
        this.normalisedWaveform.clear();

        double ratio = 1;


        //get max&min value
        double max = MIN_VALUE;
        double min = MAX_VALUE;

        for (double num : this.waveform) {
            if (num > max) {
                max = num;
                continue;
            }
            if (num < min) {
                min = num;
            }
        }

        min = Math.abs(min);
        max = Math.abs(max);

        if (min > max) {
            max = min;
        }

        ratio = max / THRESHOLD;

        //normalise
        for (double num : waveform) {
            this.normalisedWaveform.add(num / ratio);
        }

        this.waveform.clear();
        this.waveform.addAll(normalisedWaveform);


        this.doDisplayDistortion(); //use doDisplay if doDisplayDistortion isn't complete
    }

    public void doEnvelope() {
        if (this.waveform.isEmpty()) { //there is no data to display
            UI.println("No waveform to display");
            return;
        }
        this.doDisplayDistortion();  // display the waveform
        this.upperEnvelope();
        this.lowerEnvelope();
    }

    /**
     * [CHALLENGE]
     * Displays the upper envelope with GREEN lines connecting all the peaks.
     * A peak is defined as a point that is greater or equal to *both* neighbouring points.
     * DO NOT clear the graphics as we also want to view the waveform.
     */


    public void getPeaks(boolean negative) {
        int n = 0;
        this.peaks.clear();
//        UI.println("Computing");
        if (negative) {
            while (n <= this.waveform.size()) {
                if (n < 2) {
                    n++;
                    continue;
                }
                if (n == (this.waveform.size() - 1)) {
                    break;
                }
                if (this.waveform.get(n) < 0) {

                    if ((this.waveform.get(n)) < this.waveform.get(n - 1)) {
//                    UI.println(n);
//                    UI.println("<");
                        if (this.waveform.get(n) < this.waveform.get(n + 1)) {
//                        UI.println("<<");
                            peaks.add(n);
                        }
                    }
                }
                n++;
            }
        } else {
            while (n < this.waveform.size()) {
                if (n < 2) {
                    n++;
                    continue;
                }
                if (n == (this.waveform.size() - 1)) {
                    break;
                }
                if (this.waveform.get(n) > 0) {

                    if ((this.waveform.get(n)) > this.waveform.get(n - 1)) {
                        if (this.waveform.get(n) > this.waveform.get(n + 1)) {
                            peaks.add(n);
                        }
                    }
                }
                n++;
            }
        }
//        UI.println(peaks);
    }

    public void upperEnvelope() {
        /*# YOUR CODE HERE */
//        this.doDisplayDistortion();
        this.getPeaks(false);
        boolean firstTime = true;
        int lastNum = 0;
        UI.setColor(Color.pink);

        for (int num : this.peaks) {
            if (firstTime) {
                firstTime = false;
                lastNum = num;
                continue;
            }
            UI.drawLine(GRAPH_LEFT + num, ZERO_LINE - this.waveform.get(num), GRAPH_LEFT + lastNum, ZERO_LINE - this.waveform.get(lastNum));
            lastNum = num;
        }


    }

    /**
     * [CHALLENGE]
     * Displays the lower envelope with RED lines connecting all the "negative" peaks.
     * A "negative" peak is defined as a point that is smaller or equal to *both* neighbouring points.
     * DO NOT clear the graphics as we also want to view the waveform.
     */
    public void lowerEnvelope() {
        /*# YOUR CODE HERE */
//        this.doDisplayDistortion();
        getPeaks(true);
        boolean firstTime = true;
        int lastNum = 0;
        UI.setColor(Color.pink);

        for (int num : this.peaks) {
            if (firstTime) {
                firstTime = false;
                lastNum = num;
                continue;
            }

            UI.drawLine(GRAPH_LEFT + num, ZERO_LINE - this.waveform.get(num), GRAPH_LEFT + lastNum, ZERO_LINE - this.waveform.get(lastNum));

            lastNum = num;
        }

    }

    /**
     * [CHALLENGE]
     * Saves the current waveform values into a file
     */
    public void doSave() {
        /*# YOUR CODE HERE */
        try {
            PrintStream output = new PrintStream(new File(UIFileChooser.save("Save the current waveform")));

            for (double num : waveform) {
                output.println(num);
            }

        } catch (IOException e) {
            UI.println("Save Error:" + e);
        }


    }


    // Main
    public static void main(String[] arguments) {
        new WaveformAnalyser();
    }

}
