import java.util.Scanner;

public class BankingApplication {

	public static void main(String args[]) {
		
		BankAccount obj1 = new BankAccount("Cam","BA0001");
		obj1.showMenu();
	}
}

class BankAccount
{

	private int balance;
	private int previousTransaction;
	private String customerName;
	private String customerId;
	
	BankAccount(String cname, String cid){
		customerName = cname;
		customerId = cid;
	}
	
	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public void setPreviousTransaction(int previousTransaction) {
		this.previousTransaction = previousTransaction;
	}

	public void deposit(int amount) {
		
		if(amount != 0) {
			balance += amount;
			previousTransaction = amount;
		}
	}
	
	public void withdraw(int amount) {
		
		if(amount != 0) {
			balance -= amount;
			previousTransaction = -amount;
		}
	}
	
	public void getPreviousTransaction() {
		
		if(previousTransaction > 0) {
			
			System.out.println("Deposited: " + previousTransaction);
			
		}else if(previousTransaction < 0) {
			
			System.out.println("Withdrawn: " + Math.abs(previousTransaction));
			
		}else {
			
			System.out.println("No transaction occured");
		}
		
	}
	
	public void showMenu() {
		
		char option = '\0';
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome " + getCustomerName());
		System.out.println("Your bank id is " + getCustomerId());
		System.out.println();
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous Transaction");
		System.out.println("E. Exit");
		
		do {
			
			System.out.println("=====================================================================");
			System.out.println("Enter an option");
			System.out.println("=====================================================================");
			option = scan.next().charAt(0);
			System.out.println();
			
			switch(option) {
			
			case 'A':
				System.out.println("---------------------------------");
				System.out.println("Balance : " + getBalance());
				System.out.println("---------------------------------");
				System.out.println();
				break;
				
			case 'B':
				System.out.println("---------------------------------");
				System.out.println("Enter an amount to deposit");
				System.out.println("---------------------------------");
				int amount = scan.nextInt();
				deposit(amount);
				System.out.println();
				break;
				
			case 'C':
				System.out.println("---------------------------------");
				System.out.println("Enter an amount to withdraw");
				System.out.println("---------------------------------");
				int amount2 = scan.nextInt();
				withdraw(amount2);
				System.out.println();
				break;
				
			case 'D':
				System.out.println("---------------------------------");
				getPreviousTransaction();
				System.out.println("---------------------------------");
				System.out.println();
				break;
			
			case 'E':
				System.out.println("*********************************");
				break;	
				
			default:
				System.out.println("Invalid Option! Please enter again.");
				break;
			}
			
		}while(option != 'E');
		
		System.out.println("Thank you for using our services.");
	}
}