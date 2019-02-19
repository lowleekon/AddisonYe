package Model;

public class Sandwich extends Food {

    public enum Size{
        SMALL(6.5), MEDIUM(8.0), LARGE(10.5);
        private double price;

        Size(double d){price = d;}
        double getPrice() {return price;}
    }

    public Sandwich(Size size){
        super(size.toString() + " " + "Sandwich",size.getPrice());
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String toString() {
        return getName();
    }
}
