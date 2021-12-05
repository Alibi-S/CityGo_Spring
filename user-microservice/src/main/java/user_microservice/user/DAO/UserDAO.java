package user_microservice.user.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import user_microservice.user.model.User;

import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
    Optional<User> findUsersByName(String name);
    Optional<User> findUsersByEmail(String email);
}
