package dutchChocolates.panMan.appLayer.repositories;

import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.actors.TA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TARepository extends JpaRepository<TA, String> {
    //Properties




    //Methods

    @Query("select t from TA t where t.fullName = :#{#name}")
    TA findTAByFullName(@Param("name") String name);



    @Query("select t from TA t where t.id = :#{#id}")
    TA findTAByBilkentID(@Param("id") String id);
}
