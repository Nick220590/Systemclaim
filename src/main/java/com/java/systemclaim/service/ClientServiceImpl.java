package com.java.systemclaim.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.systemclaim.model.Client;
import com.java.systemclaim.repository.ClientRepository;

@Service("clientService")
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	@Transactional
	public Client addClient(Client client) {
		return clientRepository.saveAndFlush(client);
	}

	@Override
	@Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public Client editClient(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Client> getAll() {
		return clientRepository.findAll();
	}

	@Override
	@Transactional
	public Client getByLoginAndPassw(String login, String password) {
		return clientRepository.findByLoginAndPassword(login, password);
	}

	@Override
	@Transactional
	public Client getByID(int id) {
//		return clientRepository.getOne(id);
		return clientRepository.findOne(id);
	}

}
