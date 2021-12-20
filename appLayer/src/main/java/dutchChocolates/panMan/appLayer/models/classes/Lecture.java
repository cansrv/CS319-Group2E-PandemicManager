package dutchChocolates.panMan.appLayer.models.classes;

import dutchChocolates.panMan.appLayer.models.actors.Instructor;
import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.models.actors.TA;

import java.util.List;

public class Lecture extends Section{
    //Properties
    private String roomName;
    private boolean isSpareHour;
    private Attendance attendance;

    //Constructors
    public Lecture(){}

    public Lecture(String roomName, boolean isSpareHour, Attendance attendance) {
        this.roomName = roomName;
        this.isSpareHour = isSpareHour;
        this.attendance = attendance;
    }

    public Lecture(List<Lecture> lectures, List<Student> students, List<Instructor> instructors, List<TA> TAs, Course course, boolean isOnline, int sectionNumber, String roomName, boolean isSpareHour, Attendance attendance) {
        super(lectures, students, instructors, TAs, course, isOnline, sectionNumber);
        this.roomName = roomName;
        this.isSpareHour = isSpareHour;
        this.attendance = attendance;
    }

    //Methods
    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public boolean isSpareHour() {
        return isSpareHour;
    }

    public void setSpareHour(boolean spareHour) {
        isSpareHour = spareHour;
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }
}
