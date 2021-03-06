package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.MemberDTO;
import com.exception.MyException;
import com.service.MemberService;

@WebServlet("/MemberUpdateServlet")
public class MemberUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//addservlet가져옴
		request.setCharacterEncoding("utf-8");
		
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		String username = request.getParameter("username");
		String post1 = request.getParameter("post1");
		String post2 = request.getParameter("post2");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");
		String phone3 = request.getParameter("phone3");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2"); //무엇이 수정된지 모르니 다 받아온다
		
		
		MemberDTO dto =
				new MemberDTO(userid, passwd, username, post1, post2, addr1, addr2, phone1, phone2, phone3, email1, email2);
	    MemberService service = new MemberService();
	    String target="home.jsp";
	    try {
			service.updateMember(dto);
			request.setAttribute("update", "수정완료");
		} catch (MyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			target= "error.jsp";
		}
		
	    RequestDispatcher dis = request.getRequestDispatcher(target);
	    dis.forward(request, response);
	
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
