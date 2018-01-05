package com.fiberhome.entity;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by zyf on 2017/11/24.
 */
@Entity
//@Table(name = "book")
public class Book  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "book_id")
    @SequenceGenerator(sequenceName = "book_id",allocationSize = 1,name = "book_id")
    @Column(unique = true)
    private Integer id;
    @Column(length = 255)
    private String name;
    @Column(length = 100)
    private String author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return id+author+name;
    }
}
