package com.java.systemclaim.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the claim database table.
 * 
 */
@Entity
@NamedQuery(name="Claim.findAll", query="SELECT c FROM Claim c")
public class Claim implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private double bid;

	@Temporal(TemporalType.DATE)
	@Column(name="due_date")
	private Date dueDate;

	private String request;

	private String status;

	//bi-directional many-to-one association to Client
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_client")
	private Client client;

	public Claim() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBid() {
		return this.bid;
	}

	public void setBid(double bid) {
		this.bid = bid;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getRequest() {
		return this.request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}