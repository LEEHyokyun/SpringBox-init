package org.kosta.myproject.controller;

import org.kosta.myproject.mapper.ProductMapper;
import org.kosta.myproject.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	private ProductMapper productMapper;
	
	@Autowired
	public ProductController(ProductMapper productMapper) {
		super();
		this.productMapper = productMapper;
	}


	@RequestMapping("findProductByNo")
	public String findProductByNo(int productNo, Model model) {
		ProductVO pvo = productMapper.findProductByNo(productNo);
		
		if(pvo == null) {
			return "findbyno-fail";
		}else {
			model.addAttribute("pvo", pvo);
			return "findbyno-ok";
		}
	}

	
	
}
