package com.kshitiz.api;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
@NamedQuery(name = "User.getByIdRange", query = "SELECT u from User AS u where u.id > :startId and u.id< :endId")
public class User implements Serializable {
    @Id
    @SequenceGenerator(name = "mysequence", sequenceName = "mysequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mysequence")
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", email='" + email + '\'' +
            '}';
    }
}

