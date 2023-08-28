package com.codeup.rentlister.repositories;
import com.codeup.rentlister.models.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {

	Property findPropertyById(int id);
	Property findPropertyByAddress(String address);
	List<Property> findAll();


}