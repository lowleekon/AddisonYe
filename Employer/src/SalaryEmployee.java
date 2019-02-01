public class SalaryEmployee extends Employee {
    private int annualSalary;
    private boolean hasBenefits;

    SalaryEmployee(String name, int hireYear, int annualSalary){
        super(name, hireYear);
        this.annualSalary = annualSalary;
    }

    public double annualSalary(){
        return annualSalary;
    }

    public double monthlySalary(){
        return annualSalary()/12;
    }
}
