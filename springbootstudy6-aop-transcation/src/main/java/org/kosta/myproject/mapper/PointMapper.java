package org.kosta.myproject.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.kosta.myproject.vo.PointVO;

@Mapper
public interface PointMapper {

	public PointVO findPointById(String id);

	public int register(PointVO pointVO);

}
