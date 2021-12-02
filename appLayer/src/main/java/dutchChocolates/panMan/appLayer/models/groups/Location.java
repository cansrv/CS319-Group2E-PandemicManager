package dutchChocolates.panMan.appLayer.models.groups;

public class Location {

    int capacity;
    int userNumber;
    String locationName;

    public Location(int capacity, int userNumber, String locationName) {
        this.capacity = capacity;
        this.userNumber = userNumber;
        this.locationName = locationName;
    }

    public Location() {}

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
