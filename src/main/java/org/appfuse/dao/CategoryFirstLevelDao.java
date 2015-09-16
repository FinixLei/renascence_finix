package org.appfuse.dao;

import java.util.List;
import org.appfuse.model.CategoryFirstLevel;


public interface CategoryFirstLevelDao extends GenericDao<CategoryFirstLevel, Integer> {
    public List<CategoryFirstLevel> getAll(); 
}
