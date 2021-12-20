package dutchChocolates.panMan.appLayer.models.classes;

import dutchChocolates.panMan.appLayer.models.actors.Student;

import java.util.Date;
import java.util.List;

public class Attendance extends Lecture{
    //Properties
    private List<Student> students;
    private Date date;

    //Constructors
    public Attendance(){}

    public Attendance(List<Student> students, Date date){
        this.students = students;
        this.date = date;
    }

    //Methods
    @Override
    public List<Student> getStudents() {
        return this.students;
    }

    @Override
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
