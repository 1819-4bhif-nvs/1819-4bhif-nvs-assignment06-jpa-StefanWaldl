package at.htl.persistence.entity;

import at.htl.persistence.dao.BossDao;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name="Boss.getAll", query = "select boss from Boss boss"),
        @NamedQuery(name="Boss.getById", query = "select boss from Boss boss where boss.id = :id")
})
public class Boss extends Person{

    private Double salary;

    //region Constructors
    public Boss() {
    }

    public Boss(String name, String street, LocalDate birthday, Double salary) {
        super(name, street, birthday);
        this.salary = salary;
    }
    //endregion

    //region Getter and Settter

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    //endregion
}
