package at.htl.persistence.entity;

import at.htl.rest.dto.BossDto;
import at.htl.rest.dto.CarDto;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@NamedQueries({
        @NamedQuery(name="Car.getAll", query = "select car from Car car"),
        @NamedQuery(name="Car.getById", query = "select car from Car car where car.id = :id")
})
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private Long seats;

    //region Constructors
    public Car() {
    }

    public Car(String type, Long seats) {
        this.type = type;
        this.seats = seats;
    }
    //endregion

    public CarDto toDto(){
        CarDto dto = new CarDto();
        dto.setId(this.getId());
        if(this.getType() != null)
            dto.setType(this.getType());
        if(this.getSeats() != null)
            dto.setSeats(this.getSeats());
        return dto;
    }

    public void update(CarDto carDto) {
        if(carDto.getType() != null)
            this.type = carDto.getType();
        if(carDto.getSeats() != null)
            this.seats = carDto.getSeats();
    }

    //region Getter and Setter
    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getSeats() {
        return seats;
    }

    public void setSeats(Long seats) {
        this.seats = seats;
    }
    //endregion
}
