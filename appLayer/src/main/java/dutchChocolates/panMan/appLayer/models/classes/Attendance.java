package dutchChocolates.panMan.appLayer.models.classes;

import dutchChocolates.panMan.appLayer.models.actors.Student;

import javax.persistence.*;
import java.time.Clock;
import java.util.Date;
import java.util.List;
@Entity
public class Attendance {
    //Properties
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)    private Long id;
    @OneToMany
    private List<Student> students;

    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //Constructors
    public Attendance() {
    }

    public Attendance(List<Student> students) {
        this.students = students;
        this.date = Date.from(Clock.systemDefaultZone().instant());
    }

    public Attendance(List<Student> students, Date date) {
        this.students = students;
        this.date = date;
    }


    //Methods
    public List<Student> getStudents() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
