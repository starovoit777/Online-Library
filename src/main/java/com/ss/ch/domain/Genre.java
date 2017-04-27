package com.ss.ch.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Serhii Starovoit on 3/1/2017  in  12:38 PM .
 */
@Entity
@Table(name="genre")
public class Genre implements Comparable<Genre>, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    private int id;

    @Column(name = "name", length = 50)
    private String name;

    public Genre() {

    }

    public Genre(int id, String name) {
        this.id = id;
        this.name = name;

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


    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int compareTo(Genre genre) {
        if(this.name == null) {
            return 0;
        }
        return this.name.compareTo(genre.name);
    }
}
