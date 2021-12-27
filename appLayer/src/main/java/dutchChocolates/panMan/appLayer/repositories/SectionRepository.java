package dutchChocolates.panMan.appLayer.repositories;

import dutchChocolates.panMan.appLayer.models.classes.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories

public interface SectionRepository extends JpaRepository<Section, Long> {
    //Properties


    //Constructors


    //Methods



}
