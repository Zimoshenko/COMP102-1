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

/**
 * Reads a date from the user as three integers, and then checks that the date is valid
 */

public class DateValidator {

    /** Constructor: set up the user interface (already written for you) */
    public DateValidator(){
           UI.initialise();
           UI.addButton("Clear", UI::clearText );
           UI.addButton("Validate Date Core", this::doCore );
           UI.addButton("Validate Date Completion", this::doCompletion );
           UI.addButton("Challenge!",this::doChallenge);
           UI.addButton("Quit", UI::quit );
           UI.setDivider(1);          // Expand the text area
    }

    /**
        * Asks user for a date, then determines whether the date
        *    specified by the three integers is a valid date.
        */
    public void doCore(){
           int yr = UI.askInt("Year: ");
           int mnth = UI.askInt("Month: ");
           int day = UI.askInt("Day: ");
           this.validateDateCore(yr, mnth, day);
    }

    /**
        * Checks the date:
        * - the day must be between 1 and 31
        * - The month must be between 1 and 12
        * - The year must be a positive number
        */
    public void validateDateCore(int year, int month, int day){
           /*# YOUR CODE HERE */
           boolean dayReal, monthReal, yearReal;
           if ((day>0) && (day<=31) ) {//check if day is real
               dayReal = true;

           }else{ dayReal = false;}
           if ((month>0) && (month<=12)) {
           	    monthReal = true;
           	}else{ monthReal = false;}
           if ((year>0)) {
           	    yearReal = true;
           	}else{ yearReal = false;}
           if ((dayReal && monthReal && yearReal)) {
           	UI.printf("DATE IS REAL");
           }else{
            UI.println("DATE IS NOT VALID");}


    }

    /**
        * Asks user for a date, then determines whether the date
        *    specified by the three integers is a valid date.
        */
    public void doCompletion(){
           int year = UI.askInt("Year (4 digits): ");
           int month = UI.askInt("Month: ");
           int day = UI.askInt("Day: ");
           //int year = 2004;
           //int month = 1;
           //int day = 1;
           this.validateDateCompletion(day, month, year);
    }





        public void doChallenge(){
           int year = UI.askInt("Year (4 digits): ");
           int month = UI.askInt("Month: ");
           int day = UI.askInt("Day: ");

           this.validateDateChallenge(day, month, year);
    }

    /**
        * For the Completion, you should also check that the day is valid for the month
        * some months don't have a day 31
        * February doesn't have a day 30 or 31
        * On non-leap years, February doesnt have a day 29
        *    A year is a leap year if:
        *          - The year can be evenly divided by 4 but not 100,  OR
        *          - The year can be evenly divided by 400
        */
    public boolean validateDateCompletion(int day, int month, int year){
           /*# YOUR CODE HERE */
           boolean leapTrue, yearTrue, monthTrue, dayTrue;
           int februaryMaxDate;
           if (year<=9999 && year>=1) {
           	yearTrue = true;
           }else{yearTrue = false;}
           if ((year % 400==0 )) {//check if year is LEAP
           	leapTrue = true;
           }else if ((year % 4 ==0) && ((year % 100 !=0))) {
           	leapTrue = true;
           } else{
           	leapTrue = false;
           }
           if (leapTrue) {
           	februaryMaxDate = 29;
           }else{februaryMaxDate =28; }
           int[] maxDate = {31,februaryMaxDate,31,30,31,30,31,31,30,31,30,31};
            if (month>=1 && month <=12) {//check if month is valid
            	monthTrue= true;
            }else{monthTrue = false;}
              if (day>=1 && (day <=maxDate[(month-1)])) {//check date is valid or not
              	dayTrue = true;
              }else{dayTrue = false;}
			if (dayTrue && monthTrue && yearTrue) {//if all of them're true then the date is valid
			UI.println("DATE IS VALID");
		}else{
			UI.println("DATE IS NOT VALID");
		}
		return (dayTrue && monthTrue && yearTrue);



	}

    /**
        * For the challenge, your program should also check whether the date is
        * part of the Chinese national holiday or the Chinese new year and should print a
        * message in either case.
        */
    public void validateDateChallenge(int day, int month, int year){
    	/*# YOUR CODE HERE */
			//this.validateDateCompletion(day, month, year);
    	boolean nationalDayTrue, newYearTrue;

    	if (validateDateCompletion(day,month,year)) {
           if ((month == 10)&&(day>=1 && day <=7)) {//check if is national day
           	nationalDayTrue = true;
           }else{nationalDayTrue = false;}

           if (nationalDayTrue) {
           	UI.println("It's part of the Chinese national holiday!!!!");
           }


       }







    }


}

