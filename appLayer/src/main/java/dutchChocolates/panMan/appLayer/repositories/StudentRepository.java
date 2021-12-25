package dutchChocolates.panMan.appLayer.repositories;

import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.actors.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    //Properties


    //Constructors


    //Methods
    

}
