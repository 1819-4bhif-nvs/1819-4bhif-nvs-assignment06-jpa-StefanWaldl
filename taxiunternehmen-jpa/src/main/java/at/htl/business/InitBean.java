package at.htl.business;
import at.htl.persistence.entity.*;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class InitBean {

    @PersistenceContext
    EntityManager em;


    public void init(@Observes @Initialized(ApplicationScoped.class) Object init){
        Boss b1 = new Boss("Christian", "Street 1", LocalDate.now().minusYears(2), 3000.0);

        Employee employee1 = new Employee("Lukas", "Street 2", LocalDate.now().minusYears(3), 3000.0);
        Employee employee2 = new Employee("Marcel", "Street 3", LocalDate.now().minusYears(3), 3000.0);
        Employee employee3 = new Employee("Felix", "Street 4", LocalDate.now().minusYears(3), 3000.0);
        List<Employee> employees = new LinkedList<Employee>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        Customer customer1 = new Customer("Felix", "Street 5", LocalDate.now().minusYears(10));

        Company company1 = new Company("Company1", b1, employees);

        Car car1 = new Car("Audi A6", 5l);

        Bill bill1 = new Bill(LocalDate.now(), 1.2, 5.0, employee1, customer1, car1);

        em.persist(b1);
        em.persist(employee1);
        em.persist(employee2);
        em.persist(employee3);
        em.persist(customer1);
        em.persist(car1);
        em.persist(bill1);

        //em.persist(company1);
    }
}
