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
    @ManyToOne
    private Instructor courseCoordinator;




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
        return "{" +
                "id:" + super.getId() +
                ", courseCoordinator:" + courseCoordinator +
                '}';
    }
}
