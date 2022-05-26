package test.step4;

import java.util.List;

import org.kosta.myproject.model.mapper.MovieMapper;
import org.kosta.myproject.model.vo.MovieVO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFindAllMovieList {
	public static void main(String[] args) {
		/*
		 * IOC Container 생성
		 * DI방식으로 의존객체를 가져와 객체 생성(구현체 생성)
		 */
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("spring-mybatis-config.xml");
		MovieMapper mapper = (MovieMapper) ctx.getBean("movieMapper");
		
		List<MovieVO> list = mapper.findAllMovieList();
		for(MovieVO mvo:list) {
			//movie, director name
			System.out.println(mvo+" 영화의 감독은 "+mvo.getDirectorVO().getDirectorName()+"입니다.");
		}
		
		ctx.close();
	}
}
