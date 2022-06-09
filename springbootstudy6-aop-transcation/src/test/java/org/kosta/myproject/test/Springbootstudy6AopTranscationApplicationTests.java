package org.kosta.myproject.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kosta.myproject.mapper.MemberMapper;
import org.kosta.myproject.mapper.PointMapper;
import org.kosta.myproject.service.MemberService;
import org.kosta.myproject.vo.MemberVO;
import org.kosta.myproject.vo.PointVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j // lombok에서 제공
class Springbootstudy6AopTranscationApplicationTests {
	// @Resource
	// repositoy 계층에서 DAO에 접근하기 위한 component
	// resource
	PointMapper pointMapper;
	MemberMapper memberMapper;
	MemberService memberService;
	
	//junit 4 ver 에서는 생성자에 의한 DI 지원하지 않는다 현재는 JUNIT5 으로 생성자에 의한 DI 지원하며..이때 @AutoWired 어노테이션 명기가 필요하다.
	@Autowired
	public Springbootstudy6AopTranscationApplicationTests(PointMapper pointMapper, MemberMapper memberMapper, MemberService memberService) {
		super();
		this.pointMapper = pointMapper;
		this.memberMapper = memberMapper;
		this.memberService = memberService;
	}

	@Test
	void contextLoads() {
		log.debug("point Mapper debug: {}", pointMapper);
		log.debug("member Mapper debug: {}", memberMapper);
		log.debug("member Serivce debug: {}", memberService);
		//mapper와는 달리, 구현체가 일반적인 spring방식으로 만들어지는 방식
	}
	
	@Test
	void findPointById() {
		String id = "java";
		PointVO pointVO = pointMapper.findPointById(id);
		Assertions.assertNotNull(pointVO);
	}
	
	@Test
	void findMemberById() {
		String id = "java";
		MemberVO memberVO = memberMapper.findMemberById(id);
		Assertions.assertNotNull(memberVO);
	}
	
	@Test
	void getTotalMemberCount() {
		//int count = memberMapper.getTotalMemberCount();
		int count = memberService.getTotalMemberCount();
		Assertions.assertEquals(1, count);
	}
	
	@Test
	void checkMemberAndPoint(){
		String id = "java";
		MemberVO memberVO = memberService.findMemberById(id);
		log.info("member: {}", memberVO);
		PointVO pointVO = memberService.findPointById(id);
		log.info("point: {}",pointVO);
	}
	
	@Test
	void registerMember() {
		MemberVO memberVO = new MemberVO("spring", "a", "손흥민", "오리");
		int result = memberMapper.register(memberVO);
		Assertions.assertEquals(1, result);
	}
	
	@Test
	void registerPoint() {
		PointVO pointVO = new PointVO("spring", 10000, "cgv");
		int result = pointMapper.register(pointVO);
		Assertions.assertEquals(1, result);
	}
	
	@Test
	void registerMemberAndPoint() {
		MemberVO memberVO = new MemberVO("java", "a", "이강인", "오리");
		PointVO pointVO = new PointVO("java", 20000, "cgv");
		log.info("memberService {}", memberService.getClass());
		/*
		 * EnhancerBySpringCGLIB
		 * transaction 처리시, 일반 객체가 아닌 AOP 기반으로 proxy 객체를 통해 트랜잭션이 처리
		 * 이때 exception 발생시 rollback 처리된다.
		 */
		memberService.registerMemberAndPoint(memberVO, pointVO);
	}
}
