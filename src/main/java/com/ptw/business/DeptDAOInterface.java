package com.ptw.business;

import java.util.List;

import com.ptw.model.DeptVO;


//이런 함수 구현할것이다
public interface DeptDAOInterface {
	public List<DeptVO> findALL();
	public int update(DeptVO dept);
	public DeptVO findById(int deptid);
}
