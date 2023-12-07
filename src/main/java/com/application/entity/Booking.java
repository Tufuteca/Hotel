/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.application.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Александр
 */
@Entity
@Table(name = "booking")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b"),
    @NamedQuery(name = "Booking.findByIdBooking", query = "SELECT b FROM Booking b WHERE b.idBooking = :idBooking"),
    @NamedQuery(name = "Booking.findByCheckInDate", query = "SELECT b FROM Booking b WHERE b.checkInDate = :checkInDate"),
    @NamedQuery(name = "Booking.findByDepartureDate", query = "SELECT b FROM Booking b WHERE b.departureDate = :departureDate"),
    @NamedQuery(name = "Booking.findByDescription", query = "SELECT b FROM Booking b WHERE b.description = :description"),
    @NamedQuery(name = "Booking.findByAmount", query = "SELECT b FROM Booking b WHERE b.amount = :amount"),
    @NamedQuery(name = "Booking.findByDeleted", query = "SELECT b FROM Booking b WHERE b.deleted = :deleted")})
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBooking")
    private Integer idBooking;
    @Basic(optional = false)
    @Column(name = "checkInDate")
    @Temporal(TemporalType.DATE)
    private Date checkInDate;
    @Basic(optional = false)
    @Column(name = "departureDate")
    @Temporal(TemporalType.DATE)
    private Date departureDate;
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "amount")
    private String amount;
    @Basic(optional = false)
    @Column(name = "deleted")
    private short deleted;
    @JoinColumn(name = "Room_idRoom", referencedColumnName = "idRoom")
    @ManyToOne(optional = false)
    private Room roomidRoom;
    @JoinColumn(name = "Status_idStatus", referencedColumnName = "idStatus")
    @ManyToOne(optional = false)
    private Status statusidStatus;
    @JoinColumn(name = "User_idUser", referencedColumnName = "idUser")
    @ManyToOne(optional = false)
    private User useridUser;

    public Booking() {
    }

    public Booking(Integer idBooking) {
        this.idBooking = idBooking;
    }

    public Booking(Integer idBooking, Date checkInDate, Date departureDate, String amount, short deleted) {
        this.idBooking = idBooking;
        this.checkInDate = checkInDate;
        this.departureDate = departureDate;
        this.amount = amount;
        this.deleted = deleted;
    }

    public Integer getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(Integer idBooking) {
        this.idBooking = idBooking;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public short getDeleted() {
        return deleted;
    }

    public void setDeleted(short deleted) {
        this.deleted = deleted;
    }

    public Room getRoomidRoom() {
        return roomidRoom;
    }

    public void setRoomidRoom(Room roomidRoom) {
        this.roomidRoom = roomidRoom;
    }

    public Status getStatusidStatus() {
        return statusidStatus;
    }

    public void setStatusidStatus(Status statusidStatus) {
        this.statusidStatus = statusidStatus;
    }

    public User getUseridUser() {
        return useridUser;
    }

    public void setUseridUser(User useridUser) {
        this.useridUser = useridUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBooking != null ? idBooking.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.idBooking == null && other.idBooking != null) || (this.idBooking != null && !this.idBooking.equals(other.idBooking))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.application.entity.Booking[ idBooking=" + idBooking + " ]";
    }
    
}
