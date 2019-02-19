package Model;

public class Pizza extends Food {
    private boolean isDeluxe;

    public Pizza(boolean deluxe){
        super("Pizza", 5.50);
        isDeluxe = deluxe;
        if (isDeluxe){
            setName("Deluxe Pizza");
        }
    }

    @Override
    public double getPrice() {
        if (isDeluxe){return price + 3;}
        else{return price;}
    }

    public String toString() {
        return getName();
    }
}
