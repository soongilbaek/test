package com.choa.s6;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.guest.GuestDTO;
import com.choa.guest.GuestService;

@Controller
@RequestMapping("/guest/**")
public class GuestController {
	@Inject
	private GuestService guestService;
	
	@RequestMapping("/guestList")
	public void guestList(HttpServletRequest request){
		guestService.guestList(request);
	}
	
	@RequestMapping("/guestWrite")
	public void guestWrite(){}
	
	@RequestMapping(value="/write" , method = RequestMethod.POST)
	public String write(GuestDTO guestDTO,RedirectAttributes red){
		guestService.guestWrite(guestDTO, red);
		return "redirect:/guest/guestList";
	}
}
