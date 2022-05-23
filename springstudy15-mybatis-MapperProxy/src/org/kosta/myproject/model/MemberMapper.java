package org.kosta.myproject.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
//MemberMapper interface 구현체를 자동생성하는 proxy 객체를 생성
public interface MemberMapper {

	List<Map<String, String>> findAllMemberList();

}
