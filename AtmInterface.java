import java.util.Scanner;
class BankAccount
{
    private double balance;
    public BankAccount(double initialBalance)
    {
        this.balance=initialBalance;
    }
    public double getBalance()
    {
        return balance;
    }
    public void deposit(double amount)
    {
        if(amount > 0)
        {
            balance += amount;
            System.out.println("Deposit successful.New balance:$"+balance);
        }
        else
        {
           System.out.println("Invalid deposit amount.");
        }
    }
    public boolean withdraw(double amount)
    {
        if(amount > 0)
        {

            if( amount <= balance)
            {
                balance -= amount;
                System.out.println("Withdrawalsuccessful.New balance:$"+balance);
                return true;
            }
            else{
                System.out.println("Insufficient funds for withdrawl.Current balance:$"+balance);
            }
        }
        else
        {
            System.out.println("Invalid withdrawlamount.Please enter a positive number.");
        }
        return false;
    }
}
class ATM
{
    private BankAccount bankAccount;
    public ATM(BankAccount bankAccount)
    {
        this.bankAccount = bankAccount;
    }
    public void displayMenu()
    {
        System.out.println("ATM Menu:");
        System.out.println("1.Check Balance");
        System.out.println("2.Deposit");
        System.out.println("3.Withdraw");
        System.out.println("4.Exit");
    }
    public void run()
    {
        Scanner s = new Scanner(System.in);
        while(true)
        {
            displayMenu();
            System.out.print("Enter your choice:");
            int choice = s.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("Current balance:$"+bankAccount.getBalance());
                    break;
                case 2:
                    System.out.println("Enter the deposit amount:$");
                    double depositAmount = s.nextDouble();
                    bankAccount.deposit(depositAmount);
                    break;
                case 3:
                    System.out.println("Enter the withdrawl amount:$");
                    double withdrawlAmount = s.nextDouble();
                    boolean withdrawSuccess = bankAccount.withdraw(withdrawlAmount);
                    if(withdrawSuccess)
                    {
                        System.out.println("Withdrawal succesful");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice.please try again");
            }
        }
    }
}
public class AtmInterface
{
    public static void main(String args[])
    {
        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}