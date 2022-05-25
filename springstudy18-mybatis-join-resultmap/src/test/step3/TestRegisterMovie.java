package test.step3;

import org.kosta.myproject.model.mapper.MovieMapper;
import org.kosta.myproject.model.vo.DirectorVO;
import org.kosta.myproject.model.vo.MovieVO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestRegisterMovie {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext("spring-mybatis-config.xml");
		MovieMapper mapper = (MovieMapper) ctx.getBean("movieMapper");
		
		DirectorVO directorVO = new DirectorVO();
		directorVO.setDirectorId(1);
		//MovieVO movieVO = new MovieVO("기생충", "코미디", 2000, directorVO);
		MovieVO movieVO = new MovieVO("설국열차", "SF", 2000, directorVO);
		mapper.register(movieVO);
		
		ctx.close();
	}
}
