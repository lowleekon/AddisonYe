package sample;

public class fullNameNeeded extends Throwable{
    private String[] name;
    private Boolean check = false;
    fullNameNeeded(){
        check = true;
    }
    fullNameNeeded(String[] name){
        this.name = name;
    }

    @Override
    public String toString() {
        if (check){
            return "You have one or more missing fields.";
        }else{
            return String.join("", name)+ " is not a valid name. Please input a first and last name.";
        }
    }
}
