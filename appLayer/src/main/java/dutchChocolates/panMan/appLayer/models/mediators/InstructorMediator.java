package dutchChocolates.panMan.appLayer.models.mediators;

import dutchChocolates.panMan.appLayer.models.actors.Instructor;
import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.models.classes.*;
import dutchChocolates.panMan.appLayer.models.messages.MessageType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InstructorMediator {
    //Properties
    private static InstructorMediator instructorMediator = null;

    //Constructors
    private InstructorMediator() {
    }

    //Methods
    public static InstructorMediator getInstance() {
        if (instructorMediator == null) {
            instructorMediator = new InstructorMediator();
        }
        return instructorMediator;
    }

    public List<Student> getRiskyStudents(Instructor instructor, Course course) {
        if (!course.getInstructors().contains(instructor))
            return null;
        ArrayList<Student> riskyStudents = new ArrayList<>();
        for (Section section: course.getSections()) {
            riskyStudents.addAll(SectionMediator.getInstance().getRiskyStudents(section));
        }
        return riskyStudents;
    }

    public List<Student> getRiskyStudents(Instructor instructor, Section section) {
        if (!section.getInstructors().contains(instructor))
            return null;
        return SectionMediator.getInstance().getRiskyStudents(section);
    }

    public boolean cancelClass(Instructor instructor, Course course) {
        if(!course.getInstructors().contains(instructor)){
            return false;
        }
        for(Section section : course.getSections()){
            section.setOnline(true);
        }
        return true;
    }

    public boolean cancelClass(Instructor instructor, Section section) {
        if(!section.getInstructors().contains(instructor)){
            return false;
        }
        section.setOnline(true);
        return true;
    }

    public boolean createExam(Instructor instructor, List<Student> attendees, Date date, String examRoom, Course course) {
        if(!course.getInstructors().contains(instructor)){
            return false;
        }
        CourseMediator courseMediator = CourseMediator.getInstance();
        for(Exam exam : course.getExams()){
            courseMediator.createExam(instructor, attendees, date, examRoom, course);
        }
        return true;
    }

    public boolean endExam(Instructor instructor, Exam exam, Course course) {
        if(!exam.getCourseCoordinator().equals(instructor) || !course.getInstructors().contains(instructor)){
            return false;
        }
        CourseMediator courseMediator = CourseMediator.getInstance();
        for(Exam examHolder : course.getExams()){
            if(examHolder.equals(exam)){
                courseMediator.endExam(instructor, exam, course);
            }
        }
        return true;
    }

    public boolean enterAbsentees(Instructor instructor, Exam exam, List<Student> absentees) {
        if(!exam.getCourseCoordinator().equals(instructor)){
            return false;
        }
        ExamMediator em = ExamMediator.getInstance();
        em.markAbsentees(exam, absentees);
        return true;
    }

    public boolean switchToOnline(Instructor instructor, Course course, boolean isOnline) {
        if(!course.getInstructors().contains(instructor)){
            return false;
        }
        for(Section section : course.getSections()){
            section.setOnline(isOnline);
        }
        return true;
    }

    public boolean switchToOnline(Instructor instructor, Section section, boolean isOnline) {
        if(!section.getInstructors().contains(instructor)){
            return false;
        }
        section.setOnline(isOnline);
        return true;
    }

    public boolean sendMessage(MessageType messageType, List<String> destinationAddress, String body, String header) {
        // TODO: Called during specific time intervals
        return true;
    }

}
