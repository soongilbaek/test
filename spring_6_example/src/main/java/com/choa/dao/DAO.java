package com.choa.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.choa.dto.DTO;

public interface DAO {
	
	public List<DTO> list(HttpServletRequest request) throws Exception;
	
}
