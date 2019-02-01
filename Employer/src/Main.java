import java.util.ArrayList;

public class Main {
    public static ArrayList<HourlyEmployee> getHourlyEmployees(ArrayList<Employee> list){
        ArrayList<HourlyEmployee> temp = new ArrayList<>();
        for (Employee o : list){
            if (o instanceof HourlyEmployee){
                temp.add((HourlyEmployee)o);
            }
        }
        return temp;
    }

    public static ArrayList<FullTime> getFullTimeEmployees(ArrayList<Employee> list){
        ArrayList<FullTime> temp = new ArrayList<>();
        for (Employee o : list){
            if (o instanceof FullTime){
                temp.add((FullTime) o);
            }
        }
        return temp;
    }

    public static ArrayList<PartTime> getPartTimeEmployees(ArrayList<Employee> list){
        ArrayList<PartTime> temp = new ArrayList<>();
        for (Employee o : list){
            if (o instanceof PartTime){
                temp.add((PartTime)o);
            }
        }
        return temp;
    }

    public static ArrayList<SalaryEmployee> getSalaryEmployees(ArrayList<Employee> list){
        ArrayList<SalaryEmployee> temp = new ArrayList<>();
        for (Employee o : list){
            if (o instanceof SalaryEmployee){
                temp.add((SalaryEmployee) o);
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new SalaryEmployee("Bob", 1824, 86));
        employees.add(new PartTime("Kyle", 485, 56.2, 56.2));
        employees.add(new FullTime("Bile", 4985, 56.2, 56.2));
        System.out.println(getHourlyEmployees(employees));
    }
}
