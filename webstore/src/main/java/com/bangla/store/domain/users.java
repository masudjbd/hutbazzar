/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bangla.store.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author SW@RUP
 */
@Entity
public class users implements Serializable {
    private static final long serialVersionUID = 2284040482222162898L;
    
    @GeneratedValue
    private long userid;
    
    @Id
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<userAuthorities> userAuthorities=new ArrayList<userAuthorities>();

    public users() {
    }
public users(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<userAuthorities> getUserAuthorities() {
        return userAuthorities;
    }

    public void setUserAuthorities(List<userAuthorities> userAuthorities) {
        this.userAuthorities = userAuthorities;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (int) (this.userid ^ (this.userid >>> 32));
        hash = 53 * hash + Objects.hashCode(this.username);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final users other = (users) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }

    
    
}
