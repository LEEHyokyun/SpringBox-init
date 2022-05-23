package org.kosta.myproject.model;

public class AccountVO {
	private int id;
	private String name;
	private int balance;

	public AccountVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountVO(int id, String name, int balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "AccountVO [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}

}
