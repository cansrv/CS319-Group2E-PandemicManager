package dutchChocolates.panMan.appLayer.repositories;

import dutchChocolates.panMan.appLayer.models.User;
import dutchChocolates.panMan.appLayer.models.actors.Staff;
import dutchChocolates.panMan.appLayer.models.actors.TA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories

public interface StaffRepository extends JpaRepository<Staff, String> {
    //Properties


    //Constructors


    //Methods
    @Query("select s from Staff s where s.fullName = :#{#name}")
    Staff findStaffByFullName(@Param("name") String name);



    @Query("select s from Staff s where s.id = :#{#id}")
    Staff findStaffByBilkentID(@Param("id") String id);


}
