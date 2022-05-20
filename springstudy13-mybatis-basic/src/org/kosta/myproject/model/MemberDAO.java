package org.kosta.myproject.model;

import java.util.List;

public interface MemberDAO {

	MemberVO findMemberById(String id);

	void insertMember(MemberVO vo);

	List<MemberVO> findAllMemberList();

	void updateMember(MemberVO voForUpdate);

	void deleteMemberByNameAndAddress(MemberVO paramVO);

}