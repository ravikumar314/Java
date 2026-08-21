abstract class Employee{

    protected String employeeId;
    protected String employeeName;
    protected double baseSalary;
    protected String email;

    Employee(String employeeId, String employeeName, double baseSalary, String email){
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.baseSalary = baseSalary;
        this.email = email;
    }


    public void login(){
        System.out.println("Employee " + employeeName + " logged in");
    }

    public void logout(){
        System.out.println("Employee " + employeeName + " logged out");
    }

    public double getBaseSalary(){
        return baseSalary;
    }

    public abstract double calculateSalary();

}


class SoftwareEngineer extends Employee{

    private double performanceBonus;

    SoftwareEngineer(String employeeId, String employeeName, double baseSalary, String email, double bonus){
        super(employeeId, employeeName, baseSalary, email);
        this.performanceBonus = bonus;
    }

    @Override
    public double calculateSalary(){
        return baseSalary + performanceBonus;
    }

    public void writeCode(){
        System.out.println("writing code");
    }
}

class Manager extends Employee {

    private double performanceBonus;

    public Manager(
            String employeeId,
            String name,
            double baseSalary,
            String email,
            double performanceBonus) {

        super(employeeId, name, baseSalary, email);
        this.performanceBonus = performanceBonus;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + performanceBonus;
    }

    public void conductMeeting() {
        System.out.println(employeeName + " is conducting a meeting");
    }
}


class PayrollService {

    public void processSalary(Employee employee) {

        double salary = employee.calculateSalary();

        System.out.println(
                "Processing salary for "
                        + employee.employeeName
                        + ": "
                        + salary
        );
    }
}


public class Inheritance {
    public static void main(String[] args) {
        
        Employee engineer = new SoftwareEngineer("1234", "Ravi", 
                            100000.0, "ravi314cs@gmail.com", 10000);
        double baseSalary = engineer.getBaseSalary();
        double totalSalary = engineer.calculateSalary();

        System.out.println(engineer.employeeName + "\nBase salary: " + baseSalary + "\nTotal Salary: " + totalSalary + "\n");

        Employee manager = new Manager("12345", "Deepak", 
                            400000.0, "deeepak314cs@gmail.com", 100000);
        //System.out.println();
        baseSalary = manager.getBaseSalary();
        totalSalary = manager.calculateSalary();
        System.out.println(manager.employeeName + "\nBase salary: " + baseSalary + "\nTotal Salary: " + totalSalary + "\n");

        PayrollService payroll = new PayrollService();

        payroll.processSalary(engineer);
        payroll.processSalary(manager);

    }
}
