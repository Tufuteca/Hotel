/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.application.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Александр
 */
@Entity
@Table(name = "items")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Items.findAll", query = "SELECT i FROM Items i"),
    @NamedQuery(name = "Items.findByIdItems", query = "SELECT i FROM Items i WHERE i.idItems = :idItems"),
    @NamedQuery(name = "Items.findByItemTitle", query = "SELECT i FROM Items i WHERE i.itemTitle = :itemTitle"),
    @NamedQuery(name = "Items.findByDescription", query = "SELECT i FROM Items i WHERE i.description = :description"),
    @NamedQuery(name = "Items.findByQuantity", query = "SELECT i FROM Items i WHERE i.quantity = :quantity")})
public class Items implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idItems")
    private Integer idItems;
    @Basic(optional = false)
    @Column(name = "itemTitle")
    private String itemTitle;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "Quantity")
    private int quantity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemsidItems")
    private Collection<ItemsHasOrderitem> itemsHasOrderitemCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemsidItems")
    private Collection<ItemsHasInventory> itemsHasInventoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemsidItems")
    private Collection<ItemsHasRoom> itemsHasRoomCollection;

    public Items() {
    }

    public Items(Integer idItems) {
        this.idItems = idItems;
    }

    public Items(Integer idItems, String itemTitle, int quantity) {
        this.idItems = idItems;
        this.itemTitle = itemTitle;
        this.quantity = quantity;
    }

    public Integer getIdItems() {
        return idItems;
    }

    public void setIdItems(Integer idItems) {
        this.idItems = idItems;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @XmlTransient
    public Collection<ItemsHasOrderitem> getItemsHasOrderitemCollection() {
        return itemsHasOrderitemCollection;
    }

    public void setItemsHasOrderitemCollection(Collection<ItemsHasOrderitem> itemsHasOrderitemCollection) {
        this.itemsHasOrderitemCollection = itemsHasOrderitemCollection;
    }

    @XmlTransient
    public Collection<ItemsHasInventory> getItemsHasInventoryCollection() {
        return itemsHasInventoryCollection;
    }

    public void setItemsHasInventoryCollection(Collection<ItemsHasInventory> itemsHasInventoryCollection) {
        this.itemsHasInventoryCollection = itemsHasInventoryCollection;
    }

    @XmlTransient
    public Collection<ItemsHasRoom> getItemsHasRoomCollection() {
        return itemsHasRoomCollection;
    }

    public void setItemsHasRoomCollection(Collection<ItemsHasRoom> itemsHasRoomCollection) {
        this.itemsHasRoomCollection = itemsHasRoomCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItems != null ? idItems.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Items)) {
            return false;
        }
        Items other = (Items) object;
        if ((this.idItems == null && other.idItems != null) || (this.idItems != null && !this.idItems.equals(other.idItems))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.application.entity.Items[ idItems=" + idItems + " ]";
    }
    
}
