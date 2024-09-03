package com.Xr.Management.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Xr.Management.dto.UserRequest;
import com.Xr.Management.dto.UserResponse;
import com.Xr.Management.enums.Role;
import com.Xr.Management.exception.UserException;
import com.Xr.Management.mapper.UserMapper;
import com.Xr.Management.model.User;
import com.Xr.Management.repository.UserRepository;
import com.Xr.Management.utils.Constants;
import com.Xr.Management.utils.Messages;
import com.Xr.Management.utils.Utils;

@Service
public class UserService implements UserServiceImpl {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	ImplUserService implUserService;

	@Override
	public UserResponse createUserDetails(String name, String email, String password, String countryCode, String number,
			Role role, MultipartFile multipartFile) throws IOException {
	
		UserRequest userRequest = UserRequest.builder().name(name).email(email).password(password)
				.countryCode(countryCode).number(number).role(role).build();
		


		implUserService.validateUserRequest(userRequest);


		if (multipartFile != null && !multipartFile.isEmpty()) {


			String photoUrl = Utils.saveFile(multipartFile, Constants.PROFILE_PREFIX);
			userRequest.setPhoto(photoUrl);
		}


		userRequest.setPassword(passwordEncoder.encode(userRequest.getPassword()));
	
		User user = userMapper.toEntity(userRequest);


		user.setDeleted(false);
		user.setMultipartFile(multipartFile);


		User newlyCreatedUser = userRepository.save(user);
		return userMapper.toDto(newlyCreatedUser);
	}

	@Override
	public UserResponse updateUser(Long id, String name, String email, String password, String countryCode,
			String number, Role role, MultipartFile multipartFile) throws IOException {

		UserRequest userRequest = UserRequest.builder().name(name).email(email).password(password)
				.countryCode(countryCode).number(number).role(role).build();

		implUserService.updateUserRequest(userRequest);

		User userData = userRepository.findById(id);
		userMapper.update(userRequest, userData);

		if (multipartFile != null && !multipartFile.isEmpty()) {
			String photoUrl = Utils.saveFile(multipartFile, Constants.PROFILE_PREFIX);
			userData.setPhoto(photoUrl);
		}

		User updatedUser = userRepository.save(userData);
		return userMapper.toDto(updatedUser);
	}

	@Override
	public boolean resetPassword(String email, String newPassword) {
		User User = userRepository.findByEmail(email);
		if (User != null) {
			User.setPassword(passwordEncoder.encode(newPassword));
			userRepository.save(User);
			return true;
		}
		return false;
	}

	@Override
	public void softDeleteUser(Long id) {
		User user = userRepository.findByIdAndDeletedFalse(id)
				.orElseThrow(() -> new UserException(Messages.USER_NOT_FOUND_OR_ALREADY_DELETED));
		user.setDeleted(true);
		userRepository.save(user);
	}

	@Override
	public User getUser(Long id) {
		return userRepository.findByIdAndDeletedFalse(id)
				.orElseThrow(() -> new UserException(Messages.USER_NOT_FOUND_OR_HAS_BEEN_DELETED));
	}

	@Override
	public List<UserResponse> getUserData(int pageNumber, int pageSize) {
		if (pageNumber < 1 || pageSize < 1) {
			throw new UserException(Messages.PAGE_NUMBER_AND_PAGE_SIZE);
		}
//		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
		Pageable pageable = new PageRequest(pageNumber - 1, pageSize);

		Page<User> users = userRepository.findByDeletedFalse(pageable);
		List<UserResponse> userData = users.getContent().stream().map(userMapper::toDto).collect(Collectors.toList());
		return userData;

	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);

	}

	public User findUserById(Long userId) {
		return userRepository.findOne(userId);
	}

}
