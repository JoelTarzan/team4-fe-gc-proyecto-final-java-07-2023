package com.rest.aurumrh.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.rest.aurumrh.dao.IUserDAO;

@Component
public class LibraryUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserDAO iUserDAO;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return iUserDAO.findByEmail(email)
				.map(LibraryUserDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("No user found"));
	}
}