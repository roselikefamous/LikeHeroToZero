package likeherotozero;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

@Named("publicView")
@RequestScoped
public class PublicViewBean {

    private String country;
    private List<CO2Emission> emissions;


    private CO2EmissionService emissionService = new CO2EmissionService();

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }


    public List<CO2Emission> getEmissions() {
        return emissions;
    }


    public String loadEmissions() {

        emissions = emissionService.findAllForCountry(country);


        return null;

    }
}
