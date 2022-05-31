package org.kosta.myproject.controller;

import org.kosta.myproject.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	private ProductMapper productMapper;

	@Autowired
	public HomeController(ProductMapper productMapper) {
		super();
		this.productMapper = productMapper;
	}

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("message", "spring boot!!");
		model.addAttribute("totalProductCount", productMapper.getTotalProductCount());
		return "home";
	}

}
