package org.kosta.myproject.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.myproject.vo.MemberVO;

@Mapper //mapper - proxy pattern
public interface MemberMapper {

	int getTotalMemberCount();

	MemberVO findMemberById(String id);

	List<String> getAddressList();

	List<MemberVO> findMemberListByAddress(String address);
	
}
