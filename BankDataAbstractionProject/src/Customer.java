//import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    //private double savingRate;
    //private final int OVERDRAFT = -100;
    private String name;
    private int accountNumber;
    private ArrayList<Deposit> deposits = new ArrayList<>();
    private ArrayList<Withdraw> withdraws = new ArrayList<>();
    private double checkBalance;
    private double savingBalance;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private static int n = 0;

    Customer(){
        this.name = null;
        n += 1; this.accountNumber = n;
        checkBalance = 0;  savingBalance = 0;
    }
    Customer(String name, double checkDeposit, double savingDeposit){
        this.name = name;
        n +=1;  this.accountNumber = n;
        checkBalance = 0;  savingBalance = 0;
        deposit(checkDeposit, CHECKING);
        deposit(savingDeposit, SAVING);
    }
    public void deposit(double amt, String account){
        Date date = new Date();
        Deposit depositClass = new Deposit(amt, date, account);
        deposits.add(depositClass);
        if (account.equals(CHECKING)){
            checkBalance += amt;}
        else if (account.equals(SAVING)){
            savingBalance += amt;}
    }
    public void withdraw(double amt, String account){
        Date date = new Date();
        if (checkOverdraft(amt, account)){
            Withdraw withdrawClass = new Withdraw(amt, date, account);
            withdraws.add(withdrawClass);
            if (account.equals(CHECKING)){
                checkBalance -= amt;}
            else if (account.equals(SAVING)){
                savingBalance -= amt;}
        }
        else{System.out.println("There is not enough money in your " + account + " account.");}
    }
    private boolean checkOverdraft(double amt, String account){
        if (account.equals(CHECKING)){return amt <= checkBalance;}
        else if (account.equals(SAVING)){return amt <= savingBalance;}
        else{return false;}
    }
    public int displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
        return deposits.size();
    }
    public int displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
        return withdraws.size();
    }
}