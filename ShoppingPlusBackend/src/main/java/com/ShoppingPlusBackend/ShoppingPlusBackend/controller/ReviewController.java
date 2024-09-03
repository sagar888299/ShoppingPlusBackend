package com.ShoppingPlusBackend.ShoppingPlusBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ShoppingPlusBackend.ShoppingPlusBackend.Services.MentorRepository;
import com.ShoppingPlusBackend.ShoppingPlusBackend.Services.ReviewRepository;
import com.ShoppingPlusBackend.ShoppingPlusBackend.Services.UserRepository;
import com.ShoppingPlusBackend.ShoppingPlusBackend.model.MentorModel;
import com.ShoppingPlusBackend.ShoppingPlusBackend.model.ReviewModel;
import com.ShoppingPlusBackend.ShoppingPlusBackend.model.UserModel;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class ReviewController {
	
	   @Autowired
	    private MentorRepository mentorRepository;
	   
		@Autowired
		private UserRepository userRepository;
		
		 @Autowired
		private ReviewRepository reviewRepository;
		 
		    @GetMapping("/getReview")
		    public List<ReviewModel> getAllReviews() {
		        return reviewRepository.findAll();
		    }
		 
		    @PostMapping("/saveReview")
		    public ReviewModel saveReview( @RequestBody ReviewRequest reviewRequest) {
		    	Long userId = reviewRequest.getUserId();
		        Long mentorId = reviewRequest.getMentorId();
		        Long mentorRating = reviewRequest.getRating();
		        String writtenReview = reviewRequest.getReview();

		        // Fetch the student and course from the repository
		        UserModel user = userRepository.findById(userId).orElseThrow();
		        MentorModel mentor = mentorRepository.findById(mentorId).orElseThrow();

		        // Create a new Enrollment object
		        ReviewModel reviewModel = new ReviewModel();
		        reviewModel.setUser(user);
		        reviewModel.setMentor(mentor);
		        reviewModel.setRating(mentorRating);
		        reviewModel.setWrittenReview(writtenReview);
		        reviewRepository.save(reviewModel);
		        // Recalculate and update the mentor's average rating
		        Double newAverageRating = reviewRepository.findAverageRatingByMentorId(mentorId);
		        mentor.setAverageRating(newAverageRating != null ? newAverageRating : 0.0);
		        mentorRepository.save(mentor);

		        // Save the enrollment
		        return reviewModel;
		    }
}
