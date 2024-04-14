package com.nsd.company.services;

import org.springframework.http.ResponseEntity;

import com.nsd.company.Exceptions.CompanyException;
import com.nsd.company.dto.ApiResponse;
import com.nsd.company.dto.UserInfoDto;

/**
 * @author Nilesh Dhawale
 * @since 09-April-2024
 * @version 1.0
 */
public interface UserInfoService {
	public ResponseEntity<ApiResponse<Object>> addUser(UserInfoDto userInfoDto) throws CompanyException;

	public ResponseEntity<ApiResponse<Object>> getUserById(Integer userId) throws CompanyException;

	public ResponseEntity<ApiResponse<Object>> updateUser(Integer userId, UserInfoDto userInfoDto)
			throws CompanyException;

	public ResponseEntity<ApiResponse<Object>> deleteUser(Integer userId) throws CompanyException;

	public ResponseEntity<ApiResponse<Object>> getAllUsers();
}
