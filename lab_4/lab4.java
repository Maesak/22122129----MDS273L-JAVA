package lab_4;
import java.util.Scanner;

public class lab4 {
    private String actnam;
    private String actholname;
    private double actbal;
    private String transactions;

    public lab4(String actnam, String actholname, double actbal) {
        this.actnam = actnam;
        this.actholname = actholname;
        this.actbal = actbal;
        this.transactions = "";
    }

    public void deposit(double amount) {
        this.actbal += amount;
        String transaction = "Deposit: +" + amount + " New Balance: " + this.actbal + "\n";
        this.transactions += transaction;
    }

    public void withdraw(double amount) {
        if (this.actbal >= amount) {
            this.actbal -= amount;
            String transaction = "Withdrawal: -" + amount + " New Balance: " + this.actbal + "\n";
            this.transactions += transaction;
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public void printTransactions() {
        System.out.println("************************** \n    Transaction:");
        System.out.println("**************************"); 
        System.out.println(this.transactions);
    }

    public void printAccountSummary() {
        System.out.println("************************** \n    Account summary");
        System.out.println("**************************"); 
        System.out.println("Account number: " + this.actnam);
        System.out.println("Account holder name: " + this.actholname);
        System.out.println("Account balance: " + this.actbal);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter account number:");
        String actnam = input.nextLine();

        System.out.println("Enter account holder name:");
        String actholname = input.nextLine();

        System.out.println("Enter account balance:");
        double actbal = input.nextDouble();

        lab4 bankAccount = new lab4(actnam, actholname, actbal);

        int choice;
        do {
            System.out.println(" _________________________ \n|    Enter your choice:   |");
            System.out.println("|_________________________|"); 
            System.out.println("| 1. Deposit money        |");
            System.out.println("| 2. Withdraw money       |");
            System.out.println("| 3. Print transactions   |");
            System.out.println("| 4. Print account summary|");
            System.out.println("| 5. Exit                 |");
            System.out.println("***************************"); 
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter amount to deposit:");
                    double depositAmount = input.nextDouble();
                    bankAccount.deposit(depositAmount);
                    break;

                case 2:
                    System.out.println("Enter amount to withdraw:");
                    double withdrawAmount = input.nextDouble();
                    bankAccount.withdraw(withdrawAmount);
                    break;

                case 3:
                    bankAccount.printTransactions();
                    break;

                case 4:
                    bankAccount.printAccountSummary();
                    break;

                case 5:
                    System.out.println("Exiting program");
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 5);
        System.out.println("************************** \n   Program closed!!");
        System.out.println("**************************"); 

        input.close();
    }
}
