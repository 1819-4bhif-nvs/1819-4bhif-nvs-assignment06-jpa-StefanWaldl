package at.htl.rest.dto;

import javax.persistence.criteria.CriteriaBuilder;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DriverDto {
    private Long id;
    private String name;
    private Double salary;
    private Long carId;

    //region Constructors
    public DriverDto() {
    }

    public DriverDto(Long id, String name, Double salary, Long carId) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.carId = carId;
    }
    //endregion

    //region Getter and Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }
    //endregion
}
