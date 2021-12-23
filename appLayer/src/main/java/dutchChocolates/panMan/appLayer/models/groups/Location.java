package dutchChocolates.panMan.appLayer.models.groups;




public class Location {
    //Properties
    private Long id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
