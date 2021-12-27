package dutchChocolates.panMan.appLayer.repositories;

import dutchChocolates.panMan.appLayer.models.Group;
import dutchChocolates.panMan.appLayer.models.classes.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories

public interface GroupRepository extends JpaRepository<Group, Long> {
    //Properties


    //Constructors


    //Methods
}
