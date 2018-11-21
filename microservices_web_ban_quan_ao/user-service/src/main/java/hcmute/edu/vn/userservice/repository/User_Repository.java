package hcmute.edu.vn.userservice.repository;

import hcmute.edu.vn.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface User_Repository extends JpaRepository<User, Long> {
    Optional<User> FindByAccountNameAndPassword(String accountname, String password);
    Optional<User> FindByAccountName(String accountname);
}
