package dutchChocolates.panMan.appLayer.models.groups;


import javax.persistence.*;

@Entity
public class Location {
    //Properties
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private String location;



    //Constructors
    public Location() {
    }

    public Location(String location) {
        this.location = location;
    }

    //Methods
    public String getLocation() {
        return location;
    }

    public void setLocation(String name) {
        this.location = name;
    }

    @Override
    public String toString() {
        return "{" + "\n" +
                "   name='" + '\"' + location + '\"' + "\n" +
                '}';
    }
}
