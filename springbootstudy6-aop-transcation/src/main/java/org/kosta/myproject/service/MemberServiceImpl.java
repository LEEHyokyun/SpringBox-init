package org.kosta.myproject.service;

import org.kosta.myproject.mapper.MemberMapper;
import org.kosta.myproject.mapper.PointMapper;
import org.kosta.myproject.vo.MemberVO;
import org.kosta.myproject.vo.PointVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor // lombok에서 제공, final 상수 field를 매개변수로 가지는 생성자 생성
@Slf4j
//비즈니스 로직 캡슐화, 트랜잭션 제어
public class MemberServiceImpl implements MemberService {
	private final MemberMapper memberMapper;
	private final PointMapper pointMapper;

	@Override
	public int getTotalMemberCount() {
		// TODO Auto-generated method stub
		return memberMapper.getTotalMemberCount();
	}

	@Override
	public MemberVO findMemberById(String id) {
		// TODO Auto-generated method stub
		return memberMapper.findMemberById(id);
	}

	@Override
	public PointVO findPointById(String id) {
		// TODO Auto-generated method stub
		return pointMapper.findPointById(id);
	}
	
	@Transactional //AOP 기반 트랜잭션 처리 
	@Override
	public void registerMemberAndPoint(MemberVO memberVO, PointVO pointVO) {
		// TODO Auto-generated method stub
		/*
		 * for transaction
		 * 회원정보, 포인트 정보 모두 정상 등록시 commit
		 * 세부 작업 진행 도중 문제 발생시 rollback
		 */
		memberMapper.register(memberVO);
		log.debug("member register {}", memberVO);
		//트랜잭션 간 문제 발생
		//pointVO.setId("문제가 될 아이디"); //참조 무결성 조건에 위배, unChecked Excpetion(RUntime)
		pointMapper.register(pointVO);
		log.debug("point register {}", pointVO);
	}
	
	// business layer - interface 추출 필수
	/*
	 * public MemberServiceImpl(MemberMapper memberMapper, PointMapper pointMapper)
	 * { super(); this.memberMapper = memberMapper; this.pointMapper = pointMapper;
	 * }
	 */

}
