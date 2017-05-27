package com.ss.ch.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Serhii Starovoit on 2/28/2017  in  4:23 PM .
 */

@Entity
@Table(name="Author")
public class Author implements Comparable<Author> ,Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AUTHOR_ID")
    private int id;

    @Column(name = "NAME", length = 30)
    private String name;

    @Column(name = "SURNAME", length = 30)
    private String surname;

    @Column(name = "PANNAME", length = 30)
    private String penName;

    @Enumerated(EnumType.STRING)
    @Column(name = "RATING")
    private StarRating rating;

    @Column(name = "URL_PICTURE", length = 100)
    private String urlPicture;

    @JoinColumn(name = "USER_ID")
    @OneToOne(targetEntity = User.class)
    private User user;

    @Column(name = "DESCRIPTION", length = 500)
    private String description;

    @ManyToMany(cascade= CascadeType.ALL)
    @JoinTable(name="`author_book`", joinColumns=@JoinColumn(name="BOOK_ID"), inverseJoinColumns=@JoinColumn(name="AUTHOR_ID"))
    private Set<Book> books;

    public Author() {
    }

    public Author(int id, String name, String surname, String penName, StarRating rating, String urlPicture, User user, String description, Set<Book> books) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.penName = penName;
        this.rating = rating;
        this.urlPicture = urlPicture;
        this.user = user;
        this.description = description;
        this.books = books;
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

    public String getPenName() {
        return penName;
    }

    public void setPenName(String penName) {
        this.penName = penName;
    }

    public StarRating getRating() {
        return rating;
    }

    public void setRating(StarRating rating) {
        this.rating = rating;
    }

    public String getUrlPicture() {
        return urlPicture;
    }

    public void setUrlPicture(String urlPicture) {
        this.urlPicture = urlPicture;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", penName='" + penName + '\'' +
                ", rating=" + rating +
                ", urlPicture='" + urlPicture + '\'' +
                ", user=" + user +
                ", description='" + description + '\'' +
                ", books=" + books +
                '}';
    }

    public int compareTo(Author author) {
        if(this.name == null) {
            return 0;
        }
        return this.name.compareTo(author.name);
    }
}
