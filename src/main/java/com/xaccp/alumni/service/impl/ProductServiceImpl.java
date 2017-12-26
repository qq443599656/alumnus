package com.xaccp.alumni.service.impl;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xaccp.alumni.dao.ProductDao;
import com.xaccp.alumni.entity.Product;
import com.xaccp.alumni.service.ProductService;
 
@Service
public class ProductServiceImpl implements ProductService {
 
    @Autowired
    private ProductDao productDao;
     
    @Override
    public void saveProduct(Product product) {
 
        productDao.saveProduct(product);
 
    }
 
}