package org.kosta.myproject.controller;

import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController //@Controller, @ResponseBody
@Slf4j
public class MyRestController {
	@GetMapping("/item/{id}")
	public String testGet(@PathVariable("id") String id) { //@PathVariable, url 정보를 기반으로 변수를 할당 받는다.
		log.info("rest get");
		return id+": id 아이템 정보 확보";
	}
	
	@PostMapping("/item")
	public String testPost(String id) { //url 정보를 기반으로 변수를 생성 한다.
		log.info("rest post");
		return id+": id 아이템 정보 생성";
	}
	
	@PutMapping("/item")
	public String testPut(String id) { //url 정보를 기반으로 변수를 수정 한다.
		log.info("rest post");
		return id+": id 아이템 정보 생성";
	}
	
	@DeleteMapping("/item")
	public String testDelete(String id) { //url 정보를 기반으로 변수를 제거 한다.
		log.info("rest post");
		return id+": id 아이템 정보 삭제";
	}
}
