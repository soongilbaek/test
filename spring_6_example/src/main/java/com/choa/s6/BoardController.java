package com.choa.s6;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.choa.board.BoardService;

@Controller
@RequestMapping("/board/**")
public class BoardController {
	@Inject
	private BoardService boardService;
	
	@RequestMapping("/boardList")
	public void boardList(int curPage,Model model){
		boardService.boardList(model, curPage);
	}
}
