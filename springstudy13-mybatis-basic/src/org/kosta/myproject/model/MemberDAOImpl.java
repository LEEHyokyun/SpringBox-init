package org.kosta.myproject.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	private SqlSessionTemplate template;
	
	@Autowired
	public MemberDAOImpl(SqlSessionTemplate template) {
		super();
		this.template = template;
	}
	
	@Override
	public MemberVO findMemberById(String id) {
		//MemberMapper에서 지정한 name으로 mybatis 방식으로 DB접근
		//selectOne(mapper id, 검색조건)
		return template.selectOne("member.findMemberById", id);
	}

	@Override
	public void insertMember(MemberVO vo) {
		// TODO Auto-generated method stub
		template.insert("member.insertMember", vo);
	}

	@Override
	public List<MemberVO> findAllMemberList() {
		// TODO Auto-generated method stub
		return template.selectList("member.findAllMemberList");
	}

	@Override
	public void updateMember(MemberVO voForUpdate) {
		// TODO Auto-generated method stub
		template.update("member.updateMember", voForUpdate);
	}

	@Override
	public void deleteMemberByNameAndAddress(MemberVO paramVO) {
		// TODO Auto-generated method stub
		template.delete("member.deleteMemberByNameAndAddress", paramVO);
	}
}
