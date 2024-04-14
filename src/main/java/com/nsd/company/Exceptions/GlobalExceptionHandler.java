package com.nsd.company.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nsd.company.dto.ApiResponse;

/**
 * @author Nilesh Dhawale
 * @since 08-April-2024
 * @version 1.0
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ResponseBody
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse<String>> companyException(CompanyException exception) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.error(exception.getMessage()));
	}

//	@ResponseBody
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<ApiResponse<String>> allExceptions(Exception exception) {
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.error(exception.getMessage()));
//	}
}
