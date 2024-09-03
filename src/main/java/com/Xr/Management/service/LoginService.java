package com.Xr.Management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Xr.Management.dto.LoginResponse;
import com.Xr.Management.exception.UserAuthorizationException;
import com.Xr.Management.model.User;
import com.Xr.Management.repository.UserRepository;
import com.Xr.Management.security.JwtTokenProvider;
import com.Xr.Management.utils.Messages;

@Service
public class LoginService implements LoginServiceImpl {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private ImplUserService implUserService;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Autowired
	private CustomUserDetailsServices customUserDetailsService;

	@Override
	public LoginResponse login(String email, String password) throws Exception {

		System.out.println("login ======>01");
		if (email == null || password == null) {
			throw new UserAuthorizationException(Messages.EMAIL_OR_PASSWORD_NULL_ERROR);
		}
		System.out.println("login ======>02");

		User user = userRepository.findByEmail(email);
		System.out.println("login ======>03");

		LoginResponse loginResponse = new LoginResponse();
		System.out.println("login ======>04");

		if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
			System.out.println("login ======>05");

			throw new UserAuthorizationException(Messages.CREDENTIALS);
		}
		System.out.println("login ======>06");

//		implUserService.authenticate(email, password);
		System.out.println("login ======>07");

		loginResponse = LoginResponse.getUserResponse(user);
		loginResponse
				.setJwt(LoginService.getJwtToken(user, customUserDetailsService, jwtTokenProvider, passwordEncoder));

		return loginResponse;
	}

	public static String getJwtToken(User user, CustomUserDetailsServices customUserDetailService,
			JwtTokenProvider jwtTokenProvider, PasswordEncoder bCryptPasswordEncoder) {

		UserDetails userDetails = customUserDetailService.loadUserByIds(user.getId());
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,
				bCryptPasswordEncoder.encode(user.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		return jwtTokenProvider.generateJwtToken(authentication);
	}


}
