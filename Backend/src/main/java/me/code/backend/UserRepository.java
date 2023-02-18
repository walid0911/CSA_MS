package me.code.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Modifying
    @Query("update User u set u.firstName = :firstName, u.lastName = :lastName, u.birthDate = :birthDate where u.usrId = :id")
    void updateUser(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("birthDate") Date birthDate, @Param("id") Integer id);
}
