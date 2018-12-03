package at.htl.rest.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CarDto {
    private Long id;
    private String type;
    private Long seats;

    //region Constructors
    public CarDto() {
    }

    public CarDto(Long id, String type, Long seats) {
        this.id = id;
        this.type = type;
        this.seats = seats;
    }
    //endregion


    //region Getter and Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
