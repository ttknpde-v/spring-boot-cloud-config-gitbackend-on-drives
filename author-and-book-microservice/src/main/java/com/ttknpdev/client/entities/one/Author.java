package com.ttknpdev.client.entities.one;

import com.ttknpdev.client.entities.many.Book;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "authors")
// must have constructor() {} null arg

public class Author {
    @Id // Mark is a Pk
    private String aid;
    private String fullname;
    private Short age;
    private Boolean alive;
    @OneToMany(cascade = CascadeType.ALL,targetEntity = Book.class)
    @JoinColumn(name = "aid" , referencedColumnName = "aid")
    //          **** Book.aid class         **** Author.aid class
    private List<Book> bookList;

    public Author(String aid, String fullname, Short age, Boolean alive, List<Book> bookList) {
        this.aid = aid;
        this.fullname = fullname;
        this.age = age;
        this.alive = alive;
        this.bookList = bookList;
    }

    public Author() {

    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public Boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Author{" +
                "aid='" + aid + '\'' +
                ", fullname='" + fullname + '\'' +
                ", age=" + age +
                ", alive=" + alive +
                ", bookList=" + bookList +
                '}';
    }
}
