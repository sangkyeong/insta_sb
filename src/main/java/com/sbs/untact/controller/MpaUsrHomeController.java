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
	
	@RequestMapping("/")
	public String showHome() {
		return "redirect:/mpaUsr/home/main";
	}
	
	@RequestMapping("/mpaUsr/home/main")// http://localhost:8024//mpaUsr/home/main
	public String showMain() {
		return "mpaUsr/home/main";
	}



}
