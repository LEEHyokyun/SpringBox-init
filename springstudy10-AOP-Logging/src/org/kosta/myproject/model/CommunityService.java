package org.kosta.myproject.model;

import org.springframework.stereotype.Service;

@Service
public class CommunityService {
	public void findList(String keyword) {
		System.out.println("core: 키워드로 리스트 탐색");
	}

	public void findListByUser(String user) {
		System.out.println("core: user 명으로 리스트 탐색");
	}

	public void register() {
		System.out.println("core: 커뮤니티 데이터 등록");
	}
}
