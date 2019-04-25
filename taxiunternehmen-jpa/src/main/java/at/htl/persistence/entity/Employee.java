package at.htl.persistence.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name="Employee.getAll", query = "select employee from Employee employee"),
        @NamedQuery(name="Employee.getById", query = "select employee from Employee employee where employee.id = :id")
})
public class Employee extends Person {

    private Double salary;
    @OneToMany
    private List<Bill> bills;

    public Employee() {
    }

    public Employee(String name, String street, LocalDate birthday, Double salary) {
        super(name, street, birthday);
        this.salary = salary;
        this.bills = new LinkedList<Bill>();
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }
}
