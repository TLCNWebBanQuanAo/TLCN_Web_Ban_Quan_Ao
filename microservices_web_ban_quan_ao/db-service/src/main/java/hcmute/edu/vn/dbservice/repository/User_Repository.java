package hcmute.edu.vn.dbservice.repository;

import hcmute.edu.vn.dbservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface User_Repository extends JpaRepository<User, Long> {
}
