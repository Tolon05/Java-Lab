abstract class Employee {
    String name;
    int id;
    double baseSalary;
    boolean medStr;

    public Employee(String name, int id, double baseSalary, boolean medStr) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
        this.medStr = medStr;
    }

    abstract public double calculateSalary();

    public void displayEmployeeInfo() {
        if (medStr == true) {
            System.out.println("ID: " + id + ", Name: " + name + ", Base Salary: $" + baseSalary + ", Medicine Insuranse: Yes");
        }
        else {
            System.out.println("ID: " + id + ", Name: " + name + ", Base Salary: $" + baseSalary + ", Medicine Insuranse: No");
        }
    }
}

interface Payable {
    public double getPaymentAmount();
}

class FullTimeEmployee extends Employee implements Payable {
    public FullTimeEmployee(String name, int id, double baseSalary, Boolean medStr) {
        super(name, id, baseSalary, medStr);
    }

    @Override
    public double calculateSalary() {
        return baseSalary * 1.2;
    }

    @Override
    public double getPaymentAmount() {
        return calculateSalary();
    }
}

class ContractEmployee extends Employee implements Payable {
    private double perHour;
    private int workedHours;

    public ContractEmployee(String name, int id, double perHour, int workedHours, boolean medStr) {
        super(name, id, 0, medStr);
        this.perHour = perHour;
        this.workedHours = workedHours;
    }

    @Override
    public double calculateSalary() {
        return perHour * workedHours;
    }

    @Override
    public double getPaymentAmount() {
        return calculateSalary();
    }
}

public class Lab2 {
    public static void main(String[] args) {
        Employee e1 = new FullTimeEmployee("Alice Johnson", 101, 5000, true);
        Employee e2 = new ContractEmployee("Bob Smith", 102, 100, 40, false);

        e1.displayEmployeeInfo();
        System.out.println("Total Salary: " + ((Payable) e1).getPaymentAmount() + "\n");

        e2.displayEmployeeInfo();
        System.out.println("Total Salary: " + ((Payable) e2).getPaymentAmount());
    }
}