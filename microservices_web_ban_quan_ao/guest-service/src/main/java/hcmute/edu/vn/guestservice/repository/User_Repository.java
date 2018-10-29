package hcmute.edu.vn.guestservice.repository;

import hcmute.edu.vn.guestservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface User_Repository extends JpaRepository<User, Long> {
    Optional<User> findByAccountNameAndPassword(String accountname, String password);
    Optional<User> findByAccountName(String accountname);
}
