package CartoonStrip;

// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a ${course} assignment.
// You may not distribute it in any other way without permission.
/* Code for ${course} - 2017T2
* Name:
* Username:
* ID:
*/
import ecs100.*;

/** Program to create simple animated cartoon strips using the
 *  CartoonCharacter class.
 */

public class CartoonStrip{

    /** Constructor: set up usekr interface */
    public CartoonStrip(){
           UI.initialise();
           UI.addButton("Clear", UI::clearGraphics );
           UI.addButton("Animate", this::doAnimate );
           UI.addButton("Three dancers", this::doThreeDancers );
           UI.addButton("Challenge", this::doChallenge);
           UI.addButton("Quit", UI::quit );
           UI.setDivider(0);          // Expand the graphics area
    }

    /** doAnimate creates two cartoon characters on the window.
        *  Then animates them according to a fixed script by calling a series
        *  of methods on the characters.
        */
    public void doAnimate(){
     /*# YOUR CODE HERE */


     CartoonCharacter character1 = new CartoonCharacter(100, 50, "Jim");

     CartoonCharacter character2 = new CartoonCharacter(250, 250, "Jon");

     character2.lookLeft();
     character1.walk(11.4);
     character2.smile();
     character2.speak("First of all, what's your age?");
     character1.smile();
     character1.speak("24 years old.");
     character1.frown();
     character2.speak("24? Are you employed?");
     character1.smile();
     character1.speak("I'm a Student.");
     character2.speak("Ah..(Guessing)");
     character2.speak("How about your height and weight?");
     character1.lookLeft();
     character1.speak("For height is 170cm, for weight is 74kg.");
     character1.lookRight();
     character2.speak("74kg..");
     character2.speak("You're doing some fitness trainings, right? You have some nice muscle.");
     character1.speak("Nothing much. Though I do some trainings.");
     character2.speak("Do you have a girl friend?");
     character1.speak("Not now.");
     character2.speak("When did you break up?");
     character1.speak("Ko... Last year.");
     character2.speak("Last year?");
     character1.speak("Yes.");


         }

    /** doThreeDancers creates three cartoon characters on the window.
        *  Then makes each character do the same little dance in turn,
        *  by calling the dance method.
        */
    public void doThreeDancers(){
     /*# YOUR CODE HERE */

     CartoonCharacter character1 = new CartoonCharacter(150, 50, "Jim");
     CartoonCharacter character2 = new CartoonCharacter(250, 250, "Jon");
     CartoonCharacter character3 = new CartoonCharacter(550, 50, "Jon");
     dance(character1);
     dance(character2);
     dance(character3);




   }

    /** Makes a character do a little dance.
    Has one parameter - a CartoonCharacter object
        */
    public void dance(CartoonCharacter face){
      /*# YOUR CODE HERE */
      face.walk(60);
      face.speak("PON!");
      face.lookLeft();
      face.walk(114);
      face.speak("DON!");
      face.lookRight();
      face.walk(51.4);
      face.speak("KA!");



    }
    public void doChallenge(){
     CartoonCharacter character1 = new CartoonCharacter(150, 50, "Jim");
     CartoonCharacter character2 = new CartoonCharacter(250, 250, "Jon");
     character2.lookLeft();
     character1.walk(11.4);
     character2.smile();
     character2.speak("First of all, what's your age?");
     character1.smile();
     int age = UI.askInt("Your age");
     if (age >=23) {
      character2.speak("Are you employed?");
      String ans = UI.askString("Yes or No (Y/n)");
      if (ans.equalsIgnoreCase("y")) {
        character1.speak("Yes, I have job.");
        }else{
          character1.speak("No, I don't have job.");
        }
    }else{
      character2.speak("You're a student, right?");
      String ans = UI.askString("Yes or No (Y/n)");
      if (ans.equalsIgnoreCase("y")) {
        character1.speak("Yes, I'm a student");
        }else{
          character1.speak("No, I'm not a student");
    }
  }
  character2.speak("Nice to meet you!");
  character1.speak("Nice to meet you too.");
  character2.think("VANISH!");
  character2.walk(600);
  character1.think("VANISH!");
  character1.lookLeft();
  character1.walk(600);


 }}

