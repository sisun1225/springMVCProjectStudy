package com.ptw.business;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ptw.model.DeptVO;


@Repository("deptDAO_mybatis")
public class DeptDAOMybatis implements DeptDAOInterface {
	
	@Autowired
	SqlSession sqlsession;
	
	String namespace = "com.ptw.dept.";

	@Override
	public List<DeptVO> findALL() {
		System.out.println("mybatis이용");
		return sqlsession.selectList(namespace + "selectAll");
	}

	
	@Override
	public int update(DeptVO dept) {
		// TODO Auto-generated method stub
		return sqlsession.update(namespace + "update",dept);
	}
	
	@Override
	public DeptVO findById(int deptid) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(namespace + "selectById",deptid);
	}
	
}
