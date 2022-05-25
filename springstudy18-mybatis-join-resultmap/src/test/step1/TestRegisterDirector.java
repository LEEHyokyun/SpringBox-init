package test.step1;

import org.kosta.myproject.model.mapper.DirectorMapper;
import org.kosta.myproject.model.vo.DirectorVO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestRegisterDirector {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("spring-mybatis-config.xml");
		DirectorMapper mapper = (DirectorMapper) ctx.getBean("directorMapper");
		
		//등록 감독정보
		//DirectorVO directorVO = new DirectorVO("봉준호", "아카데미상 수상");
		DirectorVO directorVO = new DirectorVO("고레에다", "황금종려상 수상");
		int result = mapper.register(directorVO);
		System.out.println("감독정보가 등록되었습니다: "+result+" Columns have been inserted.");
		
		ctx.close();
	}
}
