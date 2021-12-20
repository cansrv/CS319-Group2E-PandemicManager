package dutchChocolates.panMan.appLayer.models.classes;

import dutchChocolates.panMan.appLayer.models.actors.Instructor;
import dutchChocolates.panMan.appLayer.models.actors.Student;

import java.util.List;

public class Exam extends Lecture{
    //Properties
    private Instructor courseCoordinator;

    //Constructors
    public Exam(){}

    public Exam(Instructor courseCoordinator) {
        this.courseCoordinator = courseCoordinator;
    }

    public Exam(String roomName, boolean isSpareHour, Attendance attendance, Instructor courseCoordinator) {
        super(roomName, isSpareHour, attendance);
        this.courseCoordinator = courseCoordinator;
    }

    //Methods
    public Instructor getCourseCoordinator() {
        return courseCoordinator;
    }

    public void setCourseCoordinator(Instructor courseCoordinator) {
        this.courseCoordinator = courseCoordinator;
    }

    public boolean removeAbsents(List<Student> students){
        return true;
    }

}
