/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bangla.store.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author SW@RUP
 */
@Entity
public class Authorities {
     private static final long serialVersionUID = 2284040482222162898L;
    @Id
    @GeneratedValue
    private long Id;
    @NotBlank
    private String authority;
    @ManyToOne @JoinColumn(name="username")
    private Users user;

    public Authorities() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Authorities(String authority) {
        this.authority = authority;
    }

     
    
    
}
