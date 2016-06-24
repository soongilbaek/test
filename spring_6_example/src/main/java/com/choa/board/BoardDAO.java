package com.choa.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class BoardDAO {
	private  DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public List<BoardDTO> boardList(int curPage) throws Exception{
		String sql="select * from notice_board "
				+ "where rownum between ? and ? "
				+ "order by num desc";
		int start = (curPage-1)*10+1;
		int last = curPage*10;
		List<BoardDTO> ar = new ArrayList<BoardDTO>();
		Connection con = dataSource.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		st = con.prepareStatement(sql);
		st.setInt(1, start);
		st.setInt(2, last);
		rs= st.executeQuery();
		while(rs.next()){
			BoardDTO dto = new BoardDTO();
			dto.setNum(rs.getInt("num"));
			dto.setId(rs.getString("id"));
			dto.setTitle(rs.getString("title"));
			dto.setReg_date(rs.getDate("reg_date"));
			ar.add(dto);
		}
		return ar;
	}
}
