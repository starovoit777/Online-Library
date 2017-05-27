package com.ss.ch.domain;

import javax.persistence.*;

/**
 * Created by Serhii Starovoit on 2/28/2017  in  4:08 PM .
 */
@Entity
@Table(name="`user`")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private int id;

    @Column(name = "NAME", length = 30)
    private String name;

    @Column(name = "SURNAME",  length = 30)
    private String surname;

    @Column(name = "E_MAIL", length = 100)
    private String eMail;

    @Column(name = "LOGIN",  length = 30)
    private String login;

    @Column(name = "PASSWORD",  length = 30)
    private String password;

    @Column(name = "URL_PICTURE",  length = 100)
    private String urlPicture;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private UserRole userRole;

    public User() {

    }

    public User(int id, String name, String surname, String eMail, String login, String password, String urlPicture, UserRole userRole) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.eMail = eMail;
        this.login = login;
        this.password = password;
        this.urlPicture = urlPicture;
        this.userRole = userRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrlPicture() {
        return urlPicture;
    }

    public void setUrlPicture(String urlPicture) {
        this.urlPicture = urlPicture;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", eMail='" + eMail + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", urlPicture='" + urlPicture + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
