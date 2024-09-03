package com.ShoppingPlusBackend.ShoppingPlusBackend.model;


import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "Students")
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Student_ID")
    private long studentId;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;

    @Column(name = "Email_ID")
    private String emailId;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<Enrollment> enrollments;

    public StudentModel() {}

    public StudentModel(long id, String firstName, String lastName, String emailId) {
        this.studentId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }

    // Getters and Setters
    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }


    @Override
    public String toString() {
        return "StudentModel [id=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId + "]";
    }

	public Long getId() {
		// TODO Auto-generated method stub
		return studentId;
	}
}
