package com.codeup.rentlister.repositories;
import com.codeup.rentlister.models.Property;
import com.codeup.rentlister.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends CrudRepository<Property, Long> {
    Property findOwnerById(int id);
    Property findOwnerByAddress(String address);
    Property findOwnerByZip(int zip);
    Property findOwnerByTenant(User tenant);
    Property findOwnerByTenantId(int userId);
}

