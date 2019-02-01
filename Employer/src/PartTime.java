public class PartTime extends HourlyEmployee{
    private boolean hasBenefits;

    PartTime(String name, int hireYear, double hoursPerWeek, double hourlyWage){
        super(name, hireYear, hoursPerWeek, hourlyWage);
    }

    public boolean hasBenefits() {
        return hasBenefits;
    }

    public double annualSalary(){
        return hourlyWage*hoursPerWeek*52;
    }

    public double monthlySalary(){
        return annualSalary()/12;
    }
}
