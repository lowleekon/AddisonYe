package Tools;

import Model.Food;

import java.util.ArrayList;
import java.util.Arrays;

public class Customer {
    String name;
    private ArrayList<Food> tempOrder = new ArrayList<>();
    private Order order;
    private Clock clock;

    public Customer(String name, Food... food){
        this.name = name;
        clock = new Clock();
        addToOrder(food);
    }

    Order getOrder(){
        return order;
    }

    public void addToOrder(Food... food){
        //adds all of food input into an order object
        tempOrder.addAll(Arrays.asList(food));
        this.order = new Order(getTempOrder(), clock);
    }

    private ArrayList<Food> getTempOrder(){
        return tempOrder;
    }

    public String toString() {
        return name + " " + order.toString();
    }
}
