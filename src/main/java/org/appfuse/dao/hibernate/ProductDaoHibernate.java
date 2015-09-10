package org.appfuse.dao.hibernate;
 
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.math.BigInteger;
import java.math.BigDecimal;
 
import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.appfuse.model.Product;
import org.appfuse.model.SelectedItem;
import org.appfuse.dao.ProductDao;
 
import org.hibernate.criterion.Restrictions;
import org.hibernate.SQLQuery;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
 
@Repository("productDao")
public class ProductDaoHibernate extends GenericDaoHibernate<Product, Long> implements ProductDao {
 
    public ProductDaoHibernate() {
        super(Product.class);
    }
    
    public List<SelectedItem> getSpecifiedItems() {
        String strQuery = "SELECT product.id as product_id,"
                + " product.name as product_name,"
                + " item.price as item_price,"
                + " item.id as item_id,"
                + " item.pictures as item_picture_url"
                + " FROM product JOIN item"
                + " WHERE product.id = item.product_id"
                + " AND category_1 = 200"
                + " AND category_2 = 2001"
                + " ORDER BY shelf_time DESC;";
        
        SQLQuery query = getSession().createSQLQuery(strQuery);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List raw_result_set = query.list();
        
        List<SelectedItem> result_set = new ArrayList<SelectedItem>();
        Map<String, Object> row = null;
        
        for (Object object : raw_result_set) {
             row = (Map<String, Object>)object;
             
             SelectedItem sitm = new SelectedItem();
             sitm.setItem_id((BigInteger)row.get("item_id"));
             sitm.setProduct_id((Integer)row.get("product_id"));
             sitm.setPrice((BigDecimal)row.get("item_price"));
             sitm.setProduct_name((String)row.get("product_name"));
             sitm.setItem_picture((String)row.get("item_picture_url"));    
             
             result_set.add(sitm);
        }
        
        return result_set;
    }
}
