package com.codeup.rentlister.repositories;
import com.codeup.rentlister.models.Property;
import com.codeup.rentlister.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import org.springframework.data.repository.CrudRepository;
@Repository
public interface OwnerRepository extends CrudRepository<Property, Long> {
}


