package com.Xr.Management.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.Xr.Management.dto.UserResponse;
import com.Xr.Management.enums.Role;
import com.Xr.Management.model.User;



public interface UserServiceImpl {

	boolean resetPassword(String email, String newPassword);

	void softDeleteUser(Long id);

	List<UserResponse> getUserData(int pageNumber, int pageSize);

	User getUser(Long id);

	UserResponse createUserDetails(String name, String email, String password, String countryCode, String number,
			Role role, MultipartFile multipartFile) throws IOException;

	UserResponse updateUser(Long id, String name, String email, String password, String countryCode, String number,
			Role role, MultipartFile multipartFile) throws IOException;

}
