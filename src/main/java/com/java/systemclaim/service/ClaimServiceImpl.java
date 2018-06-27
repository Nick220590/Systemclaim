package com.java.systemclaim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.systemclaim.model.Claim;
import com.java.systemclaim.repository.ClaimRepository;

@Service("claimService")
public class ClaimServiceImpl implements ClaimService {

	@Autowired
	private ClaimRepository claimRepository;
	
	@Override
	@Transactional
	public List<Claim> getAll() {
		return claimRepository.findAll();
	}

	@Override
	@Transactional
	public List<Claim> getByStatus(String status) {
		return claimRepository.findByStatus(status);
	}

	@Override
	@Transactional
	public void updateClaimStatusById(String status, Integer claimId) {
		claimRepository.setClaimStatusById(status, claimId);	
	}

}
