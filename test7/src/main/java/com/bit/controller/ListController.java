package com.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.BoardDao;
import com.bit.model.BoardVo;

@WebServlet("/list.do")
public class ListController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardDao dao = new BoardDao();
		resp.setCharacterEncoding("utf-8");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		try {
			out.println("{\"board\":[");
			List<BoardVo> list = dao.getList();
			for(int i=0; i<list.size(); i++) {
			BoardVo bean = list.get(i);
			if(i!=0)out.print(",");
			out.println("{\"num\":"+bean.getNum()+", \"title\":\""+bean.getTitle()+"\", \"wrdate\":\""+bean.getWrdate()+"\", \"userId\":\""+bean.getUserId()+"\", \"viewCnt\":"+bean.getViewCnt()+"}");
			}
			out.println("]}");
		}finally {
			if(out!=null)out.close();
		}
	}
}
 