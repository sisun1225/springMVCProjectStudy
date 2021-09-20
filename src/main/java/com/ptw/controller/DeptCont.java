package com.ptw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ptw.business.DeptServiceImpl;
import com.ptw.model.DeptVO;

@Controller
public class DeptCont {

	@Autowired
	@Qualifier("deptService")
    DeptServiceImpl service;
	
	@RequestMapping("/deptlist.do")
	public String deptlist(Model model) {

		model.addAttribute("deptall", service.findALL());

		return "dept/deptlist";
	}
	
	
	@RequestMapping("/deptDetail.do")
	public String deptDetail(Model model, int i_deptid) {
		model.addAttribute("dept", service.findById(i_deptid));
	
		return "dept/deptDetail"; //forward
	}
	
	@RequestMapping(value = "/deptDetail.do", method=RequestMethod.POST)
	public String deptDetailPost(DeptVO dept) {
		service.update(dept);	
		return "redirect:/deptlist.do"; 
	}
	
	 
	
}
