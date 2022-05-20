package test;

import java.util.List;

import org.kosta.myproject.model.MemberDAO;
import org.kosta.myproject.model.MemberVO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;

public class TestMyBatis {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		MemberDAO dao = (MemberDAO) ctx.getBean("memberDAOImpl");
		//System.out.println(dao.findMemberById("java"));
		
		//회원정보 등록
		
		  MemberVO vo = new MemberVO("mybatis", "a", "이승우", "수원");
		  if(dao.findMemberById(vo.getId())==null) { dao.insertMember(vo); //data type
		  /* interface 참조, 불러오는 객체는 실제 구현체인 mmeberDAOImpl *인터페이스가 없다면 해당 class를
		  상속받는(extend) 별도의 클래스를 생성후 참조 System.out.println("등록완료"); */
		  }else {
		  System.out.println("아이디가 중복됩니다."); }
		 
		
		//회원정보 리스트
		/*
		 * List<MemberVO> list = dao.findAllMemberList(); for(MemberVO voInList:list) {
		 * System.out.println(voInList); }
		 */
		
		//회원정보수정
		/*
		 * MemberVO voForUpdate = new MemberVO("mybatis", "a", "황의조", "성남");
		 * dao.updateMember(voForUpdate);
		 * System.out.println("회원정보 수정 완료: "+dao.findMemberById(voForUpdate.getId()));
		 */
		
		  //회원정보삭제
		  MemberVO paramVO = new MemberVO(null, null, "황의조", "성남");
		  //VO대신 Map 형태로 전달가능
		  dao.deleteMemberByNameAndAddress(paramVO);
		  //System.out.println(dao.findMemberById("mybatis"));
		  System.out.println("삭제완료");
		  
		ctx.close();
	
	}
}	
