package dutchChocolates.panMan.appLayer.models.covidInformatics;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class CovidInformationCard {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToOne(cascade=CascadeType.ALL)
    VaccinationCard vaccinationCard;
    @OneToMany
    List<Test> tests;
    @ElementCollection
    List<String> hesCodes;
    HESCodeStatus hesCodeStatus;
    CovidStatus covidStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Constructors

    public CovidInformationCard(String hesCode) {
        this.vaccinationCard = null;
        hesCodes = new ArrayList<String>();
        this.hesCodes.add(hesCode);
        this.covidStatus = CovidStatus.Negative;
        this.hesCodeStatus = HESCodeStatus.OK;
        this.tests = new ArrayList<>();
    }

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

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", vaccinationCard:" + vaccinationCard +
                ", tests:" + tests +
                ", hesCodes:" + hesCodes +
                ", hesCodeStatus:" + hesCodeStatus +
                ", covidStatus:" + covidStatus +
                '}';
    }
}
