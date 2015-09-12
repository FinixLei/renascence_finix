package org.appfuse.dao.hibernate;
 
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.math.BigInteger;
import java.math.BigDecimal;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
 
import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.appfuse.model.Product;
import org.appfuse.model.SelectedItem;
import org.appfuse.dao.ProductDao;
 
import org.hibernate.criterion.Restrictions;
import org.json.JSONObject;
import org.hibernate.SQLQuery;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
 
@Repository("productDao")
public class ProductDaoHibernate extends GenericDaoHibernate<Product, Long> implements ProductDao {
 
    public ProductDaoHibernate() {
        super(Product.class);
    }
    
    public JSONArray getSpecifiedItems(
            int category_1, 
            int category_2, 
            String sortby, 
            String isDesc
            ) {
        String sortOrder = "DESC";
        if (isDesc == null) {
               isDesc = "false";
        } else if (isDesc.toLowerCase().equals("false")) {
            sortOrder = "ASC"; 
        } else if (isDesc.toLowerCase().equals("true")) {
            sortOrder = "DESC";
        } else {
            sortOrder = "ASC";
        }
        
        if (sortby == null) {
            sortby = "price";
        } else if (sortby.toLowerCase().equals("price")) {
            sortby = "item_price";
        } else if (sortby.toLowerCase().equals("shelf_time")) {
            sortby = "shelf_time";
        } else {
            sortby = "item_price";
        }

        String strQuery = "SELECT product.id as product_id,"
                + " product.name as product_name,"
                + " item.price as item_price,"
                + " item.id as item_id,"
                + " item.pictures as item_picture_url"
                + " FROM product JOIN item"
                + " WHERE product.id = item.product_id"
                + " AND category_first_level_id = " + category_1
                + " AND category_second_level_id = " + category_2
                + " ORDER BY " + sortby 
                + " " + sortOrder + ";";
        
        System.out.println("SQL Query = " + strQuery);
        
        SQLQuery query = getSession().createSQLQuery(strQuery);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List raw_result_set = query.list();

        JSONArray jsonArray = new JSONArray();
        Map<String, Object> row = null;
        
        for (Object object : raw_result_set) {
            row = (Map<String, Object>)object;
            JSONObject jsonObj = new JSONObject();
            
            try {
                jsonObj.put("item_id",          (BigInteger)row.get("item_id"));
                jsonObj.put("product_id",       (Integer)row.get("product_id"));
                jsonObj.put("item_price",       (BigDecimal)row.get("item_price"));
                jsonObj.put("product_name",     (String)row.get("product_name"));
                jsonObj.put("item_picture_url", (String)row.get("item_picture_url"));
                 
                jsonArray.put(jsonObj);
             }
            catch(JSONException je) {
                // To do
                System.out.println("JSON Exception: " + je.getMessage());
             }
        }
        return jsonArray;
    }
}
