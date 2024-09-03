package com.Xr.Management.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Xr.Management.dto.UserResponse;
import com.Xr.Management.enums.Role;
import com.Xr.Management.model.User;
import com.Xr.Management.service.UserServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
//@Tag(name = "User API")
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;

	@PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@PreAuthorize("hasAuthority('admin:access')")
	public ResponseEntity<Object> createEntity(@RequestParam String name, @RequestParam String email,
			@RequestParam String password, @RequestParam(required = false) String countryCode,
			@RequestParam String number, @RequestParam Role role,
			@RequestParam(value = "multipartFile", required = false) MultipartFile multipartFile) throws IOException {
	
		UserResponse userData = userServiceImpl.createUserDetails(name, email, password, countryCode, number, role,
				multipartFile);
		return ResponseEntity.ok(userData);

	}

	@GetMapping("/userById/{id}")
	@PreAuthorize("hasAuthority('user:get-user')")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		User user = userServiceImpl.getUser(id);
		return ResponseEntity.ok(user);
	}

	@PutMapping(value = "/update/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@PreAuthorize("hasAuthority('user:profile-update')")
	public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestParam(required = false) String name,
			@RequestParam(required = false) String email, @RequestParam(required = false) String password,
			@RequestParam(required = false) String countryCode, @RequestParam(required = false) String number,
			@RequestParam(required = false) Role role,
			@RequestParam(value = "multipartFile", required = false) MultipartFile multipartFile) throws IOException {
		UserResponse userData = userServiceImpl.updateUser(id, name, email, password, countryCode, number, role,
				multipartFile);
		return ResponseEntity.ok(userData);

	}

	@PostMapping("/reset-password")
	@PreAuthorize("hasAuthority('pms-user:reset-password')")
	public ResponseEntity<String> resetPassword(@RequestParam String email, @RequestParam String newPassword) {
		boolean success = userServiceImpl.resetPassword(email, newPassword);
		if (success) {
			return ResponseEntity.ok("Password reset successfully.");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found.");
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> softDeleteUser(@PathVariable Long id) {
		userServiceImpl.softDeleteUser(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/users")
	public List<UserResponse> getUserData(@RequestParam(defaultValue = "1") int pageNumber,
			@RequestParam(defaultValue = "5") int pageSize) {
		return userServiceImpl.getUserData(pageNumber, pageSize);
	}

}
