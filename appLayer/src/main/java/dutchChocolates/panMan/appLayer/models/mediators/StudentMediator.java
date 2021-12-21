package dutchChocolates.panMan.appLayer.models.mediators;

import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.models.classes.Section;
import dutchChocolates.panMan.appLayer.models.covidInformatics.CovidStatus;

import java.util.List;

public class StudentMediator {

    private static StudentMediator studentMediator = null;

    private StudentMediator() {
    }

    public static StudentMediator getInstance() {
        if (studentMediator == null) {
            studentMediator = new StudentMediator();
        }
        return studentMediator;
    }

    public boolean getRiskyStudents(Student student) {
        for (Section section: student.getSections()) {
            if(SectionMediator.getInstance().getRiskyStudents(section).size() != 0)
                return true;
        }
        return false;
    }
}
