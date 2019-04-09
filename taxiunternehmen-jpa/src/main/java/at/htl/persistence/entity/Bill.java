package at.htl.persistence.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@Entity
@NamedQueries({
        @NamedQuery(name="Bill.getAll", query = "select bill from Bill bill"),
        @NamedQuery(name="Bill.getById", query = "select bill from Bill bill where bill.id = :id")
})
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private Double kilometers;
    private Double kilometerPrice;
    private Double finalPrice;
    @ManyToOne
    private Employee driver;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Car car;

    public Bill() {
    }

    public Bill(LocalDate date, Double kilometers, Double kilometerPrice, Employee driver, Customer customer, Car car) {
        this.date = date;
        this.kilometers = kilometers;
        this.kilometerPrice = kilometerPrice;
        this.finalPrice = kilometerPrice*kilometers;
        this.driver = driver;
        this.customer = customer;
        this.car = car;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getKilometers() {
        return kilometers;
    }

    public void setKilometers(Double kilometers) {
        this.kilometers = kilometers;
    }

    public Double getKilometerPrice() {
        return kilometerPrice;
    }

    public void setKilometerPrice(Double kilometerPrice) {
        this.kilometerPrice = kilometerPrice;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Employee getDriver() {
        return driver;
    }

    public void setDriver(Employee driver) {
        this.driver = driver;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
