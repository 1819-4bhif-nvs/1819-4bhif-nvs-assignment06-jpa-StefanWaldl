package at.htl.persistence.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NamedQueries({
        @NamedQuery(name="Person.getAll", query = "select person from Person person"),
        @NamedQuery(name="Person.getById", query = "select person from Person person where person.id = :id")
})
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String street;
    private LocalDate birthday;


    //region Constructors
    public Person() {
    }

    public Person(String name, String street, LocalDate birthday) {
        this.name = name;
        this.street = street;
        this.birthday = birthday;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
    //endregion
}
