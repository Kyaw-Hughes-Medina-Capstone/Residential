package com.codeup.rentlister.repositories;
import com.codeup.rentlister.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

	Review findReviewById(int id);
	List<Review> findReviewsByPropertyId(long id);

}