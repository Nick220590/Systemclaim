package com.java.systemclaim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.systemclaim.model.Client;

@Repository("clientRepository")
public interface ClientRepository extends JpaRepository<Client, Integer> {
	Client findByLoginAndPassword(String login, String password);
}
