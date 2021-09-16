package com.ptw.business;

import java.util.List;

import com.ptw.model.EmpVO;



public interface EmpDAOInterface {

	public List<EmpVO> selectAll() ;
	public int insertEmp(EmpVO emp) ;
	public int delete(int empid);

	
}
