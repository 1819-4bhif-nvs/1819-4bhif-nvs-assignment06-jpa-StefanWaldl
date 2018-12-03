package at.htl.rest.dto;

import jdk.jfr.Timespan;

import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;

@XmlRootElement
public class BossDto {
    private Long id;
    private String name;
    private Double salary;
    private Timestamp promotionToBoss;

    //region Constructors
    public BossDto() {
    }

    public BossDto(Long id, String name, Double salary, Timestamp promotionToBoss) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.promotionToBoss = promotionToBoss;
    }

    public BossDto(Timestamp promotionToBoss) {
        this.promotionToBoss = promotionToBoss;
    }
    //endregion


    //region Getter and Setter
    public Timestamp getPromotionToBoss() {
        return promotionToBoss;
    }

    public void setPromotionToBoss(Timestamp promotionToBoss) {
        this.promotionToBoss = promotionToBoss;
    }

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
    //endregion
}
