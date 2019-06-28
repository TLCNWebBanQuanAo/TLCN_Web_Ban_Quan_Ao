package hcmute.edu.vn.adminservice.repository;

import hcmute.edu.vn.adminservice.model.Bill_Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Bill_Detail_Repository extends JpaRepository<Bill_Detail, Long> {
    @Query(value = "SELECT pr.name, pr.images, bi.price, bi.quantity, bi.size, bi.total " +
                    "FROM bill_detail bi JOIN products pr " +
                    "ON bi.product_id = pr.id WHERE bi.bill_id = ?1", nativeQuery = true)
    List<Object[]> detailBillById(Long bill_id);
}
