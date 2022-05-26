package test.step2;

import java.util.List;

import org.kosta.myproject.model.mapper.DirectorMapper;
import org.kosta.myproject.model.vo.DirectorVO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFindAllDirectorList {
	public static void main(String[] args) {
		/*
		 * IOC Container 생성
		 * DI방식으로 의존객체를 가져와 객체 생성(구현체 생성)
		 */
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("spring-mybatis-config.xml");
		DirectorMapper mapper = (DirectorMapper) ctx.getBean("directorMapper");
		
		List<DirectorVO> list = mapper.findAllDirectorList();
		for(DirectorVO directorVO:list) {
			System.out.println(directorVO);
		}
		
		ctx.close();
	}
}
