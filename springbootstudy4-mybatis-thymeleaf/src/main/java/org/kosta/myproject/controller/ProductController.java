package org.kosta.myproject.controller;

import java.util.List;

import org.kosta.myproject.mapper.ProductMapper;
import org.kosta.myproject.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {
	private ProductMapper productMapper;

	@Autowired
	public ProductController(ProductMapper productMapper) {
		super();
		this.productMapper = productMapper;
	}
	
	@GetMapping("getProductTotalCount") //for ajax
	@ResponseBody 
	public int getTotalCount() {
		int result = productMapper.getTotalCount();
		return result;
	}
	
	@GetMapping("getProductTotalCount2") //for thymeleaf
	public String getTotalCount2(Model model) {
		/*
		 * html에서 EL을 통해 데이터를 확보하는 부분(변수명)에 유의
		 * return html 파일명 :: #id 명
		 */
		int result = productMapper.getTotalCount();
		model.addAttribute("productCount", result);
		return "step10-ajax::#productCountView2";
	}
	
	@GetMapping("findAllProductList")
	@ResponseBody
	public List<ProductVO> findAllProductList(){
		List<ProductVO> list = productMapper.findAllProductList();
		return list;
	}
	
	@GetMapping("findAllProductList2")
	public String findAllProductList2(Model model){
		List<ProductVO> list = productMapper.findAllProductList();
		model.addAttribute("productList", list);
		return "step12-ajax::#productBody"; //생성할 html파일을 삽입할 태그의 요소
	}
	
}