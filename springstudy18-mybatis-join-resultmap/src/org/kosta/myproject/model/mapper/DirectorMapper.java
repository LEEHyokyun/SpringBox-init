package org.kosta.myproject.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.myproject.model.vo.DirectorVO;

@Mapper 
//MyBatis Proxy 객체(구현체) 생성을 위한 Mapper 설정
public interface DirectorMapper {

	int register(DirectorVO directorVO);

	List<DirectorVO> findAllDirectorList();

}
