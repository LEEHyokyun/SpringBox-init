package org.kosta.myproject.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepartmentMapper {

	int getAllDepartmentCount();

}