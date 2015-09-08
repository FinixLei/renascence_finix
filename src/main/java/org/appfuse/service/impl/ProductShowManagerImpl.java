package org.appfuse.service.impl;
 
import org.appfuse.service.impl.GenericManagerImpl;
import org.appfuse.dao.ProductDao;
import org.appfuse.model.Product;
import org.appfuse.service.ProductShowManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import javax.jws.WebService;
import java.util.List;
 
@Service("productShowManager")
@WebService(serviceName = "ProductService")
public class ProductShowManagerImpl extends GenericManagerImpl<Product, Long> implements ProductShowManager {
    ProductDao productDao;
 
    public ProductShowManagerImpl() {}
 
    @Autowired
    public ProductShowManagerImpl(ProductDao productDao) {
        super(productDao);
        this.productDao = productDao;
    }
 
    public void sayHi() {
        System.out.println("Hi, Renascence!");
    }
}
