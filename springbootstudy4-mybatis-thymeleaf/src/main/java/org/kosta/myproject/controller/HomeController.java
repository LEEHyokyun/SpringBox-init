package org.kosta.myproject.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.kosta.myproject.vo.MemberVO;
import org.kosta.myproject.vo.MyProductVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("message", "hello spring boot!");
		model.addAttribute("imageName", "thymeleaf.png");
		return "index";
	}

	@RequestMapping("study1")
	public String study1(Model model) {
		model.addAttribute("memberVO", new MemberVO("java", "a", "아이유", "오리"));
		return "step01-text-expression";
		// templates/step01-text-expression.html
	}

	@RequestMapping("study2")
	public String study2(Model model) {
		model.addAttribute("memberVO", new MemberVO("spring", "a", "손흥민", "토트넘"));
		return "step02-form-obejct-expression";
	}

	@RequestMapping("study3")
	public String study3(Model model) {
		model.addAttribute("pageNo", 7);
		model.addAttribute("keyword", "spring");
		model.addAttribute("orderId", 3);
		model.addAttribute("maker", "LG");
		return "step03-link-href-qeuryString";
	}

	@RequestMapping("board/list")
	public String study3result1(int pageNo, String keyword) {
		System.out.println(pageNo);
		return "step03-result1-param";
	}

	@RequestMapping("order/details")
	public String study3result2(int orderId, String maker) {
		return "step03-result2-param";
	}

	@RequestMapping("study4")
	public String study4(HttpSession session) {
		session.setAttribute("member", new MemberVO("thymeleaf", "a", "송강호", "용인"));
		return "step04-session-param";
	}

	@RequestMapping("study4-test")
	public String study4Test() {
		return "step04-result";
	}

	@RequestMapping("study5")
	public String study5(Model model) {
		model.addAttribute("product", new MyProductVO(1, "테라", "하이트진로", 1410, true));
		model.addAttribute("size", "L");
		return "step05-if-unless-switch";
	}

	@RequestMapping("study6")
	public String study6(Model model) {
		List<MemberVO> memberList = new ArrayList<MemberVO>();
		memberList.add(new MemberVO("java", "a", "아이유", "종로"));
		memberList.add(new MemberVO("thymeleaf", "a", "손흥민", "토트넘"));
		memberList.add(new MemberVO("springboot", "a", "황희찬", "울버햄튼"));
		model.addAttribute("memberList", memberList);

		List<HashMap<String, String>> mapList = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("ID", "java");
		map1.put("NAME", "손흥민");
		map1.put("ADDRESS", "토트넘");
		mapList.add(map1);

		HashMap<String, String> map2 = new HashMap<String, String>();
		map2.put("ID", "spring");
		map2.put("NAME", "황희찬");
		map2.put("ADDRESS", "울버햄튼");
		mapList.add(map2);

		model.addAttribute("mapList", mapList);

		return "step06-loop-each";
	}

	@RequestMapping("study7")
	public String study7(Model model) {
		ArrayList<MyProductVO> productList = new ArrayList<MyProductVO>();
		productList.add(new MyProductVO(1, "테라", "하이트진로", 1410, true));
		productList.add(new MyProductVO(2, "카스", "오비", 1410, false));
		productList.add(new MyProductVO(3, "참이슬", "하이트진로", 1300, false));
		productList.add(new MyProductVO(4, "처음처럼", "롯데", 1500, true));
		model.addAttribute("productList", productList);
		return "step07-loop-each-lists";
	}
	
	@RequestMapping("study8")
	public String study8(Model model) {
		model.addAttribute("startPageNo", 5);
		model.addAttribute("endPageNo", 9);
		return "step08-loop-numbers-pagination";
	}
	
	@RequestMapping("study9")
	public String study9() {
		return "step09-javascript";
	}
	
	@RequestMapping("study10")
	public String study10() {
		return "step10-ajax";
	}
	
	@RequestMapping("study11")
	public String study11() {
		return "step11-ajax";
	}
	
	@RequestMapping("study12")
	public String study12() {
		return "step12-ajax";
	}
}
