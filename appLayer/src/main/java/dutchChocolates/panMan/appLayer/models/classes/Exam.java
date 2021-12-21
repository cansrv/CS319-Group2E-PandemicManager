package dutchChocolates.panMan.appLayer.models.classes;

import dutchChocolates.panMan.appLayer.models.actors.Instructor;
import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.models.actors.TA;

import java.time.Clock;
import java.util.Date;
import java.util.List;

public class Exam extends Lecture {
    //Properties
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

}
