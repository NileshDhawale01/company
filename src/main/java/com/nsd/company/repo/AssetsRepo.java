package com.nsd.company.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nsd.company.entities.Assets;

/**
 * @author Nilesh Dhawale
 * @since 09-April-2024
 * @version 1.0
 */

@Repository
public interface AssetsRepo extends JpaRepository<Assets, Integer> {

}
