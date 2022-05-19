package org.kosta.myproject.model;

public interface MemberService {

	void findMemberById(String id);

	void registerMember(String memberInfo);

	void findMemberListByAddress(String address);

}