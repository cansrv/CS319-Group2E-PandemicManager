package dutchChocolates.panMan.appLayer.models;

import dutchChocolates.panMan.appLayer.models.courses.Schedule;

import java.util.ArrayList;
import java.util.UUID;

public abstract class Group {
    UUID identifier;
    User creator;
    ArrayList<User> participants;
    Schedule schedule;

    public Group() {}
    public Group(UUID identifier, User creator, ArrayList<User> participants, Schedule schedule) {
        this.identifier = identifier;
        this.creator = creator;
        this.participants = participants;
        this.schedule = schedule;
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public void setIdentifier(UUID identifier) {
        this.identifier = identifier;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public ArrayList<User> getParticipants() {
        return participants;
    }

    public void setParticipants(ArrayList<User> participants) {
        this.participants = participants;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
