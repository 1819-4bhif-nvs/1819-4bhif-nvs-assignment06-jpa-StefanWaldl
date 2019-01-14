package at.htl.persistence.entity;


import at.htl.persistence.dao.CarDao;
import at.htl.rest.dto.BossDto;
import at.htl.rest.dto.CarDto;
import at.htl.rest.dto.DriverDto;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name="Driver.getAll", query = "select driver from Driver driver"),
        @NamedQuery(name="Driver.getById", query = "select driver from Driver driver where driver.id = :id")
})
public class Driver extends Person {
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Car> cars;

    //region Constructor
    public Driver(String name, Double salary, List<Car> cars, List<Company> companies) {
        super(name, salary, companies);
        this.cars = cars;
    }

    public Driver() {
    }
    //endregion

    public DriverDto toDto(){
        DriverDto dto = new DriverDto();
        dto.setId(this.getId());
        if(this.getName() != null)
            dto.setName(this.getName());
        if(this.getSalary() != null)
            dto.setSalary(this.getSalary());
        return dto;
    }

    public void update(DriverDto driverDto, CarDao carDao) {
        if(driverDto.getCarId() != null)
            carDao.update(carDao.getById(driverDto.getCarId()));
    }

    //region Getter and Setter

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    //endregion
}
