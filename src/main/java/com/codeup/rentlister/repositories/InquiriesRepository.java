package com.codeup.rentlister.repositories;
import com.codeup.rentlister.models.Inquiries;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InquiriesRepository extends JpaRepository<Inquiries, Integer> {

	Inquiries findInquiryById(int id);
	List<Inquiries> findInquiriesByPropertyId(int id);

}
