package com.codeup.rentlister.repositories;
import com.codeup.rentlister.models.Inquiries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiriesRepository extends JpaRepository<Inquiries, Integer> {

	Inquiries findInquiryById(int id);
}