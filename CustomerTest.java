package com.abc;

import org.junit.Ignore;
import org.junit.Test;

import java.text.SimpleDateFormat;


import static org.junit.Assert.assertEquals;

public class CustomerTest {

    @Test //Test customer statement generation
    public void testApp(){

    	String statement="";
    	SimpleDateFormat simplerFormat = new SimpleDateFormat("dd-MMM-YYYY");
		

		Account checkingAccount = new Account(Account.CHECKING);
		Account savingsAccount = new Account(Account.SAVINGS);
		Account maxsavingAccount = new Account(Account.MAXI_SAVINGS);
		Customer henry = new Customer("Henry").openAccount(checkingAccount)
				.openAccount(savingsAccount).openAccount(maxsavingAccount);

		Account checkingAccount2 = new Account(Account.CHECKING);
		Account savingsAccount2 = new Account(Account.SAVINGS);
		Account maxsavingAccount2 = new Account(Account.MAXI_SAVINGS);
		Customer mathew = new Customer("Mathew")
				.openAccount(checkingAccount2).openAccount(savingsAccount2)
				.openAccount(maxsavingAccount2);
		
	
		String tranDate1 = simplerFormat.format(DateProvider.getInstance().now()
				.getTime());
		 

		savingsAccount.deposit(6000.0);
		savingsAccount.withdraw(200.0);

		checkingAccount.deposit(1000.0);
		checkingAccount.withdraw(500.0);

		checkingAccount.transfer(checkingAccount, savingsAccount, 100);

		maxsavingAccount.deposit(4000.0);
		maxsavingAccount.withdraw(2000.0);

		savingsAccount2.deposit(6000.0);
		savingsAccount2.withdraw(200.0);

		checkingAccount2.deposit(1000.0);
		checkingAccount2.withdraw(500.0);

		maxsavingAccount2.deposit(4000.0);
		maxsavingAccount2.withdraw(2000.0);

		DateProvider.moveDateForward = 365;
		
		String tranDate2 = simplerFormat.format(DateProvider.getInstance().now()
				.getTime());

		savingsAccount.deposit(8000.0);
		savingsAccount.withdraw(2000.0);

		checkingAccount.deposit(9000.0);
		checkingAccount.withdraw(2500.0);

		maxsavingAccount.deposit(4520.0);
		maxsavingAccount.withdraw(2150.0);

		DateProvider.moveDateForward = 1000;
		
		String tranDate3 = simplerFormat.format(DateProvider.getInstance().now()
				.getTime());
		
		savingsAccount.deposit(6500.0);
		savingsAccount.withdraw(250.0);

		checkingAccount.deposit(1560.0);
		checkingAccount.withdraw(520.0);


		maxsavingAccount.deposit(3000.0);
		maxsavingAccount.withdraw(1000.0);
		
		DateProvider.moveDateForward = 1005;
		
		
		String tranDate4 = simplerFormat.format(DateProvider.getInstance().now()
				.getTime());
		maxsavingAccount.deposit(5000.0);
		maxsavingAccount.withdraw(500.0);
		
		DateProvider.moveDateForward = 1010;
		
		String tranDate5 = simplerFormat.format(DateProvider.getInstance().now()
				.getTime());
		
		
		
		statement=statement.concat("Statement for Henry\n");
		statement=statement.concat("Statement Date:").concat(tranDate5).concat("\n");
		statement=statement.concat("\n");
		statement=statement.concat("Checking Account\n");
		statement=statement.concat("Date                Deposit             Withdrawal          Balance             \n");             
		statement=statement.concat(tranDate1).concat("         $1,000.00                               $1,000.00           \n");           
		statement=statement.concat(tranDate1).concat("                             $500.00             $500.00             \n");             
		statement=statement.concat(tranDate1).concat("                             $100.00             $400.00             \n");             
		statement=statement.concat(tranDate2).concat("         $9,000.00                               $9,400.00           \n");           
		statement=statement.concat(tranDate2).concat("                             $2,500.00           $6,900.00           \n");           
		statement=statement.concat(tranDate3).concat("         $1,560.00                               $8,460.00           \n");           
		statement=statement.concat(tranDate3).concat("                             $520.00             $7,940.00           \n");           
		statement=statement.concat("\n");
		statement=statement.concat("Total Interest Earned For Checking Account $12.63\n");
		statement=statement.concat("Savings Account\n");
		statement=statement.concat("Date                Deposit             Withdrawal          Balance             \n");             
		statement=statement.concat(tranDate1).concat("         $6,000.00                               $6,000.00           \n");           
		statement=statement.concat(tranDate1).concat("                             $200.00             $5,800.00           \n");           
		statement=statement.concat(tranDate1).concat("         $100.00                                 $5,900.00           \n");           
		statement=statement.concat(tranDate2).concat("         $8,000.00                               $13,900.00          \n");          
		statement=statement.concat(tranDate2).concat("                             $2,000.00           $11,900.00          \n");          
		statement=statement.concat(tranDate3).concat("         $6,500.00                               $18,400.00          \n");          
		statement=statement.concat(tranDate3).concat("                             $250.00             $18,150.00          \n");          
		statement=statement.concat("\n");
		statement=statement.concat("Total Interest Earned For Savings Account $51.51\n");
		statement=statement.concat("Maxi Savings Account\n");
		statement=statement.concat("Date                Deposit             Withdrawal          Balance             \n");            
		statement=statement.concat(tranDate1).concat("         $4,000.00                               $4,000.00           \n");           
		statement=statement.concat(tranDate1).concat("                             $2,000.00           $2,000.00           \n");           
		statement=statement.concat(tranDate2).concat("         $4,520.00                               $6,520.00           \n");           
		statement=statement.concat(tranDate2).concat("                             $2,150.00           $4,370.00           \n");           
		statement=statement.concat(tranDate3).concat("         $3,000.00                               $7,370.00           \n");           
		statement=statement.concat(tranDate3).concat("                             $1,000.00           $6,370.00           \n");           
		statement=statement.concat(tranDate4).concat("         $5,000.00                               $11,370.00          \n");         
		statement=statement.concat(tranDate4).concat("                             $500.00             $10,870.00          \n");         
		statement=statement.concat("\n");
		statement=statement.concat("Total Interest Earned For Maxi Savings Account $499.90\n");
		statement=statement.concat("Total Interest Earned $564.04\n");
		statement=statement.concat("Total Balance for All Accounts (including interests) $37,524.04");
		statement=statement.concat("\n");
		statement=statement.concat("\n");
		assertEquals(statement,henry.getStatement());
		statement="";
		statement=statement.concat("Statement for Mathew\n");
		statement=statement.concat("Statement Date:").concat(tranDate5).concat("\n");
		statement=statement.concat("\n");
		statement=statement.concat("Checking Account\n");
		statement=statement.concat("Date                Deposit             Withdrawal          Balance             \n");             
		statement=statement.concat(tranDate1).concat("         $1,000.00                               $1,000.00           \n");          
		statement=statement.concat(tranDate1).concat("                             $500.00             $500.00             \n");            
		statement=statement.concat("\n");
		statement=statement.concat("Total Interest Earned For Checking Account $1.39\n");
		statement=statement.concat("Savings Account\n");
		statement=statement.concat("Date                Deposit             Withdrawal          Balance             \n");           
		statement=statement.concat(tranDate1).concat("         $6,000.00                               $6,000.00           \n");           
		statement=statement.concat(tranDate1).concat("                             $200.00             $5,800.00           \n");          
		statement=statement.concat("\n");
		statement=statement.concat("Total Interest Earned For Savings Account $29.41\n");
		statement=statement.concat("Maxi Savings Account\n");
		statement=statement.concat("Date                Deposit             Withdrawal          Balance             \n");         
		statement=statement.concat(tranDate1).concat("         $4,000.00                               $4,000.00           \n");         
		statement=statement.concat(tranDate1).concat("                             $2,000.00           $2,000.00           \n");          
		statement=statement.concat("\n");
		statement=statement.concat("Total Interest Earned For Maxi Savings Account $296.75\n");
		statement=statement.concat("Total Interest Earned $327.54\n");
		statement=statement.concat("Total Balance for All Accounts (including interests) $8,627.54");
		statement=statement.concat("\n");
		statement=statement.concat("\n");
		assertEquals(statement,mathew.getStatement());
    }

    @Test
    public void testOneAccount(){
        Customer oscar = new Customer("Oscar").openAccount(new Account(Account.SAVINGS));
        assertEquals(1, oscar.getNumberOfAccounts());
    }

    @Test
    public void testTwoAccount(){
        Customer oscar = new Customer("Oscar")
                .openAccount(new Account(Account.SAVINGS));
        oscar.openAccount(new Account(Account.CHECKING));
        assertEquals(2, oscar.getNumberOfAccounts());
    }

    @Ignore
    public void testThreeAcounts() {
        Customer oscar = new Customer("Oscar")
                .openAccount(new Account(Account.SAVINGS));
        oscar.openAccount(new Account(Account.CHECKING));
        //added maxi savings type of account addition
        oscar.openAccount(new Account(Account.MAXI_SAVINGS));
        assertEquals(3, oscar.getNumberOfAccounts());
    }
}
