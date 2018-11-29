public class Main {
    public static void main(String[] args) {
        Customer client = new Customer("Thomas Anderson", 222.2, 111.1);
        client.deposit(56.8, Customer.CHECKING);
        client.withdraw(200, Customer.CHECKING);
        client.displayDeposits();
        client.displayWithdraws();
    }
}
