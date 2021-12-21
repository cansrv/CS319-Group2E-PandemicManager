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

    public List<Student> getRiskyStudents(Instructor instructor, Section section) {
        if (!section.getInstructors().contains(instructor))
            return null;
        ArrayList<Student> toBeReturned = new ArrayList<>();
        ArrayList<Student> risky = new ArrayList<>();
        ArrayList<Student> marked = new ArrayList<>();
        ArrayList<Student> positive = new ArrayList<>();
        for (Student student : section.getStudents()) {
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

    public boolean createExam(Instructor instructor, List<Student> attendees, Date date, String examRoom) {
        return true;
    }

    public boolean endExam(Instructor instructor, Exam exam) {
        return true;
    }

    public boolean enterAbsentees(Instructor instructor, Exam exam, List<Student> absentees) {
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
        return true;
    }

}
