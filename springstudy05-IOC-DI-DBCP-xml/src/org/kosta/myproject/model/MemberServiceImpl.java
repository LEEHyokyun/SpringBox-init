package org.kosta.myproject.model;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO;
	
	@Autowired //**생성자가 하나일 경우 AutoWired는 생략가능하지만 기재하는 것을 권장
	public MemberServiceImpl(MemberDAO memberDAO) {
		super();
		this.memberDAO = memberDAO;
		System.out.println("**MemberServiceImp 생성자, DAO구현체 주입");
	}

	@Override
	public MemberVO findMemberById(String id) throws SQLException {
		return memberDAO.findMemberById(id);
	}
}
