/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.application.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Александр
 */
@Entity
@Table(name = "items_has_orderitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemsHasOrderitem.findAll", query = "SELECT i FROM ItemsHasOrderitem i"),
    @NamedQuery(name = "ItemsHasOrderitem.findByItemshasorderItem", query = "SELECT i FROM ItemsHasOrderitem i WHERE i.itemshasorderItem = :itemshasorderItem"),
    @NamedQuery(name = "ItemsHasOrderitem.findByQuantity", query = "SELECT i FROM ItemsHasOrderitem i WHERE i.quantity = :quantity")})
public class ItemsHasOrderitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Items_has_orderItem")
    private Integer itemshasorderItem;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @JoinColumn(name = "Items_idItems", referencedColumnName = "idItems")
    @ManyToOne(optional = false)
    private Items itemsidItems;
    @JoinColumn(name = "orderItem_idOrderItem", referencedColumnName = "idOrderItem")
    @ManyToOne(optional = false)
    private Orderitem orderItemidOrderItem;

    public ItemsHasOrderitem() {
    }

    public ItemsHasOrderitem(Integer itemshasorderItem) {
        this.itemshasorderItem = itemshasorderItem;
    }

    public ItemsHasOrderitem(Integer itemshasorderItem, int quantity) {
        this.itemshasorderItem = itemshasorderItem;
        this.quantity = quantity;
    }

    public Integer getItemshasorderItem() {
        return itemshasorderItem;
    }

    public void setItemshasorderItem(Integer itemshasorderItem) {
        this.itemshasorderItem = itemshasorderItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Items getItemsidItems() {
        return itemsidItems;
    }

    public void setItemsidItems(Items itemsidItems) {
        this.itemsidItems = itemsidItems;
    }

    public Orderitem getOrderItemidOrderItem() {
        return orderItemidOrderItem;
    }

    public void setOrderItemidOrderItem(Orderitem orderItemidOrderItem) {
        this.orderItemidOrderItem = orderItemidOrderItem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemshasorderItem != null ? itemshasorderItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemsHasOrderitem)) {
            return false;
        }
        ItemsHasOrderitem other = (ItemsHasOrderitem) object;
        if ((this.itemshasorderItem == null && other.itemshasorderItem != null) || (this.itemshasorderItem != null && !this.itemshasorderItem.equals(other.itemshasorderItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.application.entity.ItemsHasOrderitem[ itemshasorderItem=" + itemshasorderItem + " ]";
    }
    
}
