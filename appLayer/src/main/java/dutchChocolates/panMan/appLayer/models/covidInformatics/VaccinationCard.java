package dutchChocolates.panMan.appLayer.models.covidInformatics;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
public class VaccinationCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    String firstName;
    String middleName;
    String lastName;
    Date birthDate;
    String personalIdNumber;
    @OneToMany
    List<Vaccine> vaccines;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Constructors

    public VaccinationCard(String firstName, String middleName, String lastName, Date birthDate, String personalIdNumber, List<Vaccine> vaccines) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.personalIdNumber = personalIdNumber;
        this.vaccines = vaccines;
    }

    public VaccinationCard() {
    }

    // Getters & Setters


    public String getFirstName() {
        return firstName;
    }

    public boolean setFirstName(String firstName) {
        this.firstName = firstName;
        return true;

    }

    public String getMiddleName() {
        return middleName;
    }

    public boolean setMiddleName(String middleName) {
        this.middleName = middleName;
        return true;

    }

    public String getLastName() {
        return lastName;
    }

    public boolean setLastName(String lastName) {
        this.lastName = lastName;
        return true;

    }

    public Date getBirthDate() {
        return birthDate;
    }

    public boolean setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
        return true;

    }

    public String getPersonalIdNumber() {
        return personalIdNumber;
    }

    public boolean setPersonalIdNumber(String personalIdNumber) {
        this.personalIdNumber = personalIdNumber;
        return true;

    }

    public List<Vaccine> getVaccines() {
        return vaccines;
    }

    public boolean setVaccines(List<Vaccine> vaccines) {
        this.vaccines = vaccines;
        return true;

    }

    // Methods

    public boolean addVaccine(Vaccine vaccine) {
        vaccines.add(vaccine);
        return true;
    }
}
