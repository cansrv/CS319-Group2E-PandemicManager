package dutchChocolates.panMan.appLayer.models.classes;

import dutchChocolates.panMan.appLayer.models.actors.Instructor;
import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.models.actors.TA;

import java.util.List;

public class Exam extends Lecture{
    //Properties
    private Instructor courseCoordinator;

    //Constructors
    public Exam(){
        super();
    }

    public Exam(List<Lecture> lectures, List<Student> students, List<Instructor> instructors, List<TA> TAs, Course course, boolean isOnline, int sectionNumber, String roomName, boolean isSpareHour, Attendance attendance, Instructor courseCoordinator) {
        super(lectures, students, instructors, TAs, course, isOnline, sectionNumber, roomName, isSpareHour, attendance);
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
