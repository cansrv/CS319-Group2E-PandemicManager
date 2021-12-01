package dutchChocolates.panMan.appLayer.models.covidinformatics;

import java.util.Date;

public class Vaccine {
    String manufacturer;
    Date applicationDate;
    String applicationLocation;
    String type;

    public Vaccine(String manufacturer, Date applicationDate, String applicationLocation, String type) {
        this.manufacturer = manufacturer;
        this.applicationDate = applicationDate;
        this.applicationLocation = applicationLocation;
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getApplicationLocation() {
        return applicationLocation;
    }

    public void setApplicationLocation(String applicationLocation) {
        this.applicationLocation = applicationLocation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
