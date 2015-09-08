package org.appfuse.dao.hibernate;
 
import java.util.List;
 
import org.appfuse.dao.hibernate.GenericDaoHibernate;
import org.appfuse.model.Item;
import org.appfuse.dao.ItemDao;
 
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
 
@Repository("personDao")
public class ItemDaoHibernate extends GenericDaoHibernate<Item, Long> implements ItemDao {
 
    public ItemDaoHibernate() {
        super(Item.class);
    }
    
    public double getPrice(Long id) {
        return 100.00; // getSession().createCriteria(Product.class).add(Restrictions.eq("category_1", id));
    }
}
