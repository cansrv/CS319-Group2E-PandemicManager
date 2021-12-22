package dutchChocolates.panMan.appLayer.models.classes;

import dutchChocolates.panMan.appLayer.models.actors.Instructor;
import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.models.actors.TA;

import javax.persistence.*;
import java.util.List;
@Entity
public class Section {

    //Properties

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToMany
    private List<Lecture> lectures;
    @OneToMany
    private List<Student> students;
    @OneToMany
    private List<Instructor> instructors;
    @OneToMany
    private List<TA> TAs;
    @OneToOne
    private Course course;
    private boolean isOnline;
    private int sectionNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //Constructors
    public Section() {
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

    public boolean setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
        return true;
    }

    public List<Student> getStudents() {
        return students;
    }

    public boolean setStudents(List<Student> students) {
        this.students = students;
        return true;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public boolean setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
        return true;
    }

    public List<TA> getTAs() {
        return TAs;
    }

    public boolean setTAs(List<TA> TAs) {
        this.TAs = TAs;
        return true;
    }

    public Course getCourse() {
        return course;
    }

    public boolean setCourse(Course course) {
        this.course = course;
        return true;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public boolean setOnline(boolean online) {
        isOnline = online;
        return true;
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public boolean setSectionNumber(int sectionNumber) {
        this.sectionNumber = sectionNumber;
        return true;
    }

    // Methods

    public boolean addLecture(Lecture lecture) {
        lectures.add(lecture);
        return true;
    }

}
