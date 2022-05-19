package org.kosta.myproject.model;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
	@Override
	public void findProductById() {
		System.out.println("아이디로 상품 검색");
	}
	
	@Override
	public void findProductByMaker() {
		System.out.println("제조사로 상품 검색");
	}
	
	@Override
	public void deleteProduct() {
		System.out.println("상품정보를 삭제하였습니다.");
	}
}
