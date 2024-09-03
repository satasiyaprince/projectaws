package com.Xr.Management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Xr.Management.dto.LoginResponse;
import com.Xr.Management.service.LoginServiceImpl;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("member/auth")
@RequiredArgsConstructor
@Api(value = "Auth Controller", description = "REST API for Authorization", tags = { "Auth Controller" })
public class LoginController {

	@Autowired
	LoginServiceImpl loginServiceImpl;

	@PostMapping("/login")
	public ResponseEntity<Object> loginUser(@RequestParam String email, @RequestParam String password)
			throws Exception {
		System.out.println("email :" + email);
		LoginResponse userResponse = loginServiceImpl.login(email, password);
		return ResponseEntity.ok(userResponse);
	}

}
