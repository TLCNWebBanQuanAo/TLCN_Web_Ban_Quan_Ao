package hcmute.edu.vn.adminservice.repository;

import hcmute.edu.vn.adminservice.model.Type;
import hcmute.edu.vn.adminservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface User_Repository extends JpaRepository<User, Integer> {
    Optional<User> findById(int Id);
    List<User> findAll();
}
