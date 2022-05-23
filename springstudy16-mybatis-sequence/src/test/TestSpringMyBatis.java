package test;

import java.util.List;

import org.kosta.myproject.model.ProductMapper;
import org.kosta.myproject.model.ProductVO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;

public class TestSpringMyBatis {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		//proxy object test
		ProductMapper mapper = (ProductMapper) ctx.getBean("productMapper");
		//System.out.println(mapper);
		
		
		 //총 상품 수 조회
			/*
			 * int totalCount = mapper.getTotalCount();
			 * System.out.println("총 상품수 : "+totalCount);
			 */
	
		//maker 종류를 list로 조회
		/*
		 * List<String> makerList = mapper.findMakerList(); for(String list:makerList) {
		 * System.out.println(list); }
		 */
		
		//상품번호로 특정 상품정보 조회
		/*
		 * int productNo = 1; ProductVO vo = mapper.findProductByNo(productNo);
		 * System.out.println(vo);
		 */
		
		//검색조건이 여러개(매개변수)일 경우
		/*
		 * ProductVO paramVO = new ProductVO(); paramVO.setMaker("애플");
		 * paramVO.setPrice(50); List<ProductVO> list =
		 * mapper.findProductListByMakerAndPrice(paramVO); for(ProductVO vo:list){
		 * System.out.println(vo); };
		 */
		
		//price가 30미만인 list 조회
		int price = 100;
		List<ProductVO> list = mapper.findProductListLessThanPrice(price);
		for(ProductVO vo:list) {
			System.out.println(vo);
		}
		ctx.close();
	}
}
