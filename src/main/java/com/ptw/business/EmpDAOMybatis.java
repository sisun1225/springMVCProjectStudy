package com.ptw.business;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ptw.model.EmpVO;


@Repository
public class EmpDAOMybatis implements EmpDAOInterface{
	
	@Autowired
	SqlSession session;
	
	String namespace = "com.ptw.emp.";
	
	@Override
	public List<EmpVO> selectAll() {
		List<EmpVO> emplist = session.selectList(namespace + "selectAll");
		return emplist;
	}

}
