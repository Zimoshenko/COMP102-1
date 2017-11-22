// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a ${course} assignment.
// You may not distribute it in any other way without permission.
/* Code for ${course} - 2017T2
* Name:
* Username:
* ID:
*/
import ecs100. * ; 
import java.util. * ; 
import java.io. * ; 
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
        UI.addButton("Render(challenge)", this::doChallenge); 
        UI.addButton("Quit", UI::quit); 
        UI.setWindowSize(850, 700); 
        UI.setDivider(0.0); 
    }

    /** Core:
        * Renders a ppm image file.
        * Asks for the name of the file, then calls renderImageHelper.
        */
    public void doRenderImageCore() {
        String fileName = UI.askString("Input name of the file:"); 
        try {
            Scanner scan = new Scanner(new File(fileName)); 
            this.renderImageHelper(scan); 
        }catch (Exception e) {
            UI.println("File error:" + e); 
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
    public Color colorHelper(int r, int g, int b) {
        Color color = new Color(r, g, b); 
        return color; 
    }
    
    
        public void renderImageHelper(Scanner sc) {
        /*# YOUR CODE HERE */
            if (sc.next().equals("P3")) {//First string in the file should be "P3"
}
            else {
            UI.println("File is not a ppm image"); 
            return; 
            }
        //sc.next();
        int cols = sc.nextInt(); 
        int rows = sc.nextInt(); 
        int r, g, b; 
        sc.nextInt(); //that should be 255

        int row = 0; 
        int col = 0; 
        int x = 20; 
        int y = 20; 
        int i = 0; 
        /* Render pixels LINE by LINE  */
        while (row != rows) {
            while (col != cols) {
                    r = sc.nextInt(); 
                    g = sc.nextInt(); 
                    b = sc.nextInt(); 
                    UI.setColor(colorHelper(r, g, b)); 
                    UI.fillRect(x + col * PIXEL_SIZE, y + row * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE); 
                    col++; 
                }
                col = 0; //reset col counter to 0 to start a new line
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
        //String fileName = "2-multi-image-flag.ppm"; 
        String fileName = UI.askString("Input name of the file:"); 
        try {
            Scanner scan = new Scanner(new File(fileName)); 
            this.renderAnimatedImageHelper(scan); 
        }catch (Exception e) {
            UI.println("File error:" + e); 
            //TODO: handle exception
        }
    }

    public void renderAnimatedImageHelper(Scanner sc) {
        /* need to splip the ppm up, starts with P3 and ends with P3(?)
                                                                  => useDelimiter!
        */
        sc.useDelimiter("P3"); 
        while (sc.hasNext()) {
            String image = "P3\n" + sc.next(); //the easiest way to reuse code(?)
this.renderImageHelper(string2Scanner(image)); 
            UI.sleep(200); 
        }
    }

    public Scanner string2Scanner(String string) {
        Scanner scanner = new Scanner(string); 
        return scanner; 
    }


    public void doChallenge() {
        String fileName = UIFileChooser.open("Open file");
        //String fileName = UI.askString("Input name of the file:"); 
        try {
            File file = new File(fileName); 
            if (formatChecker(file) == 3) {//normal P3 file
                this.renderImageHelper(string2Scanner(commentRemover(file)));
                }else if(formatChecker(file) == 4){//animated P3 file
                    this.renderAnimatedImageHelper(string2Scanner(commentRemover(file)));
                }else if (formatChecker(file) == 2) {//WIP:grey scale image  NOTE:Should add another value for animated scale image
                    //WIP
                }

            
            
            //Scanner scan = new Scanner(file); 


            //this.challengeRender(file); 
        }catch (Exception e) {
            UI.println("File error:" + e); 
            //TODO: handle exception
        }
        
    }
    public int formatChecker(File file) {
        try {
            Scanner scan = new Scanner(file); 
            String fileHeader = scan.next(); 
            if (fileHeader.equals("P3")) {
                scan.useDelimiter("P3");
                scan.next();
                if (scan.hasNext()) {
                    return 4;                    
                }else{
                return 3; 
                }
            }else if (fileHeader.equals("P2")) {
                return 2; 
            }else {
                return 0; 
            }
            
        } catch (Exception e) {
            UI.println("Error"+ e);
            //TODO: handle exception
        }
        return 0;
        

    }


    public String commentRemover(File file) {// scan the file line by line and if found "#" then skip all the line
        String image = "";
        String next = "";
        int lineCounter = 0;
        UI.println("Detecting comments...");
        try {
            Scanner scan = new Scanner(file);            
                while (scan.hasNext()) {
                    String line = scan.nextLine();
                    lineCounter++;
                    //UI.println("LINE:"+ lineCounter);
                    Scanner lineScanner = new Scanner(line);
                    if (line.contains("#")) {
                        if (line.startsWith("#")) {
                            lineScanner.nextLine();                            
                        }
                        while (lineScanner.hasNext()) {
                            next = lineScanner.next();
                                if (next.startsWith("#")) {
                                    lineScanner.nextLine();                            
                                }else{
                                    image = image + next + " ";
                                }                          
                            }
                    }else{
                        image = image + line+" ";
                    }
                }
                //UI.println(image);
                // renderImageHelper(string2Scanner(image));          
                } catch (Exception e) {
            UI.println("File error:" + e); 
            //TODO: handle exception
        }


        
        return image;
    }






    public void challengeRender(File file) {
        
    }

}




   












