package com.dam2.bitacora.entity;

import java.time.Year;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Users")
public class Users {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="username")
    private String username;

    @Column(name="birthday")
    private Year birthday;

    @Column(name="mail")
    private String mail;

    @Column(name="contra")
    private String contra;

    @Column(name="profile_photo")
    private String profilephoto;

    public Users() {}

    public Users(Long id, String username,Year birthday, String mail, String contra, String profilephoto) {
        this.id = id;
        this.username = username;
        this.birthday = birthday;
        this.mail = mail;
        this.contra = contra;
        this.profilephoto = profilephoto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Year getBirthday() {
        return birthday;
    }

    public void setBirthday(Year birthday) {
        this.birthday = birthday;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getProfilePhoto() {
        return profilephoto;
    }

    public void setProfilePhoto(String profilephoto) {
        this.profilephoto = profilephoto;
    }
    
    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", birthday=" + birthday + ", mail=" + mail + ", password=" + contra + ", profilephoto=" + profilephoto
                + "]";
    }
}