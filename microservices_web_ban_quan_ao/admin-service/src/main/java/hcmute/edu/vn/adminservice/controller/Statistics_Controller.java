package hcmute.edu.vn.adminservice.controller;
import hcmute.edu.vn.adminservice.api.v1.DataReturnList;
import hcmute.edu.vn.adminservice.api.v1.dto.Product_Dto;
import hcmute.edu.vn.adminservice.api.v1.dto.Statistics_Dto;
import hcmute.edu.vn.adminservice.api.v1.mapper.ProductMapper;
import hcmute.edu.vn.adminservice.model.Product;
import hcmute.edu.vn.adminservice.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("admin/product/statictics")
@CrossOrigin(origins = "http://localhost:4200")
public class Statistics_Controller {
    @Autowired
    private StatisticsService statisticsService;
    @Autowired
    private ProductMapper productMapper;

    @PostMapping("/figures")
    public DataReturnList<Product_Dto> statisticsProduct(@RequestBody Statistics_Dto statisticsDTO){
        DataReturnList<Product_Dto> dataReturnList = new DataReturnList<>();

        List<Product> products = statisticsService.statisticsProduct(statisticsDTO.getDateStart(), statisticsDTO.getDateEnd());
//        if(products.size() == 0){
//            dataReturnList.setMessage("Not Found Product !!!");
//            dataReturnList.setSuccess("false");
//            return dataReturnList;
//        }

        dataReturnList.setData(products.stream().map(productMapper::productToProductDto).collect(Collectors.toList()));
        return dataReturnList;
    }

}
