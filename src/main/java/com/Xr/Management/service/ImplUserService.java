package com.Xr.Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Xr.Management.dto.UserRequest;
import com.Xr.Management.enums.Role;
import com.Xr.Management.exception.UserAuthorizationException;
import com.Xr.Management.repository.UserRepository;
import com.Xr.Management.utils.Messages;


@Service
public class ImplUserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public void authenticate(String username, String password) throws Exception {
		try {
			System.out.println("authenticate ===>01 username :"+username);
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			System.out.println("authenticate ===>02 ");
		} catch (BadCredentialsException e) {
			throw new BadCredentialsException("INVALID_CREDENTIALS", e);
		} catch (DisabledException e) {
			throw new DisabledException("USER_DISABLED", e);
		}
	}

	public void validateUserRequest(UserRequest userRequest) {

		if (userRequest.getEmail() != null && userRepository.findByEmail(userRequest.getEmail()) != null) {
			throw new UserAuthorizationException(Messages.EMAIL_ALREADY_EXISTS);
		}

		if (userRequest.getRole() == Role.ADMIN && userRepository.existsByRole(Role.ADMIN)) {
			throw new UserAuthorizationException(Messages.EMAIL_ALREADY_EXISTS_NOT_ANOTHER_ADMIN);
		}

		if (userRequest.getCountryCode() == null) {
			userRequest.setCountryCode(Messages.DEFAULT_VALUE);
		}
	}

	public void updateUserRequest(UserRequest userRequest) {
		if (userRequest.getRole() == Role.ADMIN && userRepository.existsByRole(Role.ADMIN)) {
			throw new UserAuthorizationException(Messages.EMAIL_ALREADY_EXISTS_NOT_ANOTHER_ADMIN);
		}

		if (userRequest.getCountryCode() == null) {
			userRequest.setCountryCode(Messages.DEFAULT_VALUE);
		}

		if (userRequest.getPassword() != null) {
			userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		}
	}
}
