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
    
    public List getSpecifiedItems() {
        String strQuery = "SELECT product.id as pid, product.name, item.price, item.id as itemid, item.pictures "
                + "FROM product JOIN item "
                + "WHERE product.id = item.product_id "
                + "AND category_1 = 200 "
                + "AND category_2 = 2001 "
                + "ORDER BY shelf_time DESC;";

        org.hibernate.Query query = getSession().createSQLQuery(strQuery);
        return query.list();
    }
}
