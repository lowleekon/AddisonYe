package Model;

public class Pasta extends Food {
    private boolean isDeluxe;

    public Pasta(boolean deluxe){
        super("Pasta", 4.50);
        isDeluxe = deluxe;
        if (isDeluxe){
            setName("Deluxe Pasta");
        }
    }

    @Override
    public double getPrice() {
        if (isDeluxe){return price + 2;}
        else{return price;}
    }

    public String toString() {
        return getName();
    }
}
