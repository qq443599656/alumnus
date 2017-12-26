package com.xaccp.alumni.dao.impl;
 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.xaccp.alumni.dao.ProductDao;
import com.xaccp.alumni.entity.Product;
 
/**
 * 商品信息-服务层实现
 *
 */
@Repository
public class ProductDaoImpl implements ProductDao {
 
    private HibernateTemplate template;
     
    @Autowired
    public ProductDaoImpl(SessionFactory sessionFactory) {
         
        template = new HibernateTemplate(sessionFactory);
         
    }
 
    @Override
    public void saveProduct(Product product) {
         
        template.save(product);
         
    }
 
}