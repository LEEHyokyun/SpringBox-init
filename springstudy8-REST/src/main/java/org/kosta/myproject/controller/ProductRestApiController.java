package org.kosta.myproject.controller;

import java.util.List;

import org.kosta.myproject.mapper.ProductMapper;
import org.kosta.myproject.vo.ProductVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
//API를 활용할 경우(map, 지도) Rest를 주축으로 구성
//분산환경에서 service를 받는 주축이 Rest
public class ProductRestApiController {
	private final ProductMapper productMapper;
	
	@GetMapping("/product") //json array 응답
	public List<ProductVO> getAllProductList(){
		return productMapper.getAllProductList();
	}
	
	/*
	 * ResponseEntity : rest 응답시 상태코드(Http status code)와 응답메시지를 전송하기 위한 클래스
	 * 404 - 자원 없음
	 * 500 - 서버 내부 오류
	 * 405 - 메소드 허용 안됨(주로 메소드 명이 다를 경우)
	 * 400 - 문법 오류
	 * 200 - 정상 수행
	 */
	@GetMapping("/product/{id}")
	public ResponseEntity<ProductVO> findProductById(@PathVariable("id") String id){
		ProductVO productVO = productMapper.findProductById(id);
		if(productVO == null)
			return new ResponseEntity<ProductVO>(HttpStatus.NOT_FOUND); //상품정보 없을 경우 404 Not Found
		else
			return new ResponseEntity<ProductVO>(productVO, HttpStatus.OK); //정상수행일 경우에 상품정보와 200 응답
	}
	
	@PostMapping("/product")
	public ResponseEntity<String> registerProduct(ProductVO productVO){
		productMapper.registerProduct(productVO);
		return new ResponseEntity<String>(productVO.getId()+" 등록완료", HttpStatus.OK);
	}
	
	@PutMapping("/product")
	public ResponseEntity<String> updateProduct(ProductVO productVO){
		int result = productMapper.updateProduct(productVO);
		
		if(result==0)
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		else	
			return new ResponseEntity<String>(productVO.getId()+" 수정완료", HttpStatus.OK);
	}
	
	@DeleteMapping("/product")
	public ResponseEntity<String> deleteProduct(String id){
		int result = productMapper.deleteProduct(id);
		
		if(result == 0)
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<String>(id+" 삭제 완료", HttpStatus.OK);
	}
}
