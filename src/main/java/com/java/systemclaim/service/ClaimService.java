package com.java.systemclaim.service;

import java.util.List;

import com.java.systemclaim.model.Claim;

public interface ClaimService {
	List<Claim> getAll();/*auti exist*/
	List<Claim> getByStatus(String status);	
	void updateClaimStatusById(String status, Integer claimId);
}
