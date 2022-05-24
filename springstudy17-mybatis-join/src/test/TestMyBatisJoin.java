package test;

import java.util.List;
import java.util.Map;

import org.kosta.myproject.model.HumanResourceMapper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMyBatisJoin {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("spring-mybatis-config.xml");
		HumanResourceMapper mapper = (HumanResourceMapper) ctx.getBean("humanResourceMapper");
		System.out.println(mapper);
		// join을 통해 부서정보 리스트 출력
		/*
		 * List<Map<String, Object>> list = mapper.findAllDepartmentList();
		 * for(Map<String, Object> map:list) { System.out.println(map); }
		 */
		
		//사원번호를 통해 부서리스트 출력
		/*
		 * int empno = 1; Map<String, String> map =
		 * mapper.findEmployeeAndDepartmentByEmpNo(empno); if(map == null) {
		 * System.out.println("사원 정보가 존재하지 않습니다."); }else {
		 * System.out.println(map.get("ENAME")+"에 대한 사원정보가 존재합니다: "+map.get("DNAME")); }
		 */
		
		//outer join
		/*
		 * List<Map<String, Object>> list = mapper.findEmpAndDeptListOuterJoin();
		 * for(Map<String, Object> map:list) { System.out.println(map); //map에는 rs.next,
		 * 즉 sql 결과(column)가 존재하는 경우에만 구성된다. }
		 */
		
		//집계
		List<Map<String, Object>> list = mapper.findEmpAndDeptGroupByDeptNo();
		for(Map<String, Object> map:list) {
			System.out.println(map.get("DEPTNO")+"번 부서의 사원수는 "+map.get("EMP_COUNT")+"명 입니다.");
		}
		ctx.close();
	}
}
