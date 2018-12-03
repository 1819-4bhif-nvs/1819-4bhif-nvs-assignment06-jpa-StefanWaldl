package at.htl.rest.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CompanyDto {
    private Long id;
    private String name;
    private Long bossId;


    //region Constructors
    public CompanyDto() {
    }

    public CompanyDto(Long id, String name, Long bossId) {
        this.id = id;
        this.name = name;
        this.bossId = bossId;
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

    public Long getBossId() {
        return bossId;
    }

    public void setBossId(Long bossId) {
        this.bossId = bossId;
    }
    //endregion
}
