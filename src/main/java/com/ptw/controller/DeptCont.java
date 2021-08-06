package com.ptw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ptw.business.DeptServiceImpl;

@Controller
public class DeptCont {

	@Autowired
	@Qualifier("deptService")
    DeptServiceImpl service;
	
	@RequestMapping("/ptw/deptlist.do")
	public String deptlist(Model model) {

		model.addAttribute("deptall", service.findALL());

		return "dept/dept_retrieve";
	}
	
	
	
}
