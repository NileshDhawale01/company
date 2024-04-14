package com.nsd.company.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nsd.company.Exceptions.CompanyException;
import com.nsd.company.constants.MessageConstants;
import com.nsd.company.constants.UserInfoConstants;
import com.nsd.company.dto.ApiResponse;
import com.nsd.company.dto.UserInfoDto;
import com.nsd.company.entities.UserInfo;
import com.nsd.company.mapper.UserInfoMapper;
import com.nsd.company.repo.UserInfoRepo;
import com.nsd.company.services.UserInfoService;

/**
 * @author Nilesh Dhawale
 * @since 09-April-2024
 * @version 1.0
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Autowired
	private UserInfoRepo userInfoRepo;

	@Override
	public ResponseEntity<ApiResponse<Object>> addUser(UserInfoDto userInfoDto) throws CompanyException {

		if (Objects.nonNull(userInfoDto)) {
			UserInfo userInfo = UserInfoMapper.TO_USER_INFO.apply(userInfoDto)
					.orElseThrow(() -> new CompanyException(UserInfoConstants.DTO_TO_ENTITY_ERROR));
			UserInfo info = userInfoRepo.save(userInfo);
			return ResponseEntity.ok(ApiResponse.success(UserInfoConstants.USER_ADDED, info.getUserId()));
		}
		return ResponseEntity.ok(ApiResponse.error(UserInfoConstants.REQUIRED_DATA_MISSING, userInfoDto));
	}

	@Override
	public ResponseEntity<ApiResponse<Object>> getUserById(Integer userId) throws CompanyException {

		UserInfo userInfo = userInfoRepo.findById(userId)
				.orElseThrow(() -> new CompanyException(MessageConstants.COMPANY, MessageConstants.ID, userId));
		return ResponseEntity.ok(ApiResponse.success(UserInfoConstants.USER_DATA,
				UserInfoMapper.TO_USER_INFO_DTO.apply(userInfo).orElse(null)));
	}

	@Override
	public ResponseEntity<ApiResponse<Object>> updateUser(Integer userId, UserInfoDto userInfoDto)
			throws CompanyException {

		UserInfo userInfo = userInfoRepo.findById(userId)
				.orElseThrow(() -> new CompanyException(MessageConstants.COMPANY, MessageConstants.ID, userId));

		if (Objects.nonNull(userInfo)) {
			UserInfo info = UserInfoMapper.TO_USER_INFO.apply(userInfoDto)
					.orElseThrow(() -> new CompanyException(UserInfoConstants.DTO_TO_ENTITY_ERROR));
			info.setUserId(userId);
			userInfoRepo.save(info);
			return ResponseEntity.ok(ApiResponse.success(UserInfoConstants.USER_UPDATED, userId));
		}
		return ResponseEntity.ok(ApiResponse.error(UserInfoConstants.USER_NOT_UPDATED, userId));
	}

	@Override
	public ResponseEntity<ApiResponse<Object>> deleteUser(Integer userId) throws CompanyException {

		UserInfo userInfo = userInfoRepo.findById(userId)
				.orElseThrow(() -> new CompanyException(MessageConstants.COMPANY, MessageConstants.ID, userId));
		userInfo.setDeletedBy(1);
		userInfo.setDeletedDate(LocalDateTime.now());
		userInfoRepo.save(userInfo);
		return ResponseEntity.ok(ApiResponse.success(UserInfoConstants.USER_DELETED, userId));
	}

	@Override
	public ResponseEntity<ApiResponse<Object>> getAllUsers() {

		List<UserInfo> userInfos = userInfoRepo.findAll();
		return ResponseEntity
				.ok(ApiResponse.success("All User Data.", UserInfoMapper.TO_USER_INFO_DTOS.apply(userInfos)));
	}

}