package org.kosta.myproject.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper //mybatis proxy 객체 생성을 위한 어노테이션 -> 해당 인터페이스의 구현체를 자동 생성
public interface AccountMapper {

	void registerAccount(AccountVO accountVO);

	void registerAccountByMap(HashMap<String, Object> map);

	List<AccountVO> findAllAccountVOList();

	List<Map<String, Object>> findAllAccountMapList();

}