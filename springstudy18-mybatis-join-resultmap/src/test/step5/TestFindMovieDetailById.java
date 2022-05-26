package test.step5;

import org.kosta.myproject.model.mapper.MovieMapper;
import org.kosta.myproject.model.vo.MovieVO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFindMovieDetailById {
	public static void main(String[] args) {
		/*
		 * IOC Container 생성
		 * DI방식으로 의존객체를 가져와 객체 생성(구현체 생성)
		 */
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("spring-mybatis-config.xml");
		MovieMapper mapper = (MovieMapper) ctx.getBean("movieMapper");
		
		int movieId=1;
		
	
		MovieVO vo = mapper.findMovieById(movieId);
		
		if(vo != null) {
		System.out.println("영화 아이디: "+ vo.getMovieId());
		System.out.println("영화 제목: "+  vo.getTitle());
		System.out.println("영화 장르: "+  vo.getGenre());
		System.out.println("영화 관객수: "+  vo.getAttendance());
		System.out.println("감독 아이디: "+  vo.getDirectorVO().getDirectorId());
		System.out.println("감독 명: "+  vo.getDirectorVO().getDirectorName());
		System.out.println("감독 소개: "+  vo.getDirectorVO().getIntro());
		}else {
			System.out.println("아이디에 해당하는 영화정보가 존재하지 않습니다.");
		}
		
		ctx.close();
	}
}
