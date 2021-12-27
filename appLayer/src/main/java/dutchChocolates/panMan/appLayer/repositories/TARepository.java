package dutchChocolates.panMan.appLayer.repositories;

import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.actors.TA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@EnableJpaRepositories

public interface TARepository extends JpaRepository<TA, String> {
    //Properties




    //Methods

    @Query("select t from TA t where t.fullName = :#{#name}")
    TA findTAByFullName(@Param("name") String name);



    @Query("select t from TA t where t.id = :#{#id}")
    TA findTAByBilkentID(@Param("id") String id);
}
