package dutchChocolates.panMan.appLayer.models.classes;

import dutchChocolates.panMan.appLayer.models.actors.Student;

import java.sql.Time;
import java.time.Clock;
import java.util.Date;
import java.util.List;

public class Attendance {
    //Properties
    private List<Student> students;
    private Date enteranceDate;
    private Date endingDate;

    //Constructors
    public Attendance() {
    }

    public Attendance(List<Student> students) {
        this.students = students;
        this.enteranceDate = Date.from(Clock.systemDefaultZone().instant());
    }

    public Attendance(List<Student> students, Date date) {
        this.students = students;
        this.enteranceDate = date;
    }


    //Methods
    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Date getDate() {
        return this.enteranceDate;
    }

    public void setDate(Date date) {
        this.enteranceDate = date;
    }


    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

}
