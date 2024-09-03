package com.ShoppingPlusBackend.ShoppingPlusBackend.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity
@Table(name = "Reviews")
public class ReviewModel {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Review_ID")
    private long reviewId;
    
    @ManyToOne
    @JoinColumn(name = "User_ID" , nullable = false)
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "Mentor_ID" , nullable = false)
    private MentorModel mentor;
    
    @Column(name = "Rating")
    private Long rating;

    @Column(name = "Written_Review")
    private String writtenReview;

	public long getReviewId() {
		return reviewId;
	}

	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}

	public UserModel getUser() {
		return user;
	}

	public MentorModel getMentor() {
		return mentor;
	}

	public Long getRating() {
		return rating;
	}

	public void setRating(long mentorRating) {
		this.rating =  mentorRating;
	}

	public String getWrittenReview() {
		return writtenReview;
	}

	public void setWrittenReview(String writtenReview) {
		this.writtenReview = writtenReview;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}
	public void setMentor(MentorModel mentor) {
		this.mentor = mentor;
	}

    

}
