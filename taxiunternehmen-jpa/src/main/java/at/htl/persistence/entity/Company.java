package at.htl.persistence.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@NamedQueries({
        @NamedQuery(name="Company.getAll", query = "select company from Company company"),
        @NamedQuery(name="Company.getById", query = "select company from Company company where company.id = :id")
})
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    private Boss boss;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Employee> employees;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Customer> customers;


    //region Constructors
    public Company() {
    }

    public Company(String name, Boss boss, List<Employee> employees) {
        this.name = name;
        this.boss = boss;
        this.employees = employees;
    }

    //endregion

    //region Getter and Setter
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
    //endregion
}
