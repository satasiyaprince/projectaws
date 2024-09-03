package com.Xr.Management.service;

import com.Xr.Management.dto.LoginResponse;

public interface LoginServiceImpl {

	LoginResponse login(String email, String password) throws Exception;

}
