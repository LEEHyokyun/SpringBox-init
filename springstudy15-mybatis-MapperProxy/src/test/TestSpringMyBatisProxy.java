package test;

import java.util.List;
import java.util.Map;

import org.kosta.myproject.model.MemberMapper;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringMyBatisProxy {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mybatis-config.xml");
		MemberMapper mm = (MemberMapper) ctx.getBean("memberMapper");
		System.out.println("memberMapper: "+ mm);
		List<Map<String, String>> list = mm.findAllMemberList();
		for(Map<String, String> map:list) {
			System.out.println(map);
		}
		ctx.close();
	}
}
