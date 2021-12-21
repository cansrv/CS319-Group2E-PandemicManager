package dutchChocolates.panMan.appLayer.models.mediators;

import dutchChocolates.panMan.appLayer.models.actors.Instructor;
import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.models.classes.Course;
import dutchChocolates.panMan.appLayer.models.classes.Exam;
import dutchChocolates.panMan.appLayer.models.classes.Lecture;
import dutchChocolates.panMan.appLayer.models.classes.Section;
import dutchChocolates.panMan.appLayer.models.messages.MessageType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InstructorMediator {
    //Properties
    private static InstructorMediator instructorMediator = null;

    //Constructors
    private InstructorMediator(){}

    //Methods
    public InstructorMediator getInstance(){
        if (instructorMediator == null) {
            instructorMediator = new InstructorMediator();
        }
        return instructorMediator;
    }

    public List<Student> getRiskyStudents(Instructor instructor, Course course){
        return new ArrayList<Student>();
    }

    public List<Student> getRiskyStudents(Instructor instructor, Section section){
        return new ArrayList<Student>();
    }

    public boolean cancelClass(Instructor instructor, Course course){
        return true;
    }

    public boolean cancelClass(Instructor instructor, Section section){
        return true;
    }

    public boolean createExam(Instructor instructor, List<Student> attendees, Date date, String examRoom){
        return true;
    }

    public boolean endExam(Instructor instructor, Exam exam){
        return true;
    }

    public boolean enterAbsentees(Instructor instructor, Exam exam, List<Student> absentees){
        return true;
    }

    public boolean switchToOnline(Instructor instructor, Section section, boolean isOnline){
        return true;
    }

    public boolean switchToOnline(Instructor instructor, Lecture lecture, boolean isOnline){
        return true;
    }

    public boolean sendMessage(MessageType messageType, List<String> destinationAddress, String body, String header){
        return true;
    }

}
