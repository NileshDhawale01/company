package com.nsd.company.entities;

import org.hibernate.annotations.Where;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author Nilesh Dhawale
 * @since 09-April-2024
 * @version 1.0
 */

@SuppressWarnings("deprecation")
@Entity
@Table(name = "assets")
@Where(clause = "deleted_by is null")
public class Assets {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "asset_id")
	private Integer assetId;
	
	@Column(name = "asset_name")
	private String assetName;
	
	@Column(name = "asset_number")
	private String assetNumber;
	
	@Column(name = "about ")
	private String about;
	
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "user_id")
	private UserInfo userInfo;
}
