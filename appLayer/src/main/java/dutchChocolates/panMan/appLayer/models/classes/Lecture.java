package dutchChocolates.panMan.appLayer.models.classes;

import dutchChocolates.panMan.appLayer.models.actors.Instructor;
import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.models.actors.TA;

import javax.persistence.*;

@Entity
public class Lecture {
    //Properties
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)    private Long id;
    private String roomName;
    private boolean isSpareHour;
    @OneToOne
    private Attendance attendance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //Constructors
    public Lecture() {
    }

    public Lecture(String roomName, boolean isSpareHour, Attendance attendance) {

        this.roomName = roomName;
        this.isSpareHour = isSpareHour;
        this.attendance = attendance;
    }
    //Methods
    public String getRoomName() {
        return roomName;
    }

    public boolean setRoomName(String roomName) {
        this.roomName = roomName;
        return true;
    }

    public boolean isSpareHour() {
        return isSpareHour;
    }

    public boolean setSpareHour(boolean spareHour) {
        isSpareHour = spareHour;
        return true;
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public boolean setAttendance(Attendance attendance) {
        this.attendance = attendance;
        return true;
    }
}
