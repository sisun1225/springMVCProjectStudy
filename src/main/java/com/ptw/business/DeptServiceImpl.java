package com.ptw.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.ptw.model.DeptVO;


//서비스는 반드시 추상메소드 구현해야함
//이름을 안주면 아래 클래스 이름으로 가져다쓰게된다.
@Service("deptService") 
public class DeptServiceImpl implements DeptServiceInterface{
	//DeptDAOInterface=>구현 class : DeptDAO, DeptDAOMybatis
	@Autowired   //@autowired는 타입이 같으면 자동으로 di
	//@Qualifier("deptDAO_mybatis")  //타입이 같은 class가 여러개라면 이름으로 구분
    DeptDAOInterface deptDAO;
	
	
	@Override
	public List<DeptVO> findALL() {
		// TODO Auto-generated method stub
		return deptDAO.findALL();
	}


	
	
}
