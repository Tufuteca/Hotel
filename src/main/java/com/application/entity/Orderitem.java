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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "orderitem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderitem.findAll", query = "SELECT o FROM Orderitem o"),
    @NamedQuery(name = "Orderitem.findByIdOrderItem", query = "SELECT o FROM Orderitem o WHERE o.idOrderItem = :idOrderItem"),
    @NamedQuery(name = "Orderitem.findByDescription", query = "SELECT o FROM Orderitem o WHERE o.description = :description"),
    @NamedQuery(name = "Orderitem.findByOrderDate", query = "SELECT o FROM Orderitem o WHERE o.orderDate = :orderDate")})
public class Orderitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idOrderItem")
    private Integer idOrderItem;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "orderDate")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderItemidOrderItem")
    private Collection<ItemsHasOrderitem> itemsHasOrderitemCollection;
    @JoinColumn(name = "Status_idStatus", referencedColumnName = "idStatus")
    @ManyToOne(optional = false)
    private Status statusidStatus;

    public Orderitem() {
    }

    public Orderitem(Integer idOrderItem) {
        this.idOrderItem = idOrderItem;
    }

    public Orderitem(Integer idOrderItem, Date orderDate) {
        this.idOrderItem = idOrderItem;
        this.orderDate = orderDate;
    }

    public Integer getIdOrderItem() {
        return idOrderItem;
    }

    public void setIdOrderItem(Integer idOrderItem) {
        this.idOrderItem = idOrderItem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @XmlTransient
    public Collection<ItemsHasOrderitem> getItemsHasOrderitemCollection() {
        return itemsHasOrderitemCollection;
    }

    public void setItemsHasOrderitemCollection(Collection<ItemsHasOrderitem> itemsHasOrderitemCollection) {
        this.itemsHasOrderitemCollection = itemsHasOrderitemCollection;
    }

    public Status getStatusidStatus() {
        return statusidStatus;
    }

    public void setStatusidStatus(Status statusidStatus) {
        this.statusidStatus = statusidStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrderItem != null ? idOrderItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderitem)) {
            return false;
        }
        Orderitem other = (Orderitem) object;
        if ((this.idOrderItem == null && other.idOrderItem != null) || (this.idOrderItem != null && !this.idOrderItem.equals(other.idOrderItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.application.entity.Orderitem[ idOrderItem=" + idOrderItem + " ]";
    }
    
}
