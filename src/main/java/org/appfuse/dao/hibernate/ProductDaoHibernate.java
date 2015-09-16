package org.appfuse.dao.hibernate;
 
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.sql.Timestamp;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.appfuse.model.Product;
import org.appfuse.model.PuUnit;
import org.appfuse.model.ItemUnit;
import org.appfuse.dao.ProductDao;
 
import org.hibernate.SQLQuery;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
 
@Repository("productDao")
public class ProductDaoHibernate extends GenericDaoHibernate<Product, Long> implements ProductDao {
 
    public ProductDaoHibernate() {
        super(Product.class);
    }
    
    public List<PuUnit> getSpecifiedItems(
            int category_1, 
            int category_2
            ) {
        String strQuery = "SELECT product.id as pu_id,"
                + " product.name as pu_name,"
                + " product.description as pu_desc,"
                + " item.price as item_price,"
                + " item.id as item_id,"
                + " item.pictures as pic_url,"
                + " item.shelf_time as shelf_time"
                + " FROM product JOIN item"
                + " WHERE product.id = item.product_id"
                + " AND category_first_level_id = " + category_1
                + " AND category_second_level_id = " + category_2 
                + ";";
        
        System.out.println("SQL Query = " + strQuery);
        
        SQLQuery query = getSession().createSQLQuery(strQuery);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List raw_result_set = query.list();

        Map<String, Object> row = null;        
        Map<Integer, PuUnit> pus_map = new HashMap<Integer, PuUnit>();
        
        for (Object object : raw_result_set) {
            try {
                row = (Map<String, Object>)object;
                
                BigInteger item_id = (BigInteger)row.get("item_id");
                String pic_url = (String)row.get("pic_url");
                BigDecimal item_price = (BigDecimal)row.get("item_price");
                Timestamp shelf_time = (Timestamp)row.get("shelf_time");
                
                Integer pu_id = (Integer)row.get("pu_id");
                String pu_name = (String)row.get("pu_name");
                String pu_desc = (String)row.get("pu_desc");
                
                ItemUnit item = new ItemUnit();
                item.setItem_id(item_id);                
                item.setPic_url(pic_url);
                item.setItem_price(item_price);
                item.setShelf_time(shelf_time);
                
                if (pus_map.get(pu_id) == null) {
                    PuUnit pu = new PuUnit();
                    pu.setPu_id(pu_id);
                    pu.setPu_name(pu_name);
                    pu.setPu_desc(pu_desc);
                    pu.setPu_price(item_price);
                    pu.setPu_shelf_time(shelf_time);

                    List<ItemUnit> item_list = new ArrayList<ItemUnit>(); 
                    item_list.add(item);
                    pu.setItem_list(item_list);
                    
                    pus_map.put(pu_id, pu);
                } else {
                    PuUnit pu = pus_map.get(pu_id);
                    List<ItemUnit> item_list = pu.getItem_list(); 
                    item_list.add(item);
                    
                    if (item_price.compareTo(pu.getPu_price()) < 0) {
                        pu.setPu_price(item_price);
                    }
                    
                    if (shelf_time.compareTo(pu.getPu_shelf_time()) > 0) { // newer
                        pu.setPu_shelf_time(shelf_time);
                    }
                }
             }
            catch(Exception ex) {
                // To do
                System.out.println("HELLO JSON Exception: " + ex.getMessage());
             }
        }
        
        List<PuUnit> return_set = new ArrayList<PuUnit>();
        
        for (Integer key : pus_map.keySet()) {
            return_set.add(pus_map.get(key));
        }
        
        return return_set;
    }
}
