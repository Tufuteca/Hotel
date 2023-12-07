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
@Table(name = "children")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Children.findAll", query = "SELECT c FROM Children c"),
    @NamedQuery(name = "Children.findByIdChildren", query = "SELECT c FROM Children c WHERE c.idChildren = :idChildren"),
    @NamedQuery(name = "Children.findBySurname", query = "SELECT c FROM Children c WHERE c.surname = :surname"),
    @NamedQuery(name = "Children.findByName", query = "SELECT c FROM Children c WHERE c.name = :name"),
    @NamedQuery(name = "Children.findByPatronymic", query = "SELECT c FROM Children c WHERE c.patronymic = :patronymic"),
    @NamedQuery(name = "Children.findByDateOfBirth", query = "SELECT c FROM Children c WHERE c.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "Children.findByDeleted", query = "SELECT c FROM Children c WHERE c.deleted = :deleted")})
public class Children implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idChildren")
    private Integer idChildren;
    @Basic(optional = false)
    @Column(name = "Surname")
    private String surname;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "Patronymic")
    private String patronymic;
    @Basic(optional = false)
    @Column(name = "dateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Basic(optional = false)
    @Column(name = "deleted")
    private short deleted;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "childrenidChildren")
    private Collection<ClientHasChildren> clientHasChildrenCollection;

    public Children() {
    }

    public Children(Integer idChildren) {
        this.idChildren = idChildren;
    }

    public Children(Integer idChildren, String surname, String name, Date dateOfBirth, short deleted) {
        this.idChildren = idChildren;
        this.surname = surname;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.deleted = deleted;
    }

    public Integer getIdChildren() {
        return idChildren;
    }

    public void setIdChildren(Integer idChildren) {
        this.idChildren = idChildren;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public short getDeleted() {
        return deleted;
    }

    public void setDeleted(short deleted) {
        this.deleted = deleted;
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
        hash += (idChildren != null ? idChildren.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Children)) {
            return false;
        }
        Children other = (Children) object;
        if ((this.idChildren == null && other.idChildren != null) || (this.idChildren != null && !this.idChildren.equals(other.idChildren))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.application.entity.Children[ idChildren=" + idChildren + " ]";
    }
    
}
