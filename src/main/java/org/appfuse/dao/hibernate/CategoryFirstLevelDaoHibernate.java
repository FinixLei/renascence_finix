package org.appfuse.dao.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.appfuse.model.CategoryFirstLevel;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.appfuse.dao.CategoryFirstLevelDao;
 
import org.springframework.stereotype.Repository;
 
@Repository("CategoryFirstLevelDao")
public class CategoryFirstLevelDaoHibernate 
    extends GenericDaoHibernate<CategoryFirstLevel, Integer> 
    implements CategoryFirstLevelDao {
 
    public CategoryFirstLevelDaoHibernate() {
        super(CategoryFirstLevel.class);
    }
    
    public List<CategoryFirstLevel> getAll() {
        String strQuery = "SELECT * FROM category_first_level;";
        SQLQuery query = getSession().createSQLQuery(strQuery);
        query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List raw_result_list = query.list();
        
        Map<String, Object> row = null;        
        
        List<CategoryFirstLevel> cfl_list = new ArrayList<CategoryFirstLevel>();
        for (Object object : raw_result_list) {
            try {
                row = (Map<String, Object>)object;
                Integer id = (Integer)row.get("id");
                String name = (String)row.get("name");
                
                CategoryFirstLevel cfl = new CategoryFirstLevel();
                cfl.setId(id);
                cfl.setName(name);
                cfl_list.add(cfl);
             }
            catch(Exception ex) {
                // To do
                System.out.println("HELLO JSON Exception: " + ex.getMessage());
             }
        }
        
        return cfl_list;
    }
}
