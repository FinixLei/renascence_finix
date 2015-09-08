package org.appfuse.dao.hibernate;
 
import java.util.List;
 
import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.appfuse.model.Product;
import org.appfuse.dao.ProductDao;
 
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
 
@Repository("productDao")
public class ProductDaoHibernate extends GenericDaoHibernate<Product, Long> implements ProductDao {
 
    public ProductDaoHibernate() {
        super(Product.class);
    }
    
    public int getCategoryOne(Long id) {
        return 100; // getSession().createCriteria(Product.class).add(Restrictions.eq("category_1", id));
    }
}
