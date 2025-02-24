package kg.esemp.bir_som_fondu.bir_som_fonduu.repository;

import kg.esemp.bir_som_fondu.bir_som_fonduu.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u WHERE u.phone = :phone")
    Optional<User> getUserPhone(@Param("phone") String phone);

    boolean existsByPhone(String phone);
    boolean existsByPassword(String password);



}
