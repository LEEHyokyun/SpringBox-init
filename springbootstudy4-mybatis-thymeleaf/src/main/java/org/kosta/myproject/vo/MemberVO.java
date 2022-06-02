package org.kosta.myproject.vo;

import java.io.Serializable;

//session에 저장되는 정보는 직렬화를 하여 정보 유지
//세션에 저장되는 객체는 직렬화시 서버 리로드가 되어도 유지 가능(Container 차원에서)
public class MemberVO implements Serializable{
	private static final long serialVersionUID = 4319098642053468565L;
	private String id;
	private String password;
	private String name;
	private String address;

	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberVO(String id, String password, String name, String address) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		//System.out.println("getName()");
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		//System.out.println("getAddress()");
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", name=" + name + ", address=" + address + "]";
	}
	
	//for thymeleaf
	public boolean isNextPageGroup() {
		System.out.println("isNextPageGroup");
		return true;
	}
	
	//for thymeleaf
	public String register() {
		System.out.println("register");
		return "등록완료";
	}
}
