package hcmute.edu.vn.userservice.repository;

import hcmute.edu.vn.guestservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface User_Repository extends JpaRepository<User, Long> {
}
