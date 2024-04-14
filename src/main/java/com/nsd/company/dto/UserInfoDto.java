package com.nsd.company.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * @author Nilesh Dhawale
 * @since 09-April-2024
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class UserInfoDto {

	private Integer userId;

	private String userFirstName;

	private String userLastName;

	private LocalDateTime userBirthDate;

	private String userImage;

	private String about;

	private List<AssetsDto> assetsDtos;
}
