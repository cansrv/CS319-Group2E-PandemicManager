package dutchChocolates.panMan.appLayer.models.mediators;

import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.actors.Instructor;
import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.models.actors.TA;
import dutchChocolates.panMan.appLayer.models.classes.Course;
import dutchChocolates.panMan.appLayer.models.classes.Exam;
import dutchChocolates.panMan.appLayer.models.classes.Section;
import dutchChocolates.panMan.appLayer.models.covidInformatics.CovidStatus;
import dutchChocolates.panMan.appLayer.models.messages.Message;
import dutchChocolates.panMan.appLayer.models.messages.MessageType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TAMediator {

    private static TAMediator taMediator = null;

    private TAMediator() {
    }

    public static TAMediator getInstance() {
        if (taMediator == null) {
            taMediator = new TAMediator();
        }
        return taMediator;
    }

    public List<Student> getRiskyStudents(TA ta, Course course) {
        if (!course.getTAs().contains(ta))
            return null;
        ArrayList<Student> riskyStudents = new ArrayList<>();
        for (Section section: course.getSections()) {
            riskyStudents.addAll(SectionMediator.getInstance().getRiskyStudents(section));
        }
        return riskyStudents;
    }

    public List<Student> getRiskyStudents(TA ta, Section section) {
        if (!section.getTAs().contains(ta))
            return null;
        return SectionMediator.getInstance().getRiskyStudents(section);
    }

    public boolean enterAbsentees(TA ta, Exam exam, List<Student> absentees) {

        return exam.removeAbsents(absentees);
    }

    public boolean sendMessage(MessageType messageType, List<String> destinationAddress, String body, String header) {
        return MessageMediator.getInstance().sendMessage(new Message(messageType, destinationAddress, body, header));
    }


}
