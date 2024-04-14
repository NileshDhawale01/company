package com.nsd.company.dto;

import com.nsd.company.entities.UserInfo;

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
public class AssetsDto {

	private Integer assetId;

	private String assetName;

	private String assetNumber;

	private String about;

	private UserInfo userInfo;
}
