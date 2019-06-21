package com.lambdaschool.starthere.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "wrote")
public class Wrote extends Auditable implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "bookid")
    @JsonIgnoreProperties("wrote")
    private long bookid;

    @Id
    @ManyToOne
    @JoinColumn(name = "authorid")
    @JsonIgnoreProperties("wrote")
    private long authorid;

    public Wrote(long bookid, long authorid) {
        this.bookid = bookid;
        this.authorid = authorid;
    }

    public Wrote() {
    }

    public long getBookid() {
        return bookid;
    }

    public void setBookid(long bookid) {
        this.bookid = bookid;
    }


    public long getAuthorid() {
        return authorid;
    }

    public void setAuthorid(long authorid) {
        this.authorid = authorid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookid(), getAuthorid());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Wrote))
        {
            return false;
        }

        Wrote wrote = (Wrote) o;

        return getBookid() == wrote.getBookid() && getAuthorid() == wrote.getAuthorid();
    }

}
