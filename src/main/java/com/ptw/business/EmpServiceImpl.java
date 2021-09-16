package com.ptw.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ptw.model.EmpVO;

@Service("empService")
public class EmpServiceImpl implements EmpService{
	
	@Autowired
	@Qualifier("empDAOMybatis")
	EmpDAOInterface empDAO;
	
	@Override
	public List<EmpVO> selectAll() {
		// TODO Auto-generated method stub
		return empDAO.selectAll();
	}
	
	@Override
	public int insertEmp(EmpVO emp) {
		System.out.println("empservice");
		return empDAO.insertEmp(emp);
	}
	
	@Override
	public int delete(int empid) {
		// TODO Auto-generated method stub
		return empDAO.delete(empid);
	}

}
