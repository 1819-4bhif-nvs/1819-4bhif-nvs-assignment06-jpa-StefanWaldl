package at.htl.persistence.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name="Customer.getAll", query = "select customer from Customer customer"),
        @NamedQuery(name="Customer.getById", query = "select customer from Customer customer where customer.id = :id")
})
public class Customer extends Person {
    @OneToMany
    private List<Bill> bills;

    public Customer() {

    }

    public Customer(String name, String street, LocalDate birthday) {
        super(name, street, birthday);
        this.bills = new LinkedList<Bill>();
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }
}
