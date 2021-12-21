package dutchChocolates.panMan.appLayer.models.mediators;

import dutchChocolates.panMan.appLayer.models.actors.Instructor;
import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.models.actors.TA;
import dutchChocolates.panMan.appLayer.models.classes.Exam;
import dutchChocolates.panMan.appLayer.models.classes.Lecture;
import dutchChocolates.panMan.appLayer.models.classes.Section;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseMediator {
    //Properties
    private static CourseMediator courseMediator = null;


    //Constructors
    private CourseMediator(){}


    //Methods
    public CourseMediator getInstance(){
        if (courseMediator == null) {
            courseMediator = new CourseMediator();
        }
        return courseMediator;
    }

    public List<Student> getRiskyStudents(){
        return new ArrayList<Student>();
    }

    public boolean endExam(Instructor instructor, Exam exam){
        return true;
    }

    public boolean markAbsentees(Exam exam, List<Student> absentees){
        return true;
    }

    public boolean createExam(Instructor instructor, List<Student> attendees, Date date, String examRoom){
        return true;
    }

    public boolean switchToOnline(Lecture lecture, boolean isOnline){
        return true;
    }


}
