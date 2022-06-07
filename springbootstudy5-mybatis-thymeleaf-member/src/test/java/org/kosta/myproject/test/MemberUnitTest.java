package org.kosta.myproject.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kosta.myproject.mapper.MemberMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // spring frame work - junit 연동하여 test 지원
public class MemberUnitTest {
	private Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());
	private final MemberMapper memberMapper;
	
	@Autowired //생성자를 통한 주입 가능(SpringBoot junit 4 이상 버전, 그 이하는 field주입만 가능)
	public MemberUnitTest(MemberMapper memberMapper) {
		super();
		this.memberMapper = memberMapper;
	}

	@Test
	public void testMemberMapper() {
		logger.debug("test member mapper {}", memberMapper);
	}
	
	@Test
	public void getTotalMemberCount() {
		int totalCount = memberMapper.getTotalMemberCount();
		Assertions.assertNotEquals(0, totalCount);
	}
	
	@Test
	public void getAddressList() {
		System.out.println(memberMapper.getAddressList());
	}
}
