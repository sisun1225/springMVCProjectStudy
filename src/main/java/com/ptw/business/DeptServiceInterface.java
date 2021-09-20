package com.ptw.business;

import java.util.List;

import com.ptw.model.DeptVO;


//앞으로 서비스 만들려면 아래 메소드를 반드시 구현할 의무가있다라는 것이다. 
public interface DeptServiceInterface {

	public List<DeptVO> findALL();
	public int update(DeptVO dept);
	public DeptVO findById(int deptid);

	
}
