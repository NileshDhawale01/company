package com.nsd.company.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nsd.company.Exceptions.CompanyException;
import com.nsd.company.dto.ApiResponse;
import com.nsd.company.dto.UserInfoDto;
import com.nsd.company.services.UserInfoService;

/**
 * @author Nilesh Dhawale
 * @since 09-April-2024
 * @version 1.0
 */

@RestController
@RequestMapping("/user")
public class UserApis {

	@Autowired
	private UserInfoService userInfoService;

	@PostMapping
	public ResponseEntity<ApiResponse<Object>> addUser(@RequestBody UserInfoDto userInfoDto) throws CompanyException {
		return userInfoService.addUser(userInfoDto);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<ApiResponse<Object>> getUserById(@PathVariable Integer userId) throws CompanyException {
		return userInfoService.getUserById(userId);
	}

	@PutMapping("/{userId}")
	public ResponseEntity<ApiResponse<Object>> updateUser(@PathVariable Integer userId,
			@RequestBody UserInfoDto userInfoDto) throws CompanyException {
		return userInfoService.updateUser(userId, userInfoDto);
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse<Object>> deleteUser(@PathVariable Integer userId) throws CompanyException {
		return userInfoService.deleteUser(userId);
	}

	@GetMapping
	public ResponseEntity<ApiResponse<Object>> getAllUsers() {
		return userInfoService.getAllUsers();
	}
}
