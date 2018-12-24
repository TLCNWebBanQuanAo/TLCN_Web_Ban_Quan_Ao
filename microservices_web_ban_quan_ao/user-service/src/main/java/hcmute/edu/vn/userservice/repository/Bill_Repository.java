package hcmute.edu.vn.userservice.repository;

import hcmute.edu.vn.userservice.model.Bill;
import hcmute.edu.vn.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Bill_Repository extends JpaRepository<Bill, Integer>  {
    Optional<Bill> findById(int id);
    List<Bill> findAllByUser(User user);
}
