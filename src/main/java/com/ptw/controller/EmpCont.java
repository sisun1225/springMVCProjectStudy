package com.ptw.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ptw.business.EmpService;

@Controller
public class EmpCont {
	
	@Autowired
	EmpService empService;
	//둘다 인터페이스

	@RequestMapping("/emplist.do")
	public String emplist(Model model) {
		
		model.addAttribute("emplist", empService.selectAll());
		return "emp/emplist";
	}
	
	
}
