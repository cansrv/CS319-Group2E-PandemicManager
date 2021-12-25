package dutchChocolates.panMan.appLayer.models.mediators;

import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.models.classes.Course;
import dutchChocolates.panMan.appLayer.models.classes.Lecture;
import dutchChocolates.panMan.appLayer.models.classes.Section;

import java.util.ArrayList;
import java.util.List;

public class SectionMediator {

    private static SectionMediator sectionMediator = null;


    //Constructors
    private SectionMediator() {
    }


    //Methods
    public static SectionMediator getInstance() {
        if (sectionMediator == null) {
            sectionMediator = new SectionMediator();
        }
        return sectionMediator;
    }

    public List<Student> getRiskyStudents(Section section) {

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

    public boolean setOnline(Section section, boolean isOnline) {
        section.setOnline(isOnline);
        return true;
    }

    public boolean cancelClass(Section section) {
        // TODO: Send Message when a class is cancelled
        section.setOnline(true);
        return true;
    }

    public boolean addLecture(Section section, Lecture lecture) {
        // TODO: Add start & end times during initialization (if lecture is online, do not log)
        return true;
    }
}
