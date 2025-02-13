package likeherotozero;

import javax.persistence.*;

@Entity
@Table(name = "CO2_EMISSION")
public class CO2Emission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;


    private Integer yearValue;


    private Double emission;

    public CO2Emission() {
    }


    public CO2Emission(String country, Integer yearValue, Double emission) {
        this.country = country;
        this.yearValue = yearValue;
        this.emission = emission;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getYearValue() {
        return yearValue;
    }
    public void setYearValue(Integer yearValue) {
        this.yearValue = yearValue;
    }

    public Double getEmission() {
        return emission;
    }
    public void setEmission(Double emission) {
        this.emission = emission;
    }
}
