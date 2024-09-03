package com.ShoppingPlusBackend.ShoppingPlusBackend.controller;

public class ReviewRequest {

	
	   private Long userId;
	    private Long mentorId;
	    private Long rating ;
	    private String writtenReview ;

	    public Long getUserId() {
	        return userId;
	        
	    }

	    public void setUserId(Long userId) {
	        this.userId = userId;
	    }

	    public Long getMentorId() {
	        return mentorId;
	    }

	    public void setMentorId(Long mentorId) {
	        this.mentorId = mentorId;
	    }

		public Long getRating() {
			return rating;
		}
		
		public String getReview() {
			return writtenReview;
		}
}
