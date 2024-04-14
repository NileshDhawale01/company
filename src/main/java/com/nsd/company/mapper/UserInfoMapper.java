package com.nsd.company.mapper;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.nsd.company.dto.UserInfoDto;
import com.nsd.company.entities.UserInfo;
import com.nsd.company.util.FunctionUtil;

/**
 * @author Nilesh Dhawale
 * @since 09-April-2024
 * @version 1.0
 */

public class UserInfoMapper {

	private UserInfoMapper() {
	}

	public static final Function<UserInfoDto, Optional<UserInfo>> TO_USER_INFO = e -> FunctionUtil.evalMapper(e,
			UserInfo.class);

	public static final Function<UserInfo, Optional<UserInfoDto>> TO_USER_INFO_DTO = e -> FunctionUtil.evalMapper(e,
			UserInfoDto.class);

	public static final Function<Collection<UserInfo>, List<UserInfoDto>> TO_USER_INFO_DTOS = e -> e.stream()
			.map(s -> TO_USER_INFO_DTO.apply(s).get()).collect(Collectors.toList());
}
