package org.appfuse.dao;

import java.util.List;
import org.appfuse.model.CategorySecondLevel;


public interface CategorySecondLevelDao extends GenericDao<CategorySecondLevel, Integer> {
    public List<CategorySecondLevel> getAll(); 
}
