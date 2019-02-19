package Model;

public abstract class Food {
    private String name;
    double price;

    Food(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Food(){
        this.name = null;
        this.price = 0;
    }

    public String getName() {
        return name;
    }

    void setName(String newName){
        this.name = newName;
    }

    public abstract double getPrice();

}
