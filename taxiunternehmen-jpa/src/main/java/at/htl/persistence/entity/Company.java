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
    private Boss boss;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Person> employee;

    //region Constructors
    public Company() {
    }

    public Company(String name, Boss boss, List<Person> employee) {
        this.name = name;
        this.boss = boss;
        this.employee = employee;
    }

    //endregion

    public CompanyDto toDto(){
        CompanyDto dto = new CompanyDto();
        dto.setId(this.getId());
        if(this.getName() != null)
            dto.setName(this.getName());
        if(this.getBoss() != null)
            dto.setBossId(this.boss.getId());
        return dto;
    }

    public void update(CompanyDto companyDto, BossDao bossDao) {
        if(companyDto.getBossId() != null)
            this.setBoss(bossDao.getById(companyDto.getBossId()));
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

    public List<Person> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Person> employee) {
        this.employee = employee;
    }

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }
    //endregion
}
