package org.kosta.myproject.model;

import java.util.List;
import java.util.Map;

public interface HumanResourceMapper {

	List<Map<String, Object>> findAllDepartmentList();

	Map<String, String> findEmployeeAndDepartmentByEmpNo(int empno);

	List<Map<String, Object>> findEmpAndDeptListOuterJoin();

	List<Map<String, Object>> findEmpAndDeptGroupByDeptNo();

}
