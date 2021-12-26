package dutchChocolates.panMan.appLayer.models.classes;

import dutchChocolates.panMan.appLayer.models.actors.Instructor;
import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.models.actors.TA;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.List;
@Entity
public class Exam extends Lecture {
    //Properties
    private Long id;
    @ManyToOne
    private Instructor courseCoordinator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //Constructors
    public Exam() {
        super();
    }

    public Exam(String roomName, Attendance attendance, Instructor courseCoordinator) {
        super(roomName, false, attendance);
        this.courseCoordinator = courseCoordinator;
    }

    //Methods
    public Instructor getCourseCoordinator() {
        return courseCoordinator;
    }

    public void setCourseCoordinator(Instructor courseCoordinator) {
        this.courseCoordinator = courseCoordinator;
    }

    public boolean removeAbsents(List<Student> students) {
        return true;
    }

    @Override
    public String toString() {
        return "{" + "\n" +
                "   id:" + '\"' + id + '\"' + ",\n" +
                "   courseCoordinator:" + '\"' + courseCoordinator + '\"' + "\n" +
                '}';
    }
}
