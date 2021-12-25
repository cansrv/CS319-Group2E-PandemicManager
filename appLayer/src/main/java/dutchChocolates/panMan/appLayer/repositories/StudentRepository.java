package dutchChocolates.panMan.appLayer.repositories;

import dutchChocolates.panMan.appLayer.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;

@Repository
public interface StudentRepository extends JpaRepository<User, String> {
    //Properties


    //Constructors


    //Methods
    @Column(name = "mail")
    @Query
    public User getByMail(String Mail);

}
