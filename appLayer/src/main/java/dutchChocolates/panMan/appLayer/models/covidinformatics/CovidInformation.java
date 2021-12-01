package dutchChocolates.panMan.appLayer.models.covidinformatics;

import dutchChocolates.panMan.appLayer.models.covidinformatics.VaccinationCard;

public class CovidInformation {

    // Constructors


    public VaccinationCard getVaccinationCard() {
        return vaccinationCard;
    }

    public void setVaccinationCard(VaccinationCard vaccinationCard) {
        this.vaccinationCard = vaccinationCard;
    }

    // Attributes
    private VaccinationCard vaccinationCard;
    private String diagnosisInfo;
    private String[] testInfo;
    private String hesCodeStatus;
    private boolean campusPermissionStatus;
    private String covidStatus;
    private String testAppoinmentList;
    private String hesCode;


    // Constructor

    public CovidInformation(VaccinationCard vaccinationCard, String diagnosisInfo, String[] testInfo,
                            String hesCodeStatus, boolean campusPermissionStatus, String covidStatus,
                            String testAppoinmentList, String hesCode) {
        this.vaccinationCard = vaccinationCard;
        this.diagnosisInfo = diagnosisInfo;
        this.testInfo = testInfo;
        this.hesCodeStatus = hesCodeStatus;
        this.campusPermissionStatus = campusPermissionStatus;
        this.covidStatus = covidStatus;
        this.testAppoinmentList = testAppoinmentList;
        this.hesCode = hesCode;
    }


    // Operations

    public String getDiagnosisInfo() {
        return diagnosisInfo;
    }

    public void setDiagnosisInfo(String diagnosisInfo) {
        this.diagnosisInfo = diagnosisInfo;
    }

    public String[] getTestInfo() {
        return testInfo;
    }

    public void setTestInfo(String[] testInfo) {
        this.testInfo = testInfo;
    }

    public String getHesCodeStatus() {
        return hesCodeStatus;
    }

    public void updateHesCodeStatus(String hesCodeStatus) {
        this.hesCodeStatus = hesCodeStatus;
    }

    public boolean getCampusPermissionStatus() {
        return campusPermissionStatus;
    }

    public void setCampusPermissionStatus(boolean campusPermissionStatus) {
        this.campusPermissionStatus = campusPermissionStatus;
    }

    public String getCovidStatus() {
        return covidStatus;
    }

    public void setCovidStatus(String covidStatus) {
        this.covidStatus = covidStatus;
    }

    public String getTestAppoinmentList() {
        return testAppoinmentList;
    }

    public void setTestAppoinmentList(String testAppoinmentList) {
        this.testAppoinmentList = testAppoinmentList;
    }

    public String getHesCode() {
        return hesCode;
    }

    public void setHesCode(String hesCode) {
        this.hesCode = hesCode;
    }
}
