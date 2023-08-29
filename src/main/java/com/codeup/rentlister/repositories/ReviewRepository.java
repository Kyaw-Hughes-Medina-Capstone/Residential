package com.codeup.rentlister.repositories;
import com.codeup.rentlister.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
	Review findReviewById(int id);
}