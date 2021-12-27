package dutchChocolates.panMan.appLayer.repositories;

import dutchChocolates.panMan.appLayer.models.classes.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories

public interface LectureRepository extends JpaRepository<Lecture, Long> {
    //Properties


    //Constructors


    //Methods



}
