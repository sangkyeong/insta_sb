package com.sbs.untact.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//주석은 인간이 이해가능 / @는 컴퓨터가 이해하는 주석?
@Controller
public class MpaUsrHomeController {
	@RequestMapping("/mpaUsr/home/main")// http://localhost:8024//mpaUsr/home/main
	@ResponseBody
	public String showMain() {
		return "안녕";
	}
	
	@RequestMapping("/mpaUsr/home/main2")
	@ResponseBody
	public String showMain2() {
		return "잘가";
	}
	
	@RequestMapping("/mpaUsr/home/main3")	//http://localhost:8024//mpaUsr/home/main3?a=10&b=20
	@ResponseBody
	public int showMain3(int a, int b) {	
		return a+b;
	}
	
	@RequestMapping("/mpaUsr/home/main4")	
	@ResponseBody
	public int showMain4(int a, int b) {	
		return a-b;
	}
	
	@RequestMapping("/mpaUsr/home/main5")	//-는 문자로 인식
	@ResponseBody
	public String showMain5() {	
		return "-20";
	}
	
	@RequestMapping("/mpaUsr/home/main6")	//false출력
	@ResponseBody
	public Boolean showMain6() {	
		return 1 > 2;
	}
	
	@RequestMapping("/mpaUsr/home/main7")	
	@ResponseBody
	public int[] showMain7() {
		int[] arr = new int[] {1, 2, 3};
		return arr;
	}
//정보를 HTML로 넘기려면 리스트나 맵을 사용
	
	@RequestMapping("/mpaUsr/home/main8")
	@ResponseBody
	public List<Integer> showMain8() {
		List<Integer> l = new ArrayList<>();
		l.add(10);
		l.add(20);
		l.add(30);

		return l;
	}

	@RequestMapping("/mpaUsr/home/main9")
	@ResponseBody
	public Map<String, Object> showMain9() {
		Map<String, Object> map = new HashMap<>();
		map.put("철수나이", 22);
		map.put("영희나이", 32);

		return map;
	}

	private int num = 0;

	@RequestMapping("/mpaUsr/home/main10")
	@ResponseBody
	public Map<String, Object> showMain10() {
		num++;

		Map<String, Object> map = new HashMap<>();
		map.put("숫자", num);

		return map;
	}
	


}
