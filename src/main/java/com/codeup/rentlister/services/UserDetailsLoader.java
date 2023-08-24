package com.codeup.rentlister.services;
import com.codeup.rentlister.models.User;
import com.codeup.rentlister.models.UserWithRoles;
import com.codeup.rentlister.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {
	private final UserRepository Users;

	public UserDetailsLoader(UserRepository Users) {
		this.Users = Users;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = Users.findUserByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("No user found for " + username);
		}

		return new UserWithRoles(user);
	}
}
