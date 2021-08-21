package com.ptw.business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ptw.model.DeptVO;


@Repository 
public class DeptDAO implements DeptDAOInterface{
	
	@Autowired   //DeptDAO deptDAO = new DeptDAO();
	@Qualifier("dataSource")
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	 
	//jdbc템플릿이라고 하면 아래 모양을 기억해두면된다. 
	public List<DeptVO> findALL() {
		List<DeptVO> deptlist = new ArrayList<>();
		String sql = "select * from departments order by 1";
		deptlist = jdbcTemplate.query(sql, new RowMapper() { //sql문장 여기서 주면 알아서 함
			// 아래부터 맵퍼를 만드는데 한건한건 deptlist로 add시켜준다.
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				DeptVO dept = new DeptVO(rs.getInt(1), 
						rs.getString(2),rs.getInt(3), rs.getInt(4));
				
				return dept;
			}
			
			
		});
		
		return deptlist;
	}
	
	/* JDBC원본
	public List<DeptVO> findALL() {
		List<DeptVO> deptlist = new ArrayList<>();
		Connection conn = null;
		Statement st = null; // 蹂��닔媛� try臾� 諛뽰쑝濡� 紐삳굹�삤�땲 諛뽰뿉�꽌 �븳踰� �꽑�뼵�빐以��떎.
		ResultSet rs = null;
		String sql = "select * from departments order by 1";
		try {
			conn=dataSource.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql); 
			while(rs.next()) { //�엳�쓣�븣源뚯� �룎�븘�씪
				DeptVO dept = new DeptVO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
						deptlist.add(dept); //留뚮뱾�뼱�꽌 �꽔�뼱以�.....
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbClose(rs, st, conn);
		}
		
		
		return deptlist;
	}
	*/


	
}
