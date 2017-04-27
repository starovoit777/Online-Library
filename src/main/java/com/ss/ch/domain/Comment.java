package com.ss.ch.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Serhii Starovoit on 2/28/2017  in  6:33 PM .
 */
@Entity
@Table(name = "Comment")
public class Comment implements Comparable<Comment>, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENT_ID")
    private int id;

    @JoinColumn(name = "USER_ID")
    @OneToOne(targetEntity = User.class)
    private User user;

    private Date createdDate;

    @Column(name = "COMMENT", length = 1000)
    private String comment;


    public Comment() {
    }
    public Comment(Date date) {
        this.createdDate = date;
    }

    public Comment(int id, User user, Date createdDate, String comment) {
        this.id = id;
        this.user = user;
        this.createdDate = createdDate;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", user=" + user +
                ", createdDate=" + createdDate +
                ", comment='" + comment + '\'' +
                '}';
    }

    public int compareTo(Comment comment) {
        if (this.createdDate == null) {
            return 0;
        }
        return this.createdDate.compareTo(comment.createdDate);
    }
}
