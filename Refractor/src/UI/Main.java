package UI;

import Model.Pasta;
import Model.Pizza;
import Model.Sandwich;
import Tools.Customer;
import Tools.Kitchen;

public class Main {
    public static void main(String[] args) {

        Kitchen cafe = new Kitchen("Cafe BC");

        //Try sample orders and customers
        cafe.newCustomer(new Customer("Jack", new Pasta(false), new Pasta(true)));
        cafe.getCustomerList().get(cafe.getCustomer("Jack")).addToOrder(new Sandwich(Sandwich.Size.LARGE));
        cafe.newCustomer(new Customer("Litmus", new Pizza(true)));
        cafe.getCustomers();

    }
}
