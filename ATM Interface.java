import java.util.Scanner;
// BankAccount class to represent the user's bank account
class BankAccount {
    private double balance;
 // Constructor
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }
// Method to deposit money into the account
    public void deposit(double amount) {
        balance += amount;
    }
// Method to withdraw money from the account
    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } 
else {
            System.out.println("Insufficient funds");
            return false;
        }
    }

    // Method to check the account balance
    public double checkBalance() {
        return balance;
    }
}
// ATM class to represent the ATM machine
public class ATM {
    private BankAccount account;
// Constructor
    public ATM(BankAccount account) {
        this.account = account;
    }
// Method to display the ATM menu
    private void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }
// Method to handle user input and perform operations accordingly
    public void operate() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount > 0) {
                        if (account.withdraw(withdrawAmount)) {
                            System.out.println("Withdrawal successful");
                        }
                    } else {
                        System.out.println("Invalid amount");
                    }
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount > 0) {
                        account.deposit(depositAmount);
                        System.out.println("Deposit successful");
                    } else {
                        System.out.println("Invalid amount");
                    }
                    break;
                case 3:
                    System.out.println("Your balance: " + account.checkBalance());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 4);
        scanner.close();
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Initial balance
        ATM atm = new ATM(userAccount);
        atm.operate();
    }
}
