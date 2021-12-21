package dutchChocolates.panMan.appLayer.models.mediators;

import dutchChocolates.panMan.appLayer.models.actors.Instructor;
import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.models.classes.Attendance;
import dutchChocolates.panMan.appLayer.models.classes.Exam;

import java.util.Date;
import java.util.List;

public class ExamMediator {
    //Properties
    private static ExamMediator examMediator = null;

    //Constructors
    private ExamMediator() {
    }

    //Methods
    public static ExamMediator getInstance() {
        if (examMediator == null) {
            examMediator = new ExamMediator();
        }
        return examMediator;
    }

    public Exam createExam(Instructor instructor, List<Student> attendees, Date date, String examRoom) {
        return new Exam(examRoom, new Attendance(attendees, date), instructor);
    }

    public boolean endExam(Instructor instructor, Exam exam) {
        return true;
    }

    public boolean markAbsentees(Exam exam, List<Student> absentees) {
        return true;
    }

}
