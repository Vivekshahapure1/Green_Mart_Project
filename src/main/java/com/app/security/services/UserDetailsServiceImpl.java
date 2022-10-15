package com.app.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.User;
import com.app.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	/*It overrides the loadUserByUsername for fetching user details from the database using the username.
	 *  The Spring Security Authentication Manager calls this method for getting the user details from 
	 *  the database when authenticating the user details provided by the user. Here we are getting the 
	 *  user details from a hardcoded User List.*/
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return UserDetailsImpl.build(user);
	}

}
