
package com.bangla.store.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Customer implements Serializable {

    private static final long serialVersionUID = 2284040482222162898L;
    @Id
    @GeneratedValue
    private String customerId;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @Email
    private String email;
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "doorNo", column = @Column(name = "bil_doorNo")),
        @AttributeOverride(name = "streetName", column = @Column(name = "bil_streetName")),
        @AttributeOverride(name = "areaName", column = @Column(name = "bil_areaName")),
        @AttributeOverride(name = "state", column = @Column(name = "bil_state")),
        @AttributeOverride(name = "zipCode", column = @Column(name = "bil_zipCode")),
        @AttributeOverride(name = "country", column = @Column(name = "bil_country"))
    })
    private Address billingAddress;
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "doorNo", column = @Column(name = "ship_doorNo")),
        @AttributeOverride(name = "streetName", column = @Column(name = "ship_streetName")),
        @AttributeOverride(name = "areaName", column = @Column(name = "ship_areaName")),
        @AttributeOverride(name = "state", column = @Column(name = "ship_state")),
        @AttributeOverride(name = "zipCode", column = @Column(name = "ship_zipCode")),
        @AttributeOverride(name = "country", column = @Column(name = "ship_country"))
    })
    private Address shippingaddress;
    private String phoneNumber;
    
    private String gender;

    @Temporal(TemporalType.DATE)
    private Date birthdate;
    
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    public Customer() {
    }

    public Customer(String username, String password, String email, Address billingAddress, String phoneNumber, String gender, Date birthdate) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.billingAddress = billingAddress;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.birthdate = birthdate;
    }

    public Address getShippingaddress() {
        return shippingaddress;
    }

    public void setShippingaddress(Address shippingaddress) {
        this.shippingaddress = shippingaddress;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Customer(String customerId, String name) {
        this();
        this.customerId = customerId;
        this.username = name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

	// add getters and setters for all the fields here.
    // Override equals and hashCode based on customerId field.
    // the code for the same is available in the code bundle which
    // can be downloaded from www.packtpub.com/support
}

