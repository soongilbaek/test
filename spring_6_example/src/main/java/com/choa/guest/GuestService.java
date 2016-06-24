package com.choa.guest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class GuestService {
	
	private GuestDAO guestDAO;

	public void setGuestDAO(GuestDAO guestDAO) {
		this.guestDAO = guestDAO;
	}
	
	public void guestList(HttpServletRequest request){
		try {
			int curPage=1;
			if(request.getParameter("curPage")!=null){
				curPage=Integer.parseInt(request.getParameter("curPage"));
			}
			request.setAttribute("guestList", guestDAO.boardList(curPage));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void guestWrite(GuestDTO guestDTO,RedirectAttributes red){
		int result =0;
		try {
			result = guestDAO.boardWrite(guestDTO);
			if(result>0){
				red.addFlashAttribute("msg", "글등록성공");
			}else{
				red.addFlashAttribute("msg", "글등록실패");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
