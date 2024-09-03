package com.Xr.Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.Xr.Management.model.User;
import com.Xr.Management.security.UserPrincipal;

/**
 * Implementation class of customUser details for JWT token.
 * 
 *
 */
@Component
public class CustomUserDetailsServices implements UserDetailsService {

	@Autowired
	private UserService userService;

	/**
	 * This is default constructor {@link CustomUserDetailsServices}
	 */
	public CustomUserDetailsServices() {
		// default constructor
	}

	/**
	 * This method is used to get user details by email for authentication purpose
	 * And it's used by JWTAuthenticationFilter
	 * 
	 * This method is default method of {@link UserDetailsService} Which take
	 * request param as string. So that we again make query to get
	 * {@link UserPrincipal} by id.
	 */

	@Transactional
	@Override
	public UserPrincipal loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userService.findByEmail(email);
		return UserPrincipal.createUser(user.getId());
	}

	/**
	 * This method is used to get user details by id for authentication purpose.
	 * 
	 * @param id id of user
	 * @return {@link UserDetails}
	 * @throws UsernameNotFoundException {@link UsernameNotFoundException}
	 */
	@Transactional
	public UserDetails loadUserByIds(long id) throws UsernameNotFoundException {
		User user = userService.findUserById(id);
		return UserPrincipal.createUser(user.getId());
	}

	@Transactional
	public UserDetails loadUserById(long userId) {
	    User user = userService.findUserById(userId);
	    if (user != null) {
	        System.out.println("User found: " + user.getEmail());
	        System.out.println("Roles: " + user.getRole());
	    } else {
	        System.out.println("No user found with ID: " + userId);
	    }
	    return new org.springframework.security.core.userdetails.User(
	            user.getEmail(), user.getPassword(), user.getRole().getAuthorities());
	}


}


