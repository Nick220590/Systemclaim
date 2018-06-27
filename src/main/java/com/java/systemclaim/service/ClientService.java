package com.java.systemclaim.service;

import java.util.List;

import com.java.systemclaim.model.Client;

public interface ClientService {
	Client addClient(Client client);
    void delete(int id);
    Client getByID(int id);
    Client editClient(Client client);
    List<Client> getAll();
    Client getByLoginAndPassw(String login, String password);
}
