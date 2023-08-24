package Lesson3_1.SRP;

public class Main {

    public static void main(String[] args) {

        Employee employeeIvanov = new Employee("Ivanov Ivan ", "05.12.1975 ");
        System.out.print(employeeIvanov.getEmpInfo());
        EmployeeCalculateSalary salaryIvanov = new EmployeeCalculateSalary(80000);
        System.out.println("salary: %d".formatted(salaryIvanov.calculateNetSalary()));

        Employee employeePetrov = new Employee("Petrov Petr ", "18.03.1987 ");
        System.out.print(employeePetrov.getEmpInfo());
        EmployeeCalculateSalary salaryPetrov = new EmployeeCalculateSalary(600000);
        System.out.println("salary: %d".formatted(salaryPetrov.calculateNetSalary()));
    }
}
