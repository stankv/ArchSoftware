package Lesson3_1.SRP;

public class EmployeeCalculateSalary {

    private int baseSalary;

    public EmployeeCalculateSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int calculateNetSalary() {
        int tax = (int) (baseSalary * 0.25);
        return baseSalary - tax;
    }
}
