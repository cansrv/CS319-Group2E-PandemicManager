package dutchChocolates.panMan.appLayer.repositories;

import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.actors.Instructor;
import dutchChocolates.panMan.appLayer.models.actors.TA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InstructorRepository extends JpaRepository<Instructor, String> {
    //Properties


    //Constructors


    //Methods

    @Query("select i from Instructor i where i.fullName = :#{#name}")
    Instructor findInstructorByFullName(@Param("name") String name);



    @Query("select i from Instructor i where i.id = :#{#id}")
    Instructor findInstructorByBilkentID(@Param("id") String id);

}
