package com.ptw.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ptw.business.EmpService;
import com.ptw.model.EmpVO;

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
	
	@RequestMapping("/empInsert.do")
	public String empInsert() {
		/*
		 * model.addAttribute("dlist", deptService.findALL());
		 * model.addAttribute("mlist", deptService.findALLManager());
		 * model.addAttribute("jlist", empService.selectAllJobs());
		 */
		return "emp/empInsert";
	}
	
	@RequestMapping(value = "/empInsert.do", method = RequestMethod.POST)
	public String empInsertPost(EmpVO emp) {
		empService.insertEmp(emp);
		return "redirect:/emplist.do"; //재요청
	}
	
	@RequestMapping("/empDelete.do")
	public String empDelete(int empid) {
		empService.delete(empid);
	
		return "redirect:/emplist.do"; 
	}
	
	
	@RequestMapping("/empDetail.do")
	public String empDetail(Model model, int empid) {
		model.addAttribute("emp", empService.selectById(empid));
	
		return "emp/empdetail"; //forward
	}
	
	
	@RequestMapping(value = "/empDetail.do", method=RequestMethod.POST)
	public String empDetailPost(EmpVO emp) {
		int result = empService.updateEmp(emp);
		System.out.println("성공"+result);
		return "redirect:/emplist.do"; 
	}
	
}
