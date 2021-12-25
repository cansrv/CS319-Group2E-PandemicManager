package dutchChocolates.panMan.appLayer.models.classes;

import dutchChocolates.panMan.appLayer.models.actors.Instructor;
import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.models.actors.TA;


import javax.persistence.*;
import java.util.List;
@Entity
public class Course {
    //Properties

    @OneToMany(cascade = CascadeType.ALL)
    private List<Exam> exams;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Section> sections;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Student> students;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Instructor> instructors;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<TA> TAs;
    @Id
    private String courseName;



    //Constructors
    public Course() {
    }

    public Course(List<Exam> exams, List<Section> sections, List<Student> students, List<Instructor> instructors, List<TA> TAs, String courseName) {
        this.exams = exams;
        this.sections = sections;
        this.students = students;
        this.instructors = instructors;
        this.TAs = TAs;
        this.courseName = courseName;
    }

    //Methods
    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


}
