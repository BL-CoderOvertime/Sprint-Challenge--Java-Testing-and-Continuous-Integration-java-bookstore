package com.lambdaschool.starthere.models;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;

    @Column(nullable = false)
    private String booktitle;

    @Column(nullable = false)
    private String bookisbn;

    @Column
    private String bookcopy;

    private int sectionid;

    public Book(String booktitle, String bookisbn, String bookcopy, int sectionid) {
        this.booktitle = booktitle;
        this.bookisbn = bookisbn;
        this.bookcopy = bookcopy;
        this.sectionid = sectionid;
    }

    public Book() {
    }

    public long getBookid() {
        return bookid;
    }

    public void setBookid(long bookid) {
        this.bookid = bookid;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getBookisbn() {
        return bookisbn;
    }

    public void setBookisbn(String bookisbn) {
        this.bookisbn = bookisbn;
    }

    public String getBookcopy() {
        return bookcopy;
    }

    public void setBookcopy(String bookcopy) {
        this.bookcopy = bookcopy;
    }

    public int getSectionid() {
        return sectionid;
    }

    public void setSectionid(int sectionid) {
        this.sectionid = sectionid;
    }
}
