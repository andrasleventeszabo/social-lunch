package com.peanuts.sociallunch.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "findUserById", query = "SELECT us FROM User us WHERE id=:id" )
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column
    private String phone;

    @Column(name = "password")//, nullable = false)
    private String password;

    @Column(name = "image_file_name")
    private String imageFileName;

    @Column(name = "is_active", columnDefinition = "smallint default 1")
    private byte isActive;

    @Column(name = "is_admin", columnDefinition = "smallint default 0")
    private byte isAdmin;

    @CreationTimestamp
    @Column(name = "created")
    private Timestamp createdDate;

    @UpdateTimestamp
    @Column(name = "modified")
    private Timestamp modifiedDate;

    @OneToMany(mappedBy = "giver")
    private List<Review> givenReviewList;

    @OneToMany(mappedBy = "receiver")
    private List<Review> receivedReviewList;

    public User() {
    }

    public User(String firstName, String lastName, String email, String phone, String password, String imageFileName, byte isActive, byte isAdmin, List<Review> givenReviewList, List<Review> receivedReviewList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.imageFileName = imageFileName;
        this.isActive = isActive;
        this.isAdmin = isAdmin;
        this.givenReviewList = givenReviewList;
        this.receivedReviewList = receivedReviewList;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte isActive() {
        return isActive;
    }

    public void setIsActive(byte active) {
        this.isActive = active;
    }

    public byte isAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(byte admin) {
        this.isAdmin = admin;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }


}
