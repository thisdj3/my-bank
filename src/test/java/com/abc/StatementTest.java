package com.abc;

public class StatementTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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

		savingsAccount.deposit(8000.0);
		savingsAccount.withdraw(2000.0);

		checkingAccount.deposit(9000.0);
		checkingAccount.withdraw(2500.0);

		maxsavingAccount.deposit(4520.0);
		maxsavingAccount.withdraw(2150.0);

		DateProvider.moveDateForward = 1000;

		savingsAccount.deposit(6500.0);
		savingsAccount.withdraw(250.0);

		checkingAccount.deposit(1560.0);
		checkingAccount.withdraw(520.0);


		maxsavingAccount.deposit(3000.0);
		maxsavingAccount.withdraw(1000.0);
		
		DateProvider.moveDateForward = 1005;
		maxsavingAccount.deposit(5000.0);
		maxsavingAccount.withdraw(500.0);
		DateProvider.moveDateForward = 1010;
		
		System.out.println(henry.getStatement());
		System.out.println(mathew.getStatement());

	}

}
