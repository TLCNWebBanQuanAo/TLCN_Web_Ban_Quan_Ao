package hcmute.edu.vn.adminservice.service;

import hcmute.edu.vn.adminservice.model.Product;

import java.util.Date;
import java.util.List;

public interface StatisticsService {
    List<Product> statisticsProduct(Date dateStart, Date dateEnd);
}
