public abstract class Employee {
    private String name;
    private int  hireYear;

    Employee(String name, int hireYear){
        this.name = name;
        this.hireYear = hireYear;
    }

    Employee(){
        this.name = null;
        this.hireYear = 0;
    }

    public String getName() {
        return name;
    }

    public int getHireYear() {
        return hireYear;
    }

    public String toString() {
        return "Name: " + name + " HireYear: " + hireYear;
    }

    public abstract double annualSalary();

    public abstract double monthlySalary();
}
