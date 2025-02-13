package likeherotozero;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("scientistBean")
@RequestScoped
public class ScientistBean {

    private String country;
    private Integer yearValue;      // umbenannt
    private Double emissionValue;
    private CO2EmissionService emissionService = new CO2EmissionService();

    // Getter & Setter
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

    public Double getEmissionValue() {
        return emissionValue;
    }
    public void setEmissionValue(Double emissionValue) {
        this.emissionValue = emissionValue;
    }


    public String addEmission() {

        CO2Emission newEmission = new CO2Emission(country, yearValue, emissionValue);
        emissionService.addEmission(newEmission);
        return "addEmission?faces-redirect=true";
    }
}
