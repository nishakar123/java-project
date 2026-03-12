package test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestProgram {
    static void main() {

        List<Employee> employees = Arrays.asList(
                new Employee(1,"nishakar", 20000.00),
                new Employee(2,"subramanyam", 25000.00),
                new Employee(3, "kiran", 350000.00)
        );

        List<String> names = employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).map(Employee::getFirstName).toList();
        System.out.println(names);
    }
}

class Employee{
    private Integer id;
    private String firstName;
    private Double salary;

    public Employee() {
    }

    public Employee(Integer id, String firstName, Double salary) {
        this.id = id;
        this.firstName = firstName;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", salary=" + salary +
                '}';
    }
}