package com.nsd.company.apis;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nsd.company.dto.ApiResponse;

/**
 * @author Nilesh Dhawale
 * @since 08-April-2024
 * @version 1.0
 */

@RestController
@RequestMapping("/company")
public class CompanyApis {

	@GetMapping
	public ResponseEntity<ApiResponse<Object>> getData() {
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.put("map", "How are you my friend");
		return ResponseEntity.ok(ApiResponse.success("response", map));
	}
}
