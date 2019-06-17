package hcmute.edu.vn.adminservice.repository;

import hcmute.edu.vn.adminservice.model.Product;
import hcmute.edu.vn.adminservice.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.Date;

@Repository
public interface Product_Repository extends JpaRepository<Product, Integer> {
    Optional<Product> findById(int Id);
    List<Product> findAll();

    @Query(value = "SELECT pr.id, pr.describe, pr.date_create, pr.date_update, pr.images, pr.size, " +
            "pr.name, pr.price, sum(billd.quantity) as quantity, pr.status, pr.user_create,pr.user_update,pr.type_id " +
            "FROM public.bills bill, public.bill_detail billd,  public.products pr " +
            "where bill.date_create >= ?1 " +
            "and bill.date_create <= ?2 " +
            "and bill.id = billd.bill_id " +
            "and billd.product_id = pr.id group by pr.id", nativeQuery = true)
    List<Product> findBillsBetweenTwoDate(@Param("dateStart") Date dateStart, @Param("dateEnd") Date dateEnd);

}
