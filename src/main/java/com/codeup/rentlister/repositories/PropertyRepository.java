package com.codeup.rentlister.repositories;
import com.codeup.rentlister.models.Property;
import com.codeup.rentlister.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Integer> {

	Property findPropertyById(long id);
	Property findPropertyByAddress(String address);
	Property findPropertyByZip(int zip);
	Property findPropertyByTenant(User tenant);
	Property findPropertyByTenantId(int userId);
}