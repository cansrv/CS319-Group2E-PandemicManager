package dutchChocolates.panMan.appLayer.repositories;

import dutchChocolates.panMan.appLayer.models.classes.Course;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories

public interface CourseRepository extends JpaRepository<Course, String> {
    //Properties


    //Constructors


    //Methods





}
