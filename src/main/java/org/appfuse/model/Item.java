package org.appfuse.model;

import org.appfuse.model.BaseObject;
 
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
 
@Entity @Table(name="item")
public class Item extends BaseObject {
    private Long id;
    private Long merchant_id;
    private Long product_id;
    private byte type;
    private int total_count;
    private int current_count;
    private float price;
    private byte state;
    private String description;
    private String thumbnails;
    private String pictures;
    private String shelf_time;
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @Column(name="merchant_id")
    public Long getMerchant_id() {
        return merchant_id;
    }
    
    public void setMerchant_id(Long merchant_id) {
        this.merchant_id = merchant_id;
    }
    
    @Column(name="product_id")
    public Long getProduct_id() {
        return product_id;
    }
    
    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }
    
    @Column(name="type")
    public byte getType() {
        return type;
    }
    
    public void setType(byte type) {
        this.type = type;
    }
    
    @Column(name="total_count")
    public int getTotal_count() {
        return total_count;
    }
    
    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }
    
    @Column(name="current_count")
    public int getCurrent_count() {
        return current_count;
    }
    
    public void setCurrent_count(int current_count) {
        this.current_count = current_count;
    }
    
    @Column(name="price")
    public float getPrice() {
        return price;
    }
    
    public void setPrice(float price) {
        this.price = price;
    }
    
    @Column(name="state")
    public byte getState() {
        return state;
    }
    
    public void setState(byte state) {
        this.state = state;
    }
    
    @Column(name="description", length=1024)
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Column(name="thumbnails", length=1024)
    public String getThumbnails() {
        return thumbnails;
    }
    public void setThumbnails(String thumbnails) {
        this.thumbnails = thumbnails;
    }
    
    @Column(name="pictures", length=1024)
    public String getPictures() {
        return pictures;
    }
    
    public void setPictures(String pictures) {
        this.pictures = pictures;
    }
    
    @Column(name="shelf_time", length=32)
    public String getShelf_time() {
        return shelf_time;
    }
    
    public void setShelf_time(String shelf_time) {
        this.shelf_time = shelf_time;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + current_count;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((merchant_id == null) ? 0 : merchant_id.hashCode());
        result = prime * result + ((pictures == null) ? 0 : pictures.hashCode());
        result = prime * result + Float.floatToIntBits(price);
        result = prime * result + ((product_id == null) ? 0 : product_id.hashCode());
        result = prime * result + ((shelf_time == null) ? 0 : shelf_time.hashCode());
        result = prime * result + state;
        result = prime * result + ((thumbnails == null) ? 0 : thumbnails.hashCode());
        result = prime * result + total_count;
        result = prime * result + type;
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
        Item other = (Item) obj;
        if (current_count != other.current_count)
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (merchant_id == null) {
            if (other.merchant_id != null)
                return false;
        } else if (!merchant_id.equals(other.merchant_id))
            return false;
        if (pictures == null) {
            if (other.pictures != null)
                return false;
        } else if (!pictures.equals(other.pictures))
            return false;
        if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
            return false;
        if (product_id == null) {
            if (other.product_id != null)
                return false;
        } else if (!product_id.equals(other.product_id))
            return false;
        if (shelf_time == null) {
            if (other.shelf_time != null)
                return false;
        } else if (!shelf_time.equals(other.shelf_time))
            return false;
        if (state != other.state)
            return false;
        if (thumbnails == null) {
            if (other.thumbnails != null)
                return false;
        } else if (!thumbnails.equals(other.thumbnails))
            return false;
        if (total_count != other.total_count)
            return false;
        if (type != other.type)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", merchant_id=" + merchant_id + ", product_id=" + product_id + ", type=" + type
                + ", total_count=" + total_count + ", current_count=" + current_count + ", price=" + price + ", state="
                + state + ", description=" + description + ", thumbnails=" + thumbnails + ", pictures=" + pictures
                + ", shelf_time=" + shelf_time + "]";
    }
    
    
}
    