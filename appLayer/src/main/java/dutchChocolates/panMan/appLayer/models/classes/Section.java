package dutchChocolates.panMan.appLayer.models.classes;

import dutchChocolates.panMan.appLayer.models.actors.Instructor;
import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.models.actors.TA;

import java.util.List;

public class Section {
    //Properties
    private List<Lecture> lectures;
    private List<Student> students;
    private List<Instructor> instructors;
    private List<TA> TAs;
    private Course course;
    private boolean isOnline;
    private int sectionNumber;

    //Constructors
    public Section(){
    }

    public Section(List<Lecture> lectures, List<Student> students, List<Instructor> instructors, List<TA> TAs, Course course, boolean isOnline, int sectionNumber) {
        this.lectures = lectures;
        this.students = students;
        this.instructors = instructors;
        this.TAs = TAs;
        this.course = course;
        this.isOnline = isOnline;
        this.sectionNumber = sectionNumber;
    }

    //Methods
    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public List<TA> getTAs() {
        return TAs;
    }

    public void setTAs(List<TA> TAs) {
        this.TAs = TAs;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(int sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

}
