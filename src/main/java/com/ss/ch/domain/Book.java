package com.ss.ch.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Serhii Starovoit on 2/28/2017  in  4:16 PM .
 */

@Entity
@Table(name="Book")
public class Book implements Comparable<Book>, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOK_ID")
    private int id;

    @Column(name = "TITLE", length = 100)
    private String title;

    @Enumerated(EnumType.STRING)
    private StarRating rating;

    @Column(name = "DESCRIPTION", length = 500)
    private String description;

    @JoinColumn(name = "USER_ID")
    @OneToOne(targetEntity = User.class)
    private User user;

    @Column(name = "URL_PICTURE", length = 100)
    private String urlPicture;

    @Column(name = "DOUNLOAD_COUNTER", length = 50)
    private int downloadCounter;

    @JoinColumn(name = "GENRE_ID")
    @OneToOne(targetEntity = Genre.class)
    private Genre genre;


    @ManyToMany(cascade= CascadeType.ALL)
    @JoinTable(name="`author_book`", joinColumns=@JoinColumn(name="AUTHOR_ID"), inverseJoinColumns=@JoinColumn(name="BOOK_ID"))
    private Set<Author> authors;



    public Book() {
    }

    public Book(int id, String title, StarRating rating, String description, User user, String urlPicture, int downloadCounter, Genre genre, Set<Author> authors) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.description = description;
        this.user = user;
        this.urlPicture = urlPicture;
        this.downloadCounter = downloadCounter;
        this.genre = genre;
        this.authors = authors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public StarRating getRating() {
        return rating;
    }

    public void setRating(StarRating rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUrlPicture() {
        return urlPicture;
    }

    public void setUrlPicture(String urlPicture) {
        this.urlPicture = urlPicture;
    }

    public int getDownloadCounter() {
        return downloadCounter;
    }

    public void setDownloadCounter(int downloadCounter) {
        this.downloadCounter = downloadCounter;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", user=" + user +
                ", urlPicture='" + urlPicture + '\'' +
                ", downloadCounter=" + downloadCounter +
                ", genre=" + genre +
                ", authors=" + authors +
                '}';
    }


    public int compareTo(Book book) {
        if(this.title == null) {
            return 0;
        }
        return this.title.compareTo(book.title);
    }
}
