package org.kosta.myproject.model;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Override
	public void findMemberById() {
		// 1) common concern을 해당 메소드에 직접 주입(비효율적)
		System.out.println("id를 통해 회원을 탐색하였습니다.");
	}
	
	@Override
	public void findMemberByName() {
		System.out.println("name를 통해 회원을 탐색하였습니다.");
	}
	
	@Override
	public void registerMember() {
		System.out.println("회원정보를 등록하였습니다.");
	}
	
	@Override
	public void findMemberByAddress() {
		System.out.println("address를 통해 회원을 탐색하였습니다.");
	}
}
