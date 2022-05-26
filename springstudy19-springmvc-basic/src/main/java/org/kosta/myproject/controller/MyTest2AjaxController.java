package org.kosta.myproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.kosta.myproject.model.CustomerVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyTest2AjaxController {
	@RequestMapping("AjaxTest.do")
	public String AjaxTest() {
		return "ajax-test"; //viewResolver 정책에 따라 view로 응답
	}
	
	/*
	 * ajax 통신은 웹페이지가 아닌 필요 데이터만 응답하는 비동기 통신.
	 * 이를 위해 @ResponseBody 어노테이션 명기, 해당 메서드에서 리턴하는 정보를 클라이언트에게 데이터로 전달
	 * 	ㄴ 핵심 : 웹페이지가 아닌, 데이터로 클라이언트에게 전달
	 */
	@RequestMapping("testAjax1") //for ajax mapping
	@ResponseBody //없으면 view name으로 전송
	//resoponsebody .. 웹페이지가 아닌, 응답 데이터를 return
	public String testAjax1(String userId) {
		return userId+" ajax response";
	}
	
	@RequestMapping("testAjax2") //for ajax mapping
	@ResponseBody
	/*
	 * jackson data bind 라이브러리에 의해, @ResponseBody가 명시된 메서드가 리턴하는
	 * ajax 통신 데이터들은 자동적으로 jsonObject/Array로 변환되어 전달된다.
	 *  ㄴ VO, DTO, Map, List 등..
	 */
	public CustomerVO testAjax2(String customerId) {
		//ajax 통신시, return하는 데이터는 자동적으로 jsonObject로 변환되어 전달된다.
		System.out.println(customerId);
		return new CustomerVO("springking", "아이유", "용인");
	}
	
	@RequestMapping("testAjax3") //for ajax mapping
	@ResponseBody
	public List<String> TestAjax3(String id){
		System.out.println(id+"를 전달받았습니다.");
		List<String> list = new ArrayList<String>();
		list.add("방화수류정");
		list.add("융건륭");
		return list;
	}
}
