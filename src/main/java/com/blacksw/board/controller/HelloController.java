package com.blacksw.board.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/hello")
@RequiredArgsConstructor
public class HelloController {
	
	@GetMapping("/{message}")
	@ApiOperation(value="메시지 출력", notes="메시지를 돌려 받습니다.")
	public HashMap<String, Object> getHello(
			@PathVariable(value = "message") String message,
			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate) throws Exception {
		
		HashMap<String, Object> helloMap = new HashMap<>();
		helloMap.put("key", message);
		
		return helloMap;
	}
	
	@PostMapping("/list")
	@ApiOperation(value="헬로우 리스트 출력", notes="헬로우 리스트를 조회합니다.")
	public HashMap<String, Object> getHelloList(@RequestBody HashMap<String, Object> map) throws Exception {
		
		HashMap<String, Object> helloMap = new HashMap<>();
		helloMap.put("key1", "hello1");
		helloMap.put("key2", "hello2");
		helloMap.put("key3", "hello3");
		
		return helloMap;
	}

}
