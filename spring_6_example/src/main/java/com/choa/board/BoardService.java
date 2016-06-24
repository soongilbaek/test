package com.choa.board;

import org.springframework.ui.Model;

public class BoardService {

	private BoardDAO boardDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}


	public void boardList(Model model,int curPage){
		try {
			model.addAttribute("boardList",boardDAO.boardList(curPage));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
