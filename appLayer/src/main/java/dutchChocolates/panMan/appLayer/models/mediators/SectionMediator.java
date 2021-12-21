package dutchChocolates.panMan.appLayer.models.mediators;

import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.models.classes.Course;
import dutchChocolates.panMan.appLayer.models.classes.Lecture;
import dutchChocolates.panMan.appLayer.models.classes.Section;

import java.util.List;

public class SectionMediator {

    private static SectionMediator sectionMediator = null;


    //Constructors
    private SectionMediator(){}


    //Methods
    public static SectionMediator getInstance(){
        if (sectionMediator == null) {
            sectionMediator = new SectionMediator();
        }
        return sectionMediator;
    }

    public List<Student> getRiskyStudents(Section section) {
        return null;
    }

    public boolean setOnline(Section section, boolean isOnline) {
        return true;
    }

    public boolean cancelClass(Section section) {
        return true;
    }

    public boolean addLecture(Section section, Lecture lecture) {
        return true;
    }
}
