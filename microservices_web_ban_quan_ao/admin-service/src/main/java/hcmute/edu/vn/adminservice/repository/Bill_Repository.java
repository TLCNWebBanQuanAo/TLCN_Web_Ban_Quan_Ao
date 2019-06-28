package hcmute.edu.vn.adminservice.repository;

import hcmute.edu.vn.adminservice.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface Bill_Repository extends JpaRepository<Bill, Integer>  {
    @Query(value = "SELECT us.id, us.name, us.email, bi.address, us.phone, bi.date_create, bi.status, bi.id AS bill_id " +
                    "FROM users us JOIN bills bi " +
                    "ON bi.user_id = us.id", nativeQuery = true)
    List<Object[]> getAllOrder();

    Optional<Bill> findById(int id);
}