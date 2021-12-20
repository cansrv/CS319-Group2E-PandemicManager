package dutchChocolates.panMan.appLayer.models.covidInformatics;

import java.util.Date;

public class Vaccine {

    // Attributes
    String manufacturer;
    Date applicationDate;
    String country;
    String type;
    String medicalProductName;

    // Constructors

    public Vaccine(String manufacturer, Date applicationDate, String country, String type, String medicalProductName) {
        this.manufacturer = manufacturer;
        this.applicationDate = applicationDate;
        this.country = country;
        this.type = type;
        this.medicalProductName = medicalProductName;
    }

    public Vaccine() {
    }

    // Getters & Setters


    public String getManufacturer() {
        return manufacturer;
    }

    public boolean setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return true;

    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public boolean setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
        return true;

    }

    public String getCountry() {
        return country;
    }

    public boolean setCountry(String country) {
        this.country = country;
        return true;

    }

    public String getType() {
        return type;
    }

    public boolean setType(String type) {
        this.type = type;
        return true;

    }

    public String getMedicalProductName() {
        return medicalProductName;
    }

    public boolean setMedicalProductName(String medicalProductName) {
        this.medicalProductName = medicalProductName;
        return true;

    }


}
