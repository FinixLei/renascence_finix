package org.appfuse.dao.hibernate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.appfuse.model.CategoryFirstLevel;
import org.appfuse.model.CategorySecondLevel;
import org.appfuse.model.CategoryUnit;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.appfuse.dao.CategorySecondLevelDao;
 
import org.springframework.stereotype.Repository;
 
@Repository("CategorySecondLevelDao")
public class CategorySecondLevelDaoHibernate 
    extends GenericDaoHibernate<CategorySecondLevel, Integer> 
    implements CategorySecondLevelDao {
 
    public CategorySecondLevelDaoHibernate() {
        super(CategorySecondLevel.class);
    }
    
    public List<CategorySecondLevel> getAll() {
        String strQuery = "SELECT * FROM category_second_level;";
        SQLQuery query = getSession().createSQLQuery(strQuery);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List raw_result_list = query.list();
        
        Map<String, Object> row = null;        
        
        List<CategorySecondLevel> csl_list = new ArrayList<CategorySecondLevel>();
        for (Object object : raw_result_list) {
            try {
                row = (Map<String, Object>)object;
                Integer id = (Integer)row.get("id");
                String name = (String)row.get("name");
                Integer first_level_id  = (Integer)row.get("first_level_id");
                
                CategorySecondLevel csl = new CategorySecondLevel();
                csl.setId(id);
                csl.setName(name);
                csl.setFirst_level_id(first_level_id);
                csl_list.add(csl);
             }
            catch(Exception ex) {
                // To do
                System.out.println("HELLO JSON Exception: " + ex.getMessage());
             }
        }
        
        return csl_list;
    }
}
