package at.htl.persistence.entity;

import at.htl.persistence.dao.BossDao;
import at.htl.rest.dto.CompanyDto;

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
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Boss> bosses;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Person> employees;

    //region Constructors
    public Company() {
    }

    public Company(String name, List<Boss> bosses, List<Person> employees) {
        this.name = name;
        this.bosses = bosses;
        this.employees = employees;
    }

    //endregion

    public CompanyDto toDto(){
        CompanyDto dto = new CompanyDto();
        dto.setId(this.getId());
        if(this.getName() != null)
            dto.setName(this.getName());
        return dto;
    }

    public void update(CompanyDto companyDto) {
        if(companyDto.getName() != null)
            this.name = companyDto.getName();
    }

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

    public List<Boss> getBosses() {
        return bosses;
    }

    public void setBosses(List<Boss> bosses) {
        this.bosses = bosses;
    }

    public List<Person> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Person> employees) {
        this.employees = employees;
    }

    //endregion
}
