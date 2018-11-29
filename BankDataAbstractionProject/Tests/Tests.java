import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class Tests {
    Customer testClient;
    @Before
    public void setup(){testClient = new Customer();}
    @Test
    public void testDepositToString(){
        //Initialize Objects
        Date date = new Date();
        Deposit testDepositClass = new Deposit(0, date, Customer.SAVING);
        //Checks if toString gives a string
        assertEquals(testDepositClass.toString().getClass(), String.class);
    }
    @Test
    public void testWithdrawToString(){
        //Initialize Objects
        Date date = new Date();
        Withdraw testWithdrawClass = new Withdraw(0, date, Customer.SAVING);
        //Checks if toString gives a string
        assertEquals(testWithdrawClass.toString().getClass(), String.class);
    }
    @Test
    public void testDeposit(){
        //checks that there are no deposits
        assertEquals(testClient.displayDeposits(), 0);
        //add a deposit
        testClient.deposit(0,Customer.CHECKING);
        //check if there was a deposit
        assertEquals(testClient.displayDeposits(), 1);
    }
    @Test
    public void testWithdraw(){
        //checks that there are no deposits
        assertEquals(testClient.displayWithdraws(), 0);
        //add a deposit
        testClient.withdraw(0,Customer.CHECKING);
        //check if there was a deposit
        assertEquals(testClient.displayWithdraws(), 1);
    }
}
