package dutchChocolates.panMan.appLayer.models.mediators;

import dutchChocolates.panMan.appLayer.models.actors.Student;
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
        for (int i = 0; i < student.getSections().size(); i++) {
            for (int j = 0; j < student.getSections().get(i).getStudents().size(); j++)
                if (student.getSections().get(i).getStudents().get(j).getCovidInformationCard().getCovidStatus() != CovidStatus.Negative)
                    return true;
        }
        return false;
    }
}
