package dutchChocolates.panMan.appLayer.models.mediators;

import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.models.actors.TA;
import dutchChocolates.panMan.appLayer.models.classes.Course;
import dutchChocolates.panMan.appLayer.models.classes.Exam;
import dutchChocolates.panMan.appLayer.models.classes.Section;
import dutchChocolates.panMan.appLayer.models.messages.MessageType;

import java.util.List;

public class TAMediator {

    private static TAMediator taMediator = null;

    private TAMediator() {}

    public TAMediator getInstance() {
        if (taMediator == null) {
            taMediator = new TAMediator();
        }
        return taMediator;
    }

    public List<Student> getRiskyStudents(TA ta, Course course) {
        return null;
    }

    public List<Student> getRiskyStudents(TA ta, Section section) {
        return null;
    }

    public boolean enterAbsentees(TA ta, Exam exam, List<Student> absentees) {
        return true;
    }

    public boolean sendMessage(MessageType messageType, List<String> destinationAddress, String body, String header) {
        return true;
    }


}
