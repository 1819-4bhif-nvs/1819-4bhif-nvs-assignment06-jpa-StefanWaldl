package at.htl.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name="Person.getAll", query = "select person from Person person"),
        @NamedQuery(name="Person.getById", query = "select person from Person person where person.id = :id")
})
abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double salary;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Company> companies;

    //region Constructors
    public Person() {
    }

    public Person(String name, Double salary, List<Company> companies) {
        this.name = name;
        this.salary = salary;
        this.companies = companies;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public List<Company> getCompany() {
        return companies;
    }

    public void setCompany(List<Company> companies) {
        this.companies = companies;
    }
    //endregion
}
