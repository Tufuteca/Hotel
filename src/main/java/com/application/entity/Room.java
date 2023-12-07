/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.application.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Александр
 */
@Entity
@Table(name = "room")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r"),
    @NamedQuery(name = "Room.findByIdRoom", query = "SELECT r FROM Room r WHERE r.idRoom = :idRoom"),
    @NamedQuery(name = "Room.findByTypeOfRoom", query = "SELECT r FROM Room r WHERE r.typeOfRoom = :typeOfRoom"),
    @NamedQuery(name = "Room.findByNumberOfRoom", query = "SELECT r FROM Room r WHERE r.numberOfRoom = :numberOfRoom"),
    @NamedQuery(name = "Room.findByDescription", query = "SELECT r FROM Room r WHERE r.description = :description"),
    @NamedQuery(name = "Room.findByArea", query = "SELECT r FROM Room r WHERE r.area = :area"),
    @NamedQuery(name = "Room.findByNumberOfSeats", query = "SELECT r FROM Room r WHERE r.numberOfSeats = :numberOfSeats"),
    @NamedQuery(name = "Room.findByPrice", query = "SELECT r FROM Room r WHERE r.price = :price"),
    @NamedQuery(name = "Room.findByDeleted", query = "SELECT r FROM Room r WHERE r.deleted = :deleted")})
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRoom")
    private Integer idRoom;
    @Basic(optional = false)
    @Column(name = "typeOfRoom")
    private String typeOfRoom;
    @Basic(optional = false)
    @Column(name = "numberOfRoom")
    private int numberOfRoom;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "area")
    private float area;
    @Basic(optional = false)
    @Column(name = "numberOfSeats")
    private int numberOfSeats;
    @Basic(optional = false)
    @Column(name = "price")
    private float price;
    @Basic(optional = false)
    @Column(name = "deleted")
    private short deleted;

    public Room() {
    }

    public Room(Integer idRoom) {
        this.idRoom = idRoom;
    }

    public Room(Integer idRoom, String typeOfRoom, int numberOfRoom, float area, int numberOfSeats, float price, short deleted) {
        this.idRoom = idRoom;
        this.typeOfRoom = typeOfRoom;
        this.numberOfRoom = numberOfRoom;
        this.area = area;
        this.numberOfSeats = numberOfSeats;
        this.price = price;
        this.deleted = deleted;
    }

    public Integer getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Integer idRoom) {
        this.idRoom = idRoom;
    }

    public String getTypeOfRoom() {
        return typeOfRoom;
    }

    public void setTypeOfRoom(String typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }

    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    public void setNumberOfRoom(int numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public short getDeleted() {
        return deleted;
    }

    public void setDeleted(short deleted) {
        this.deleted = deleted;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRoom != null ? idRoom.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Room)) {
            return false;
        }
        Room other = (Room) object;
        if ((this.idRoom == null && other.idRoom != null) || (this.idRoom != null && !this.idRoom.equals(other.idRoom))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.application.entity.Room[ idRoom=" + idRoom + " ]";
    }
    public List<Room> getRoomList(EntityManager em){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Room.class);
        Root<Room> root = cq.from(Room.class);
        cq.select(root);
        TypedQuery query = em.createQuery(cq);
        List<Room> userList = query.getResultList();
        return userList; }
}
