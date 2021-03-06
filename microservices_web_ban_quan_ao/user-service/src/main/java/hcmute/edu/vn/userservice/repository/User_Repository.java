package hcmute.edu.vn.userservice.repository;

import hcmute.edu.vn.userservice.model.Product;
import hcmute.edu.vn.userservice.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface User_Repository extends JpaRepository<User, Long> {
    Optional<User> findUserByAccountNameAndPassword(String accountName, String password);
    Optional<User> findUserByAccountName(String accountName);
}
