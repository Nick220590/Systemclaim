package com.java.systemclaim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.systemclaim.model.Claim;

@Repository("claimRepository")
public interface ClaimRepository extends JpaRepository<Claim, Integer> {
	 List<Claim> findByStatus(String status);	 
	 @Modifying
	 @Query("update Claim c set c.status = ?1 where c.id = ?2")
	 void setClaimStatusById(String status, Integer claimId);
}
