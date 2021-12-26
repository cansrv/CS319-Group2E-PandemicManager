package dutchChocolates.panMan.appLayer.models.covidInformatics;


import javax.persistence.*;
import java.util.Date;
@Entity
public class Test {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    Date testDate;
    TestType testType;
    ResultType resultType;
    VariantType variantType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Constructors

    public Test(Date testDate, TestType testType, ResultType resultType, VariantType variantType) {
        this.testDate = testDate;
        this.testType = testType;
        this.resultType = resultType;
        this.variantType = variantType;
    }

    public Test(Date testDate, TestType testType) {
        this.testDate = testDate;
        this.testType = testType;
        resultType = ResultType.Pending;
        variantType = null;
    }

    public Test() {}


    // Getters & Setters

    public Date getTestDate() {
        return testDate;
    }

    public boolean setTestDate(Date testDate) {
        this.testDate = testDate;
        return true;

    }

    public TestType getTestType() {
        return testType;
    }

    public boolean setTestType(TestType testType) {
        this.testType = testType;
        return true;

    }

    public ResultType getResultType() {
        return resultType;
    }

    public boolean setResultType(ResultType resultType) {
        this.resultType = resultType;
        return true;

    }

    public VariantType getVariantType() {
        return variantType;
    }

    public boolean setVariantType(VariantType variantType) {
        this.variantType = variantType;
        return true;

    }

    @Override
    public String toString() {
        return "Test{" + "\n" +
                "id=" + "\"" + id + "\"" + ",\n" +
                ", testDate=" + "\"" + testDate + "\"" + ",\n" +
                ", testType=" + "\"" + testType + "\"" + ",\n" +
                ", resultType=" + "\"" + resultType + "\"" + ",\n" +
                ", variantType=" + "\"" + variantType + "\"" + "\n" +
                '}';
    }
}
