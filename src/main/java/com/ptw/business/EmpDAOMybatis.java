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

	@Override
	public int insertEmp(EmpVO emp) {
		System.out.println("empdaomybatis");
		int result = session.insert(namespace + "empInsert", emp);
		System.out.println("입력" + result);
		return result; //리턴 해줘야 컨트롤러가 입력이 제대로 되었는지 확인 후 다른 일을 할수있다.
	}
	
	@Override
	public int delete(int empid) {
		int result = session.delete(namespace+"empDelete", empid);  
		System.out.println(result);
		return result;
	}
}
