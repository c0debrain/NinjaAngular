package com.iffcoder.models;

/**
 * Created by guoliangwang on 12/23/14.
 */

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "ninja_userprofile")
public class UserProfile implements Serializable {

    @Id
    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference   //child side
    private User user;

    @Column(name = "username", nullable = true, unique = true)
    private String username;

    @Column(name = "user_fullname", nullable = true)
    private String fullName;

    @Column(name = "address", nullable = true)
    private String address;

    @Column(name = "city", nullable = true)
    private String city;

    @Column(name = "state", nullable = true)
    private String state;

    @Column(name = "country", nullable = true)
    private String country;

    @Column(name = "zipcode", nullable = true)
    private String zipCode;

    @Column(name = "occupation")
    private String occupation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "birthDay")
    private Date birthday;

    @Column(name = "last_login_IP")
    private String lastLoginIP;

    @Column(name = "facebook_page")
    private String facebookPage;

    public UserProfile() {}

    public UserProfile(User user, String fullName, String address, String city,
                       String state, String country, String zipCode, String occupation,
                       Date birthday, String lastLoginIP, String facebookPage, String username) {
        this.user = user;
        this.fullName = fullName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
        this.occupation = occupation;
        this.birthday = birthday;
        this.lastLoginIP = lastLoginIP;
        this.facebookPage = facebookPage;
        this.username = username;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLastLoginIP() {
        return lastLoginIP;
    }

    public void setLastLoginIP(String lastLoginIP) {
        this.lastLoginIP = lastLoginIP;
    }

    public String getFacebookPage() {
        return facebookPage;
    }

    public void setFacebookPage(String facebookPage) {
        this.facebookPage = facebookPage;
    }
}

