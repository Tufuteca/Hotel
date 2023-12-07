/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.application.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Александр
 */
@Entity
@Table(name = "inventory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inventory.findAll", query = "SELECT i FROM Inventory i"),
    @NamedQuery(name = "Inventory.findByIdInventory", query = "SELECT i FROM Inventory i WHERE i.idInventory = :idInventory"),
    @NamedQuery(name = "Inventory.findByDateStart", query = "SELECT i FROM Inventory i WHERE i.dateStart = :dateStart"),
    @NamedQuery(name = "Inventory.findByDateEnd", query = "SELECT i FROM Inventory i WHERE i.dateEnd = :dateEnd"),
    @NamedQuery(name = "Inventory.findByDescription", query = "SELECT i FROM Inventory i WHERE i.description = :description"),
    @NamedQuery(name = "Inventory.findByChange", query = "SELECT i FROM Inventory i WHERE i.change = :change")})
public class Inventory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idInventory")
    private Integer idInventory;
    @Basic(optional = false)
    @Column(name = "dateStart")
    @Temporal(TemporalType.DATE)
    private Date dateStart;
    @Column(name = "dateEnd")
    @Temporal(TemporalType.DATE)
    private Date dateEnd;
    @Column(name = "description")
    private String description;
    @Column(name = "change")
    private Integer change;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventoryidInventory")
    private Collection<ItemsHasInventory> itemsHasInventoryCollection;

    public Inventory() {
    }

    public Inventory(Integer idInventory) {
        this.idInventory = idInventory;
    }

    public Inventory(Integer idInventory, Date dateStart) {
        this.idInventory = idInventory;
        this.dateStart = dateStart;
    }

    public Integer getIdInventory() {
        return idInventory;
    }

    public void setIdInventory(Integer idInventory) {
        this.idInventory = idInventory;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getChange() {
        return change;
    }

    public void setChange(Integer change) {
        this.change = change;
    }

    @XmlTransient
    public Collection<ItemsHasInventory> getItemsHasInventoryCollection() {
        return itemsHasInventoryCollection;
    }

    public void setItemsHasInventoryCollection(Collection<ItemsHasInventory> itemsHasInventoryCollection) {
        this.itemsHasInventoryCollection = itemsHasInventoryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInventory != null ? idInventory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventory)) {
            return false;
        }
        Inventory other = (Inventory) object;
        if ((this.idInventory == null && other.idInventory != null) || (this.idInventory != null && !this.idInventory.equals(other.idInventory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.application.entity.Inventory[ idInventory=" + idInventory + " ]";
    }
    
}
