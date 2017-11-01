// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a ${course} assignment.
// You may not distribute it in any other way without permission.
/* Code for ${course} - 2017T2
* Name:
* Username:
* ID:
*/
import ecs100.*;


/** Describes Bank Accounts that have a name and a balance
    When you make a new BankAccount (specifying the name of the account holder) the
        balance is set to 0.
    deposit(double amount)  will add an amount to the balance of the account.
    withdraw(double amount)  will withdraw an amount from the balance of the account, as long
         as the current balance is big enough.
    statement() will print out a brief statement of the account (name and current balance)
 */
public class BankAccount{
    // Fields
    private String accountHolder;
    private double balance;

    /** Construct a new BankAccount object. Parameter is the name of the account holder
    */
    public BankAccount(String name){
	this.accountHolder = name;
	this.balance = 0.0;
    }

    /** Make a deposit to the account. */
    public void deposit(double amount){
	this.balance = this.balance + amount;
	UI.printf("%s deposited $%4.2f\n", this.accountHolder, amount);
	
    }

    /** Make a withdrawal from the account. */
    public void withdraw(double amount){
	if ( this.balance >= amount) {
	    this.balance = this.balance - amount;
	    UI.printf("%s withdrew $%4.2f\n", this.accountHolder, amount);
	}
	else {
	    UI.printf("%s has insufficient funds to withdraw $%4.2f\n", this.accountHolder, amount);
	}
    }
    
    /** Print a statement of the current balance of the account */
    public void statement(){
	UI.printf("%s has a balance of $%4.2f\n", this.accountHolder, balance);
    }
    

}
