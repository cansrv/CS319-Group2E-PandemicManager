package dutchChocolates.panMan.appLayer.models.actors;

import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.covidinformatics.CovidInformation;

import java.util.ArrayList;
import java.util.UUID;

public class Student extends User {
    ArrayList<Class> classes;

    public Student(CovidInformation covidInformation, String userName, String password,
                   UUID identifier, ArrayList<Class> classes) {
        super(covidInformation, userName, password, identifier);
        this.classes = classes;
    }

    public ArrayList<Class> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<Class> classes) {
        this.classes = classes;
    }

    public String getClassInfo(Class searchingClass) {
        return null;
    }

    public void createStudentGroup(Student[] students) {

    }

    public void quitClass(Class searchingClass) {

    }

    @Override
    public CovidInformation getCovidInformation() {
        return super.getCovidInformation();
    }

    @Override
    public void setCovidInformation(CovidInformation covidInformation) {
        super.setCovidInformation(covidInformation);
    }

    @Override
    public String getUserName() {
        return super.getUserName();
    }

    @Override
    public void setUserName(String userName) {
        super.setUserName(userName);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public UUID getIdentifier() {
        return super.getIdentifier();
    }

    @Override
    public void setIdentifier(UUID identifier) {
        super.setIdentifier(identifier);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
