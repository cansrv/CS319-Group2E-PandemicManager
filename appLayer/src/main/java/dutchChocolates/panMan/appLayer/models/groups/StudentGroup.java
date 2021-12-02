package dutchChocolates.panMan.appLayer.models.groups;

import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.actors.Student;
import dutchChocolates.panMan.appLayer.models.courses.Schedule;

import java.util.ArrayList;
import java.util.UUID;

public class StudentGroup extends Group {
    public StudentGroup() {
    }

    public StudentGroup(UUID identifier, User creator, ArrayList<User> participants, Schedule schedule) {
        super(identifier, creator, participants, schedule);
    }

    @Override
    public UUID getIdentifier() {
        return super.getIdentifier();
    }

    @Override
    public void setIdentifier(UUID identifier) {
        super.setIdentifier(identifier);
    }

    @Override
    public User getCreator() {
        return super.getCreator();
    }

    @Override
    public void setCreator(User creator) {
        super.setCreator(creator);
    }

    @Override
    public ArrayList<User> getParticipants() {
        return super.getParticipants();
    }

    @Override
    public void setParticipants(ArrayList<User> participants) {
        super.setParticipants(participants);
    }

    @Override
    public Schedule getSchedule() {
        return super.getSchedule();
    }

    @Override
    public void setSchedule(Schedule schedule) {
        super.setSchedule(schedule);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
