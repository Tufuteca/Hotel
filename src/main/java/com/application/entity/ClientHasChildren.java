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
@Table(name = "client_has_children")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClientHasChildren.findAll", query = "SELECT c FROM ClientHasChildren c"),
    @NamedQuery(name = "ClientHasChildren.findByClienthasChildren", query = "SELECT c FROM ClientHasChildren c WHERE c.clienthasChildren = :clienthasChildren")})
public class ClientHasChildren implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Client_has_Children")
    private Integer clienthasChildren;
    @JoinColumn(name = "Children_idChildren", referencedColumnName = "idChildren")
    @ManyToOne(optional = false)
    private Children childrenidChildren;
    @JoinColumn(name = "Client_idClient", referencedColumnName = "idClient")
    @ManyToOne(optional = false)
    private Client clientidClient;

    public ClientHasChildren() {
    }

    public ClientHasChildren(Integer clienthasChildren) {
        this.clienthasChildren = clienthasChildren;
    }

    public Integer getClienthasChildren() {
        return clienthasChildren;
    }

    public void setClienthasChildren(Integer clienthasChildren) {
        this.clienthasChildren = clienthasChildren;
    }

    public Children getChildrenidChildren() {
        return childrenidChildren;
    }

    public void setChildrenidChildren(Children childrenidChildren) {
        this.childrenidChildren = childrenidChildren;
    }

    public Client getClientidClient() {
        return clientidClient;
    }

    public void setClientidClient(Client clientidClient) {
        this.clientidClient = clientidClient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienthasChildren != null ? clienthasChildren.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientHasChildren)) {
            return false;
        }
        ClientHasChildren other = (ClientHasChildren) object;
        if ((this.clienthasChildren == null && other.clienthasChildren != null) || (this.clienthasChildren != null && !this.clienthasChildren.equals(other.clienthasChildren))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.application.entity.ClientHasChildren[ clienthasChildren=" + clienthasChildren + " ]";
    }
    
}
