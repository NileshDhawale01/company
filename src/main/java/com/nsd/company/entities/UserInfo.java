package com.nsd.company.entities;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Nilesh Dhawale
 * @since 09-April-2024
 * @version 1.0
 */

@SuppressWarnings("deprecation")
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user_info")
@Where(clause = "deleted_by is null")
public class UserInfo extends Audit {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "user_first_name")
	private String userFirstName;

	@Column(name = "user_last_name")
	private String userLastName;

	@Column(name = "user_birth_date")
	private LocalDateTime userBirthDate;

	@Column(name = "user_image")
	private String userImage;

	@Column(name = "about")
	private String about;
	
	@OneToMany(mappedBy = "userInfo")
	private List<Assets> assets;

}
