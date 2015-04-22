/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bangla.store.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author SW@RUP
 */
@Entity
public class userAuthorities {
     private static final long serialVersionUID = 2284040482222162898L;
    @Id
    @GeneratedValue
    private long userAuthorityId;
    @NotBlank
    private String roleType;
    @ManyToOne
    private users user;

    public userAuthorities() {
    }

    public userAuthorities(String roleType, users user) {
        this.roleType = roleType;
        this.user = user;
    }

    public long getUserAuthorityId() {
        return userAuthorityId;
    }

    public void setUserAuthorityId(long userAuthorityId) {
        this.userAuthorityId = userAuthorityId;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public users getUser() {
        return user;
    }

    public void setUser(users user) {
        this.user = user;
    }
    
    
}
