package dutchChocolates.panMan.appLayer.models.groups;


import javax.persistence.*;

@Entity
public class Location {
    //Properties
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private String name;



    //Constructors
    public Location() {
    }

    public Location(String name) {
        this.name = name;
    }

    //Methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
