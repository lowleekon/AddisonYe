package Tools;

import Model.Food;
import Model.Pasta;
import Model.Pizza;
import Model.Sandwich;

import java.util.ArrayList;

public class Kitchen {
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>();
    static ArrayList<Food> stock = new ArrayList<>();

    public Kitchen(String name){
        this.name = name;
        cookFood();
    }

    private void cookFood(){
        for(int i = 0 ; i< 5;i++){
            makePizza();
            makePasta();
            makeSandwich();
        }
    }

    public void getOrders(){
        for (Customer c : getCustomerList()){
            System.out.println(c.getOrder());
        }
    }

    public int getCustomer(String name){
    //searches for index of the customer given in customer list
        for (Customer c : getCustomerList()){
            if (c.name.equals(name)){
                return getCustomerList().indexOf(c);
            }
        }
        return 0;
    }

    public void newCustomer(Customer customer){
        customers.add(customer);
    }

    public void getCustomers(){
        for (Customer c : getCustomerList()){
            System.out.println(c.toString());
        }
    }

    public ArrayList<Customer> getCustomerList(){
        return customers;
    }

    private void makePasta(){
        stock.add(new Pasta(false));
    }
    private void makePizza() {
        stock.add(new Pizza(false));
    }
    private void makeSandwich(){
        stock.add(new Sandwich(Sandwich.Size.SMALL));
    }
}
