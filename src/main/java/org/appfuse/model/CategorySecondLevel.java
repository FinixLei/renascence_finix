package org.appfuse.model;

import org.appfuse.model.BaseObject;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
 
@Entity 
@Table(name="category_second_level")
public class CategorySecondLevel extends BaseObject {
    private Integer id;
    private String name;
    private Integer first_level_id;
    
    private static final long serialVersionUID = -1534638596;
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    @Column(name="name", length=255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="first_level_id")
    public Integer getFirst_level_id() {
        return first_level_id;
    }

    public void setFirst_level_id(Integer first_level_id) {
        this.first_level_id = first_level_id;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((first_level_id == null) ? 0 : first_level_id.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CategorySecondLevel other = (CategorySecondLevel) obj;
        if (first_level_id == null) {
            if (other.first_level_id != null)
                return false;
        } else if (!first_level_id.equals(other.first_level_id))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CategorySecondLevel [id=" + id + ", name=" + name + ", first_level_id=" + first_level_id + "]";
    }
    
}
