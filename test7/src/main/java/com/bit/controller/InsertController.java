package com.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.BoardDao;
import com.bit.model.BoardVo;

@WebServlet("/insert.do")
public class InsertController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		BoardVo bean = new BoardVo();
		BoardDao dao = new BoardDao();
		resp.setHeader("Content-Type", "application/x-www-form-urlencoded");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setContentType("application/json");
		
		bean.setTitle(req.getParameter("title"));
		bean.setContent(req.getParameter("content"));
		bean.setUserId(req.getParameter("userId"));
		
		dao.insertBoard(bean);
		
		resp.sendRedirect("index.html");
		
	}
}
