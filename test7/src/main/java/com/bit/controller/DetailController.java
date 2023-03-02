package com.bit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.model.BoardDao;
import com.bit.model.BoardVo;

@WebServlet("/detail.do")
public class DetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardDao dao = new BoardDao();
		int num = Integer.parseInt(req.getParameter("num"));
		BoardVo bean = dao.getBoard(num);
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		PrintWriter out = resp.getWriter();
	      try {
	         out.println("{\"board\":[");
	         out.println("{\"num\": "+ bean.getNum()
	            +", \"userId\":\""+ bean.getUserId()
	            +"\", \"title\":\""+ bean.getTitle()
	            +"\", \"viewCnt\":" + bean.getViewCnt()
	            + ", \"wrdate\":\"" + bean.getWrdate()
	            +"\", \"content\":\""+ bean.getContent()+  "\"}");
	         out.println("]}");
	      }finally {
	         if(out!=null) out.close();
	      }
	}
}
