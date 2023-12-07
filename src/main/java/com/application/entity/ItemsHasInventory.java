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
@Table(name = "items_has_inventory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemsHasInventory.findAll", query = "SELECT i FROM ItemsHasInventory i"),
    @NamedQuery(name = "ItemsHasInventory.findByItemshasInventory", query = "SELECT i FROM ItemsHasInventory i WHERE i.itemshasInventory = :itemshasInventory"),
    @NamedQuery(name = "ItemsHasInventory.findByQuantity", query = "SELECT i FROM ItemsHasInventory i WHERE i.quantity = :quantity")})
public class ItemsHasInventory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Items_has_Inventory")
    private Integer itemshasInventory;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @JoinColumn(name = "Inventory_idInventory", referencedColumnName = "idInventory")
    @ManyToOne(optional = false)
    private Inventory inventoryidInventory;
    @JoinColumn(name = "Items_idItems", referencedColumnName = "idItems")
    @ManyToOne(optional = false)
    private Items itemsidItems;

    public ItemsHasInventory() {
    }

    public ItemsHasInventory(Integer itemshasInventory) {
        this.itemshasInventory = itemshasInventory;
    }

    public ItemsHasInventory(Integer itemshasInventory, int quantity) {
        this.itemshasInventory = itemshasInventory;
        this.quantity = quantity;
    }

    public Integer getItemshasInventory() {
        return itemshasInventory;
    }

    public void setItemshasInventory(Integer itemshasInventory) {
        this.itemshasInventory = itemshasInventory;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Inventory getInventoryidInventory() {
        return inventoryidInventory;
    }

    public void setInventoryidInventory(Inventory inventoryidInventory) {
        this.inventoryidInventory = inventoryidInventory;
    }

    public Items getItemsidItems() {
        return itemsidItems;
    }

    public void setItemsidItems(Items itemsidItems) {
        this.itemsidItems = itemsidItems;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemshasInventory != null ? itemshasInventory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemsHasInventory)) {
            return false;
        }
        ItemsHasInventory other = (ItemsHasInventory) object;
        if ((this.itemshasInventory == null && other.itemshasInventory != null) || (this.itemshasInventory != null && !this.itemshasInventory.equals(other.itemshasInventory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.application.entity.ItemsHasInventory[ itemshasInventory=" + itemshasInventory + " ]";
    }
    
}
