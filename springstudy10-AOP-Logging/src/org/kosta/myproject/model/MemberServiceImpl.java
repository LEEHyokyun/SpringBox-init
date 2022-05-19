package org.kosta.myproject.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service //Component 계열 어노테이션
public class MemberServiceImpl implements MemberService {
	//private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void findMemberById(String id) {
		System.out.println("core: id로 회원 검색");
		//logger.debug("MemberService Impl finMemberById 검색, 키워드: {}",id);
	}
	@Override
	public void registerMember(String memberInfo) {
		System.out.println("core: 회원가입");
	}
	@Override
	public void findMemberListByAddress(String address) {
		System.out.println("core: 주소로 회원 검색");
		//logger.debug("MemberService Impl finMemberListById 검색, 키워드: {}",address);
	}
}
