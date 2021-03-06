package hcmute.edu.vn.userservice.repository;

import hcmute.edu.vn.userservice.model.Bill;
import hcmute.edu.vn.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface Bill_Repository extends JpaRepository<Bill, Integer>  {
    Optional<Bill> findById(int id);
    List<Bill> findAllByUser(User user);
    @Query(value = "SELECT us.id, us.name, us.email, bi.address, bi.phone, bi.date_create, bi.id AS bill_id " +
                    "FROM users us JOIN bills bi " +
                    "ON bi.user_id = us.id", nativeQuery = true)
    List<Object[]> getAllOrder();
}