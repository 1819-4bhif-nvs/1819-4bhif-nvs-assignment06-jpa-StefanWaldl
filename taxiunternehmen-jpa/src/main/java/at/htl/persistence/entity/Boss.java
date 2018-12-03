package at.htl.persistence.entity;

import at.htl.persistence.dao.BossDao;
import at.htl.rest.dto.BossDto;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.sql.Timestamp;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name="Boss.getAll", query = "select boss from Boss boss"),
        @NamedQuery(name="Boss.getById", query = "select boss from Boss boss where boss.id = :id")
})
public class Boss extends Person{

    private Timestamp promotionToBoss;

    //region Constructors
    public Boss() {
    }

    public Boss(String name, Double salary, List<Company> companies, Timestamp promotionToBoss) {
        super(name, salary, companies);
        this.promotionToBoss = promotionToBoss;
    }
    //endregion

    public BossDto toDto(){
        BossDto dto = new BossDto();
        dto.setId(this.getId());
        if(this.getName() != null)
            dto.setName(this.getName());
        if(this.getSalary() != null)
            dto.setSalary(this.getSalary());
        if(this.getPromotionToBoss() != null)
            dto.setPromotionToBoss(this.getPromotionToBoss());
        return dto;
    }

    public void update(BossDto bossDto) {
        if(bossDto.getPromotionToBoss() != null)
            this.promotionToBoss = bossDto.getPromotionToBoss();
    }

    //region Getter and Settter
    public Timestamp getPromotionToBoss() {
        return promotionToBoss;
    }

    public void setPromotionToBoss(Timestamp promotionToBoss) {
        this.promotionToBoss = promotionToBoss;
    }
    //endregion
}
