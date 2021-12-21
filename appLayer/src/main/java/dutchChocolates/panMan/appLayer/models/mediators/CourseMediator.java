package dutchChocolates.panMan.appLayer.models.mediators;

import dutchChocolates.panMan.appLayer.models.actors.Instructor;
import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.models.actors.TA;
import dutchChocolates.panMan.appLayer.models.classes.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseMediator {
    //Properties
    private static CourseMediator courseMediator = null;


    //Constructors
    private CourseMediator() {
    }


    //Methods
    public static CourseMediator getInstance() {
        if (courseMediator == null) {
            courseMediator = new CourseMediator();
        }
        return courseMediator;
    }

    public List<Student> getRiskyStudents(Course course) {
        ArrayList<Student> toBeReturned = new ArrayList<>();
        ArrayList<Student> risky = new ArrayList<>();
        ArrayList<Student> marked = new ArrayList<>();
        ArrayList<Student> positive = new ArrayList<>();
        for (Student student : course.getStudents()) {
            switch (student.getCovidInformationCard().getCovidStatus()) {
                case Risky:
                    risky.add(student);
                case Marked:
                    marked.add(student);
                case Positive:
                    positive.add(student);
            }
        }
        toBeReturned.addAll(risky);
        toBeReturned.addAll(marked);
        toBeReturned.addAll(positive);
        return toBeReturned;
    }

    public boolean endExam(Instructor instructor, Exam exam, Course course) {
        if (!exam.getCourseCoordinator().equals(instructor))
            return false;
        return course.getExams().remove(exam);

    }

    public boolean markAbsentees(Exam exam, List<Student> absentees) {
        return exam.removeAbsents(absentees);
    }

    public boolean createExam(Instructor instructor, List<Student> attendees, Date date, String examRoom, Course course) {

        return course.getExams().add(ExamMediator.getInstance().createExam(instructor, attendees, date, examRoom));
    }

    public boolean switchToOnline(Course course, boolean isOnline) {
        for (Section s : course.getSections()) {
            s.setOnline(isOnline);
        }
        return isOnline;
    }


}
