package org.kosta.myproject.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeVO {
	private int employeeNo;
	private String name;
	private int salary;
	private DepartmentVO departmentVO;

}
