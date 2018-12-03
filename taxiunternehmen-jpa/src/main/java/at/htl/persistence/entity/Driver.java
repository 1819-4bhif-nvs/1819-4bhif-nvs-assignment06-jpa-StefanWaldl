package at.htl.persistence.entity;


import at.htl.persistence.dao.CarDao;
import at.htl.rest.dto.BossDto;
import at.htl.rest.dto.CarDto;
import at.htl.rest.dto.DriverDto;

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
    private Car car;

    //region Constructor
    public Driver(String name, Double salary, Car car, List<Company> companies) {
        super(name, salary, companies);
        this.car = car;
    }
    //endregion

    public DriverDto toDto(){
        DriverDto dto = new DriverDto();
        dto.setId(this.getId());
        if(this.getName() != null)
            dto.setName(this.getName());
        if(this.getSalary() != null)
            dto.setSalary(this.getSalary());
        if(this.getCar() != null)
            dto.setCarId(this.car.getId());
        return dto;
    }

    public void update(DriverDto driverDto, CarDao carDao) {
        if(driverDto.getCarId() != null)
            carDao.update(carDao.getById(driverDto.getCarId()));
    }

    //region Getter and Setter
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    //endregion
}
