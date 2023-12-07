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
@Table(name = "client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByIdClient", query = "SELECT c FROM Client c WHERE c.idClient = :idClient"),
    @NamedQuery(name = "Client.findBySurname", query = "SELECT c FROM Client c WHERE c.surname = :surname"),
    @NamedQuery(name = "Client.findByName", query = "SELECT c FROM Client c WHERE c.name = :name"),
    @NamedQuery(name = "Client.findByPatronymic", query = "SELECT c FROM Client c WHERE c.patronymic = :patronymic"),
    @NamedQuery(name = "Client.findByPhoneNumber", query = "SELECT c FROM Client c WHERE c.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Client.findBySeriesPassport", query = "SELECT c FROM Client c WHERE c.seriesPassport = :seriesPassport"),
    @NamedQuery(name = "Client.findByNumberPassport", query = "SELECT c FROM Client c WHERE c.numberPassport = :numberPassport"),
    @NamedQuery(name = "Client.findByPlaceOfresidence", query = "SELECT c FROM Client c WHERE c.placeOfresidence = :placeOfresidence"),
    @NamedQuery(name = "Client.findByIssuedPassport", query = "SELECT c FROM Client c WHERE c.issuedPassport = :issuedPassport"),
    @NamedQuery(name = "Client.findByDateIssue", query = "SELECT c FROM Client c WHERE c.dateIssue = :dateIssue"),
    @NamedQuery(name = "Client.findByDeleted", query = "SELECT c FROM Client c WHERE c.deleted = :deleted"),
    @NamedQuery(name = "Client.findByDateOfBirth", query = "SELECT c FROM Client c WHERE c.dateOfBirth = :dateOfBirth")})
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idClient")
    private Integer idClient;
    @Basic(optional = false)
    @Column(name = "surname")
    private String surname;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Column(name = "patronymic")
    private String patronymic;
    @Basic(optional = false)
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Basic(optional = false)
    @Column(name = "seriesPassport")
    private int seriesPassport;
    @Basic(optional = false)
    @Column(name = "numberPassport")
    private int numberPassport;
    @Basic(optional = false)
    @Column(name = "PlaceOfresidence")
    private String placeOfresidence;
    @Basic(optional = false)
    @Column(name = "issuedPassport")
    private String issuedPassport;
    @Basic(optional = false)
    @Column(name = "dateIssue")
    @Temporal(TemporalType.DATE)
    private Date dateIssue;
    @Basic(optional = false)
    @Column(name = "deleted")
    private short deleted;
    @Basic(optional = false)
    @Column(name = "dateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientidClient")
    private Collection<Room> roomCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientidClient")
    private Collection<ClientHasChildren> clientHasChildrenCollection;

    public Client() {
    }

    public Client(Integer idClient) {
        this.idClient = idClient;
    }

    public Client(Integer idClient, String surname, String name, String phoneNumber, int seriesPassport, int numberPassport, String placeOfresidence, String issuedPassport, Date dateIssue, short deleted, Date dateOfBirth) {
        this.idClient = idClient;
        this.surname = surname;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.seriesPassport = seriesPassport;
        this.numberPassport = numberPassport;
        this.placeOfresidence = placeOfresidence;
        this.issuedPassport = issuedPassport;
        this.dateIssue = dateIssue;
        this.deleted = deleted;
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSeriesPassport() {
        return seriesPassport;
    }

    public void setSeriesPassport(int seriesPassport) {
        this.seriesPassport = seriesPassport;
    }

    public int getNumberPassport() {
        return numberPassport;
    }

    public void setNumberPassport(int numberPassport) {
        this.numberPassport = numberPassport;
    }

    public String getPlaceOfresidence() {
        return placeOfresidence;
    }

    public void setPlaceOfresidence(String placeOfresidence) {
        this.placeOfresidence = placeOfresidence;
    }

    public String getIssuedPassport() {
        return issuedPassport;
    }

    public void setIssuedPassport(String issuedPassport) {
        this.issuedPassport = issuedPassport;
    }

    public Date getDateIssue() {
        return dateIssue;
    }

    public void setDateIssue(Date dateIssue) {
        this.dateIssue = dateIssue;
    }

    public short getDeleted() {
        return deleted;
    }

    public void setDeleted(short deleted) {
        this.deleted = deleted;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @XmlTransient
    public Collection<Room> getRoomCollection() {
        return roomCollection;
    }

    public void setRoomCollection(Collection<Room> roomCollection) {
        this.roomCollection = roomCollection;
    }

    @XmlTransient
    public Collection<ClientHasChildren> getClientHasChildrenCollection() {
        return clientHasChildrenCollection;
    }

    public void setClientHasChildrenCollection(Collection<ClientHasChildren> clientHasChildrenCollection) {
        this.clientHasChildrenCollection = clientHasChildrenCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClient != null ? idClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.idClient == null && other.idClient != null) || (this.idClient != null && !this.idClient.equals(other.idClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.application.entity.Client[ idClient=" + idClient + " ]";
    }
    
}
