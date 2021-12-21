package dutchChocolates.panMan.appLayer.models.mediators;

import dutchChocolates.panMan.appLayer.models.User;
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

    public List<Student> getRiskyStudents(TA ta, Section section) {
        if (!section.getTAs().contains(ta))
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

    public boolean enterAbsentees(TA ta, Exam exam, List<Student> absentees) {

        return exam.removeAbsents(absentees);
    }

    public boolean sendMessage(MessageType messageType, List<String> destinationAddress, String body, String header) {
        return MessageMediator.getInstance().sendMessage(new Message(messageType, destinationAddress, body, header));
    }


}
