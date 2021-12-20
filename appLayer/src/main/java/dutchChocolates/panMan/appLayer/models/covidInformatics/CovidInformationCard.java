package dutchChocolates.panMan.appLayer.models.covidInformatics;

import java.util.Date;
import java.util.List;

public class CovidInformationCard {

    // Attributes
    VaccinationCard vaccinationCard;
    List<Test> tests;
    HESCodeStatus hesCodeStatus;
    List<String> hesCodes;
    CovidStatus covidStatus;

    // Constructors


    public CovidInformationCard(VaccinationCard vaccinationCard, List<Test> tests, HESCodeStatus hesCodeStatus, List<String> hesCodes, CovidStatus covidStatus) {
        this.vaccinationCard = vaccinationCard;
        this.tests = tests;
        this.hesCodeStatus = hesCodeStatus;
        this.hesCodes = hesCodes;
        this.covidStatus = covidStatus;
    }

    public CovidInformationCard(VaccinationCard vaccinationCard, List<Test> tests, List<String> hesCodes) {
        this.vaccinationCard = vaccinationCard;
        this.tests = tests;
        this.hesCodes = hesCodes;
    }

    public CovidInformationCard() {
    }

    // Getters & Setters


    public VaccinationCard getVaccinationCard() {
        return vaccinationCard;
    }

    public boolean setVaccinationCard(VaccinationCard vaccinationCard) {
        this.vaccinationCard = vaccinationCard;
        return true;

    }

    public List<Test> getTests() {
        return tests;
    }

    public boolean setTests(List<Test> tests) {
        this.tests = tests;
        return true;

    }

    public HESCodeStatus getHesCodeStatus() {
        return hesCodeStatus;
    }

    public boolean setHesCodeStatus(HESCodeStatus hesCodeStatus) {
        this.hesCodeStatus = hesCodeStatus;
        return true;

    }

    public List<String> getHesCodes() {
        return hesCodes;
    }

    public boolean setHesCodes(List<String> hesCodes) {
        this.hesCodes = hesCodes;
        return true;

    }

    public CovidStatus getCovidStatus() {
        return covidStatus;
    }

    public boolean setCovidStatus(CovidStatus covidStatus) {
        this.covidStatus = covidStatus;
        return true;

    }

    // Methods

    public boolean addTest(Date testDate, TestType testType) {
        tests.add(new Test(testDate, testType));
        return true;
    }
}
