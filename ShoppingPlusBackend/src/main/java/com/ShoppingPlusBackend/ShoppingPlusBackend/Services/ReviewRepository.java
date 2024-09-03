package com.ShoppingPlusBackend.ShoppingPlusBackend.Services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ShoppingPlusBackend.ShoppingPlusBackend.model.ReviewModel;


@Repository
public interface ReviewRepository extends JpaRepository<ReviewModel, Long>{

	   @Query("SELECT AVG(r.rating) FROM ReviewModel r WHERE r.mentor.mentorId = :mentorId")
	    Double findAverageRatingByMentorId(Long mentorId);
}
