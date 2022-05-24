package test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.kosta.myproject.model.ProductMapper;
import org.kosta.myproject.model.ProductVO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;

public class TestSpringMyBatis {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		//proxy object test
		ProductMapper mapper = (ProductMapper) ctx.getBean("productMapper");
		System.out.println(mapper);
		
		
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
		/*
		 * int price = 100; List<ProductVO> list =
		 * mapper.findProductListLessThanPrice(price); for(ProductVO vo:list) {
		 * System.out.println(vo); }
		 */
		
		//가격 구간별 상품리스트 조회
		/*
		 * int highPrice = 140; int lowPrice = 40; Map<String, Integer> paramMap = new
		 * HashMap<String, Integer>(); paramMap.put("HIGHPRICE", highPrice);
		 * paramMap.put("LOWPRICE", lowPrice); //매개변수로 전달 List<ProductVO> list =
		 * mapper.findProductListByLowPriceAndHighPrice(paramMap); for(ProductVO
		 * vo:list) { System.out.println(vo); }
		 */
		
		//특정 문자열 검색 및 조회
		/*
		 * String keyword = "이"; List<ProductVO> list =
		 * mapper.findProductListLikeKeyword(keyword); for(ProductVO vo:list) {
		 * System.out.println(vo); }
		 */
		
		//findAll
		
		/*
		 * List<ProductVO> list = mapper.findAllProductListOrderByNoDesc(); //productNo
		 * desc for(ProductVO vo:list) { System.out.println(vo); }
		 */
		 
		
		//상품등록(table column과 인스턴스 변수가 매핑이 안되는 상턔)
		/*
		ProductVO pvo = new ProductVO("3분짜장","오뚜기", 1300);
		int result = mapper.registerProduct(pvo);
		//insert, update, delete 등의 executeUpdate 후 영향을 준 row의 수
		System.out.println(pvo+ " 등록이 완료되었습니다.");
		*/
		
		//상품등록시 매핑이 정상적으로 되도록 설정(시퀀스 정보를 출력할 수 있도록 설정)
		/*
		 * ProductVO pvo = new ProductVO("3분 라자냐","오뚜기", 1500); int result =
		 * mapper.registerProductWithSequence(pvo); System.out.println(pvo);
		 */
		
		String maker="오뚜기";
		int result = mapper.deleteProductByMaker(maker);
		System.out.println(maker+ " 상품을 삭제하였습니다: "+result+" column have been deleted.");
		List<ProductVO> list = mapper.findAllProductListOrderByNoDesc(); //productNo * desc
		for(ProductVO vo:list) { System.out.println(vo); }
		
		ctx.close();
	}
}
