package dutchChocolates.panMan.appLayer.models.mediators;

import dutchChocolates.panMan.appLayer.models.actors.Student;

import java.util.List;

public class StudentMediator {

    private static StudentMediator studentMediator = null;

    private StudentMediator() {}

    public StudentMediator getInstance() {
        if (studentMediator == null) {
            studentMediator = new StudentMediator();
        }
        return studentMediator;
    }

    public List<Student> getRiskyStudents() {
        return null;
    }
}
