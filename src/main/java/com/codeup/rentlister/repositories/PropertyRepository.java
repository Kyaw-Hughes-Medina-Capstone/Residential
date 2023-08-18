package com.codeup.rentlister.repositories;
import com.codeup.rentlister.models.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Integer> {

	Property findPropertyById(int id);
	Property findPropertyByAddress(String address);
}