package com.java.systemclaim.model;

import java.io.Serializable;
import javax.persistence.*;


import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String login;

	private String name;

	private String password;

	private String status;

	//bi-directional many-to-one association to Claim
	@OneToMany(cascade = {CascadeType.ALL}, mappedBy="client")
	/*@NotFound(action = NotFoundAction.IGNORE)*/
	private List<Claim> claims = new  ArrayList<>();

	public Client() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Claim> getClaims() {
		return this.claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

	public Claim addClaim(Claim claim) {
		getClaims().add(claim);
		claim.setClient(this);

		return claim;
	}

	public Claim removeClaim(Claim claim) {
		getClaims().remove(claim);
		claim.setClient(null);

		return claim;
	}

}