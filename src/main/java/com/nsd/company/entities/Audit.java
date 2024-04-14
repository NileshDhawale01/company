package com.nsd.company.entities;

import static java.time.LocalDateTime.now;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;
/**
 * @author Nilesh Dhawale
 * @since 09-April-2024
 * @version 1.0
 */

@Embeddable
@MappedSuperclass
@Getter
@Setter
public class Audit implements Serializable {
	private static final long serialVersionUID = -406869010295120058L;

	@Column(name = "created_by", nullable = false, updatable = false)
	private Integer createdBy;

	@Column(name = "created_date", nullable = false, columnDefinition = "TIMESTAMP", updatable = false)
	private LocalDateTime createdDate;

	@Column(name = "updated_by")
	private Integer updatedBy;

	@Column(name = "updated_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime updatedDate;

	@Column(name = "deleted_by")
	protected Integer deletedBy;

	@Column(name = "deleted_date", columnDefinition = "TIMESTAMP")
	private LocalDateTime deletedDate;

	@PrePersist
	public void beforPersist() {

//		if (nonNull(getContext()) && nonNull(getContext().getAuthentication())
//				&& nonNull(getContext().getAuthentication().getDetails())) {
//			try {
//				Integer user = (Integer) getContext().getAuthentication().getDetails();
//				this.createdBy = user;
//			} catch (Exception e) {
//				this.createdBy = 1;
//			}
//		} else {
		this.createdBy = 1;
//		}
		this.createdDate = now();
	}

	@PreUpdate
	public void beforUpdate() {

		/*
		 * if (nonNull(getContext()) && nonNull(getContext().getAuthentication()) &&
		 * nonNull(getContext().getAuthentication().getDetails())) { Integer user =
		 * (Integer) getContext().getAuthentication().getDetails(); this.updatedBy =
		 * user; } else { this.updatedBy = 1; }
		 */
		this.updatedBy = 1;
		this.updatedDate = now();
	}

	@PreRemove
	public void beforDelete() {

		/*
		 * if (nonNull(getContext()) && nonNull(getContext().getAuthentication()) &&
		 * nonNull(getContext().getAuthentication().getDetails())) { Integer user =
		 * (Integer) getContext().getAuthentication().getDetails(); this.deletedBy =
		 * user; } else { this.deletedBy = 1; }
		 */

		this.deletedBy = 1;
		this.deletedDate = now();
	}

}
