package com.choa.guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class GuestDAO {
	
	private  DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public List<GuestDTO> boardList(int curPage) throws Exception{
		String sql="select * from guest "
				+ "where rownum between ? and ? "
				+ "order by num desc";
		int start = (curPage-1)*10+1;
		int last = curPage*10;
		List<GuestDTO> ar = new ArrayList<GuestDTO>();
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, start);
		st.setInt(2, last);
		ResultSet rs= st.executeQuery();
		while(rs.next()){
			GuestDTO dto = new GuestDTO();
			dto.setNum(rs.getInt("num"));
			dto.setId(rs.getString("id"));
			dto.setTitle(rs.getString("title"));
			dto.setReg_date(rs.getDate("reg_date"));
			dto.setCount(rs.getInt("count"));
			ar.add(dto);
		}
		return ar;
	}
	public int boardWrite(GuestDTO guestDTO) throws Exception{
		int result=0;
		String sql="insert into guest values(guest_seq.nextVal,?,?,?,sysdate,0)";
		Connection con = dataSource.getConnection();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, guestDTO.getId());
		st.setString(2, guestDTO.getTitle());
		st.setString(3, guestDTO.getContents());
		result = st.executeUpdate();
		return result;
	}
}
