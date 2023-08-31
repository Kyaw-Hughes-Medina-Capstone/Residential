package com.codeup.rentlister.repositories;
import com.codeup.rentlister.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findUserById(long id);
	User findUserByUsername(String username);
}