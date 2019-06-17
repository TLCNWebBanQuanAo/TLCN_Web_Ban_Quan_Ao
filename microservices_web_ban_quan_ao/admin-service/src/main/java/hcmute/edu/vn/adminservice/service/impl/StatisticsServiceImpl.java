package hcmute.edu.vn.adminservice.service.impl;

import hcmute.edu.vn.adminservice.model.Product;
import hcmute.edu.vn.adminservice.repository.Product_Repository;
import hcmute.edu.vn.adminservice.service.StatisticsService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    private Product_Repository product_repository;

    @Override
    public List<Product> statisticsProduct(Date dateStart, Date dateEnd) {
        System.out.println(dateStart + " " + dateEnd);
        return product_repository.findBillsBetweenTwoDate(dateStart, dateEnd);
    }

}
