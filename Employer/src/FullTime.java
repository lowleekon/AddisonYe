public class FullTime extends HourlyEmployee{
    private boolean hasBenefits;

    FullTime(String name, int hireYear, double hoursPerWeek, double hourlyWage){
        super(name, hireYear, hoursPerWeek, hourlyWage);
    }

    public boolean hasBenefits() {
        return hasBenefits;
    }

    public double annualSalary(){
        return hoursPerWeek*hoursPerWeek*52;
    }

    public double monthlySalary(){
        return hoursPerWeek*hoursPerWeek*52/12;
    }
}
