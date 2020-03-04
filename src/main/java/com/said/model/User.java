package com.said.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "age")
    private byte age;

    public User() {}

    public User(String name, String lastName, byte age) {
        this.age = age;
        this.lastName = lastName;
        this.name = name;
    }

    public User(long id, String name, String lastName, byte age) {
        this.id = id;
        this.age = age;
        this.lastName = lastName;
        this.name = name;
    }

    public long getId() { return id;}
    public void setId(long id) { this.id = id;}

    public String getName() { return name;}
    public void setName(String name) {this.name = name;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) { this.lastName = lastName;}

    public byte getAge() { return age;}
    public void setAge(byte age) { this.age = age;}

    @Override
    public boolean equals(Object obj) {
        if( this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User that = (User) obj;
        return (this.getName() == that.getName()) &&
                (this.getLastName() == that.getLastName()) &&
                (this.getAge() == that.getAge());
    }
}
