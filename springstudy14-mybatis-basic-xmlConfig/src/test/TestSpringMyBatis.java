package test;

import java.util.List;
import java.util.Map;

import org.kosta.myproject.model.AccountDAO;
import org.kosta.myproject.model.AccountVO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringMyBatis {
	public static void main(String[] args) {
		//xml 기반의 spring-mybatis 설정 및 MyBatisDAO 구현
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mybatis-config.xml");
		/*
		 * System.out.println(ctx.getBean("dbcp"));
		 * System.out.println(ctx.getBean("sqlSessionFactory"));
		 * System.out.println(ctx.getBean("sqlSessionTemplate"));
		 */
		//System.out.println(ctx.getBean("accountDAOImpl"));
		AccountDAO dao = (AccountDAO) ctx.getBean("accountDAOImpl");
		
		/*
		 * AccountVO accountVO = new AccountVO(3, "강하늘", 300);
		 * dao.registerAccount(accountVO); System.out.println("계좌등록완료");
		 */
		
		//계좌등록시 Map을 이용하여 계좌정보 전달
		/*
		 * HashMap<String, Object> map = new HashMap<String, Object>(); map.put("ID",
		 * 2); map.put("NAME", "손흥민"); map.put("BALANCE", 2000);
		 * dao.registerAccountByMap(map); System.out.println("map을 이용하여 계좌등록을 마쳤습니다.");
		 */
		  
		  //계좌리스트 조회 : resultType : AccountVO / Map
			/*
			 * List<AccountVO> list = dao.findAllAccountVOList(); for(AccountVO vo:list) {
			 * System.out.println(vo); }
			 */
		  
		  List<Map<String, Object>> list = dao.findAllAccountMapList();
		  for(Map<String, Object> map:list) {
			  	
			  	System.out.println(map);
		  }
		ctx.close();
	}
}
