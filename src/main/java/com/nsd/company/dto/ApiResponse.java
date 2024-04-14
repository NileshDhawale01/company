package com.nsd.company.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Nilesh Dhawale
 * @since 08-April-2024
 * @version 1.0
 */
public class ApiResponse<T> {

	private Boolean success;

	@JsonInclude(Include.NON_NULL)
	private String message;

	@JsonInclude(Include.NON_NULL)
	private T data;

	private ApiResponse(Boolean success, String message, T data) {
		this.success = success;
		this.message = message;
		this.data = data;
	}

	private ApiResponse(Boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public Boolean isSuccess() {
		return this.success;
	}

	public String getMessage() {
		return this.message;
	}

	public T getData() {
		return this.data;
	}

	public static <T> ApiResponse<T> success(String message, T data) {
		return new ApiResponse<T>(true, message, data);
	}

	public static <T> ApiResponse<T> success(T data) {
		return new ApiResponse<T>(true, null, data);
	}

	public static <T> ApiResponse<T> error(String message) {
		return new ApiResponse<T>(false, message, null);
	}

	public static <T> ApiResponse<T> error(String message, T data) {
		return new ApiResponse<T>(false, message, data);
	}
}
