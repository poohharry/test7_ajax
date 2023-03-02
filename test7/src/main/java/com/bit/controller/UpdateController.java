package com.bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.BoardDao;
import com.bit.model.BoardVo;

@WebServlet("/update.do")
public class UpdateController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		
		BoardVo bean = new BoardVo();
		BoardDao dao = new BoardDao();
		int num = Integer.parseInt(req.getParameter("num"));
		bean.setTitle(req.getParameter("title"));
		bean.setContent(req.getParameter("content"));
		bean.setNum(num);
		dao.updateBoard(bean);
		
		resp.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:5500");
		resp.sendRedirect("detail.html?num=" + num);
	}
	
	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doOption");
	}
}
