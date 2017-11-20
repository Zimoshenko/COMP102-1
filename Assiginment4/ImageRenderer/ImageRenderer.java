
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

/** Renders plain ppm images onto the graphics panel
 *  ppm images are the simplest possible colour image format.
 */

public class ImageRenderer {
    public static final int TOP = 20; // top edge of the image
    public static final int LEFT = 20; // left edge of the image
    public static final int PIXEL_SIZE = 2;

    // Constructor
    public ImageRenderer() {
        UI.initialise();
        UI.addButton("Clear", UI::clearGraphics);
        UI.addButton("Render (core)", this::doRenderImageCore);
        UI.addButton("Render (compl)", this::doRenderAnimatedImage);
        UI.addButton("Quit", UI::quit);
        UI.setWindowSize(850, 700);
        UI.setDivider(0.0);
    }

    /** Core:
        * Renders a ppm image file.
        * Asks for the name of the file, then calls renderImageHelper.
        */
    public void doRenderImageCore() {
        //String fileName = UI.askString("Input name of the file:");
        try {
            Scanner scan = new Scanner(new File("1-image-rose.ppm"));
            this.renderImageHelper(scan);
        } catch (Exception e) {
            //TODO: handle exception
        }

        /*# YOUR CODE HERE */

    }

    /** Core:
        * Renders a ppm image file.
        * Renders the image at position (LEFT, TOP).
        * Each pixel of the image  is rendered by a square of size PIXEL_SIZE
        * Assumes that
        * - the colour depth is 255,
        * - there is just one image in the file (not "animated"), and
        * - there are no comments in the file.
        * The first four tokens are "P3", number of columns, number of rows, 255
        * The remaining tokens are the pixel values (red, green, blue for each pixel)
        */
    public Color colorHelper(int r,int g,int b) {
        Color color = new Color(r, g, b);
        return color;
        
    }
    
    
        public void renderImageHelper(Scanner sc) {
        /*# YOUR CODE HERE */
        //    if (!sc.next().equals("P3")) {
        //    UI.println("File is not a ppm image");
        //    }
        //    else{
        //    }
        sc.next();
        int cols = sc.nextInt();
        int rows = sc.nextInt();
        int r,g,b;
        sc.nextInt();

        int row = 0;
        int col = 0;
        int x = 0;
        int y = 0;
        int i =0;

        while (row != rows) {
            while (col != cols) {
                    r = sc.nextInt();
                    g = sc.nextInt();
                    b = sc.nextInt();
                    UI.setColor(colorHelper(r,g,b));
                    UI.fillRect(x + col * PIXEL_SIZE, y + row * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);

                    col++;
                }
                col = 0;
                row++;
            }

        }



    

    /** Completion
        * Renders a ppm image file which may be animated (multiple images in the file)
        * Asks for the name of the file, then renders the image at position (LEFT, TOP).
        * Each pixel of the image  is rendered by a square of size PIXEL_SIZE
        * Renders each image in the file in turn with 200 mSec delay.
        * Repeats the sequence 3 times.
        */
    public void doRenderAnimatedImage() {
        /*# YOUR CODE HERE */

    }

}
