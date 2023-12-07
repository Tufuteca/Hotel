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
@Table(name = "items_has_room")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ItemsHasRoom.findAll", query = "SELECT i FROM ItemsHasRoom i"),
    @NamedQuery(name = "ItemsHasRoom.findByItemshasRoom", query = "SELECT i FROM ItemsHasRoom i WHERE i.itemshasRoom = :itemshasRoom"),
    @NamedQuery(name = "ItemsHasRoom.findByQuantity", query = "SELECT i FROM ItemsHasRoom i WHERE i.quantity = :quantity")})
public class ItemsHasRoom implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Items_has_Room")
    private Integer itemshasRoom;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @JoinColumn(name = "Items_idItems", referencedColumnName = "idItems")
    @ManyToOne(optional = false)
    private Items itemsidItems;
    @JoinColumn(name = "Room_idRoom", referencedColumnName = "idRoom")
    @ManyToOne(optional = false)
    private Room roomidRoom;

    public ItemsHasRoom() {
    }

    public ItemsHasRoom(Integer itemshasRoom) {
        this.itemshasRoom = itemshasRoom;
    }

    public ItemsHasRoom(Integer itemshasRoom, int quantity) {
        this.itemshasRoom = itemshasRoom;
        this.quantity = quantity;
    }

    public Integer getItemshasRoom() {
        return itemshasRoom;
    }

    public void setItemshasRoom(Integer itemshasRoom) {
        this.itemshasRoom = itemshasRoom;
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

    public Room getRoomidRoom() {
        return roomidRoom;
    }

    public void setRoomidRoom(Room roomidRoom) {
        this.roomidRoom = roomidRoom;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemshasRoom != null ? itemshasRoom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemsHasRoom)) {
            return false;
        }
        ItemsHasRoom other = (ItemsHasRoom) object;
        if ((this.itemshasRoom == null && other.itemshasRoom != null) || (this.itemshasRoom != null && !this.itemshasRoom.equals(other.itemshasRoom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.application.entity.ItemsHasRoom[ itemshasRoom=" + itemshasRoom + " ]";
    }
    
}
