package demo.repository;

import demo.model.Person;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person,Integer> {

    @Query(value = "EXEC SP_PERSON_IN @firstName=?1,@lastName=?2,@mail=?3,@active= ?4 ", nativeQuery = true)
    Person insert(String firstName, String lastName, String email, Boolean active);

    @Transactional
    @Modifying
    @Query(value = "EXEC SP_PERSON_UP @id=?1, @firstName=?2,@lastName=?3,@mail=?4,@active= ?5 ", nativeQuery = true)
    void update(Integer id,String firtsName, String lastName, String email, Boolean active);

    @Transactional
    @Modifying
    @Query(value = "EXEC SP_PERSON_DL  @id=?1", nativeQuery = true)
    void delete(Integer id);

    @Query(value = "EXEC SP_PERSON_BYID_SL @id=:id", nativeQuery = true)
    Person byId(@Param("id") Integer id);

    @Query(value = "EXEC SP_PERSON_ALL_SL", nativeQuery = true)
    List<Person> getList();

}
