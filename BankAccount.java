import java.util.Scanner;

public class BankAccount {
    private double balance;

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        public double getBalance() {
            return balance;
        }

        public void deposit(double amount) {
            balance += amount;
        }

        public boolean withdraw(double amount) {
            if (amount > balance) {
                System.out.println("Insufficient funds. Withdrawal failed.");
                return false;
            } else {
                balance -= amount;
                System.out.println("Withdrawal successful. Remaining balance: " + balance);
                return true;
            }
        }
    }

    class AtmInterface {
        private BankAccount userAccount;

        public AtmInterface(BankAccount account) {
            this.userAccount = account;
        }

        public void displayMenu() {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
        }

        public void processOption(int option, Scanner scanner) {
            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        private void checkBalance() {
            System.out.println("Current Balance: " + userAccount.getBalance());
        }

        private void deposit(Scanner scanner) {
            System.out.print("Enter deposit amount: ");
            double depositAmount = scanner.nextDouble();
            userAccount.deposit(depositAmount);
            System.out.println("Deposit successful. New balance: " + userAccount.getBalance());
        }

        private void withdraw(Scanner scanner) {
            System.out.print("Enter withdrawal amount: ");
            double withdrawalAmount = scanner.nextDouble();
            userAccount.withdraw(withdrawalAmount);
        }
    }
        class BankDemo {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                System.out.print("Enter initial balance for your bank account: ");
                double initialBalance = scanner.nextDouble();

                BankAccount userAccount = new BankAccount(initialBalance);
                AtmInterface atm = new AtmInterface(userAccount);

                while (true) {
                    atm.displayMenu();
                    System.out.print("Enter your choice: ");
                    int option = scanner.nextInt();
                    atm.processOption(option, scanner);
                }
            }
        }





