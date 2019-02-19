package Tools;

import Model.*;

import java.util.ArrayList;

public class Order {
    private ArrayList<Food> Receipt;
    private Clock start;
    private Clock end;

    Order(ArrayList<Food> Receipt, Clock start){
        this.Receipt = Receipt;
        this.start = start;
        end = checkStock(Receipt, new Clock(start));
    }

    private Clock checkStock(ArrayList<Food> Receipt, Clock end){
        //Checks that the kitchen stock list has what is on the order
        //returns amount missing amount * 10 minutes
		int amountMissing = 0;
        for (Food r : Receipt){
            boolean missing = true;
            for (Food f : Kitchen.stock) {
                if (r.getName().equals(f.getName())){
                    missing = false;
                }
            }
            if (missing){
                amountMissing += 1;
            }
        }
		for (int i = 0; i < amountMissing*600; i++){
            end.Tick();
		}
        return end;
    }

    private String getTotalPrice(){
        double total = 0;
        for (Food f : Receipt){
            total += f.getPrice();
        }
        return String.valueOf(total);
    }

    public String toString() {
        return Receipt.toString() + " Start: " + start + " ETA End: " + end + " Total Price: $" + getTotalPrice();
    }
}
