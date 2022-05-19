package org.kosta.myproject.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
	//private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void deleteProduct(String id) {
		System.out.println("core: 상품삭제");
	}
	
	@Override
	public void findProductById(String id) {
		System.out.println("core: 아이디로 상품 검색");
		//logger.debug("ProductService Impl findProductById 검색, 키워드: {}",id);
	}
	@Override
	public void findProductListByMaker(String maker) {
		System.out.println("core: 제조사로 상품 리스트 검색");
		//logger.debug("ProductService Impl findProductListByMaker 검색, 키워드: {}",maker);
	}	
	
	@Override
	public void findProductListByPriceAndMaker(int price, String maker) {
		System.out.println("core: 가격과 제조사로 상품 리스트 검색");
		//logger.debug("ProductService Impl findProductListByMaker 검색, 키워드: {}, {}",price, maker);
	}
}
