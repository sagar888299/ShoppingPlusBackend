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
@Table(name = "Mentors")
public class MentorModel {
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Mentor_ID")
    private long mentorId;

    @Column(name = "First_Name")
    private String firstName;

    @Column(name = "Last_Name")
    private String lastName;

    @Column(name = "Email_ID")
    private String emailId;
    
    @Column(name = "Average_Rating")
    private Double averageRating = 0.0;
    
    @OneToMany(mappedBy = "mentor", cascade = CascadeType.ALL)
    private Set<ReviewModel> mentors;

	public long getMentorId() {
		return mentorId;
	}

	public void setMentorId(long mentorId) {
		this.mentorId = mentorId;
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
	
    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }


	@Override
	public String toString() {
		return "MentorModel [mentorId=" + mentorId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + "]";
	}

	public MentorModel(long mentorId, String firstName, String lastName, String emailId) {
		super();
		this.mentorId = mentorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
	}

	public MentorModel() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
