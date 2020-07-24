package com.tutorial.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tutorial.web.entity.Notice;

@WebServlet("/notice/detail")
public class NoticeDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));


		String url = "jdbc:mysql://localhost:3306/java_tutorial?serverTimezone=UTC";
		String sql = "SELECT * FROM NOTICE WHERE ID=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "123456789a");
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id); //첫번째 물음표에다가 id를 대입하겠다.

			ResultSet rs = st.executeQuery(); //실행결과가 서버쪽에 만들어짐

			rs.next();//서버쪽에 있는 실행결과를 가져옴

			String title = rs.getString("TITLE");
			Date regdate = rs.getDate("REGDATE");
			String writerId = rs.getString("WRITER_ID");
			int hit = rs.getInt("HIT");
			String content = rs.getString("CONTENT");
			String files = rs.getString("FILES");
			
			Notice notice = new Notice(
									id,
									title,
									regdate,
									writerId,
									hit,
									content,
									files
									);
			request.setAttribute("n", notice);
			
			/*
			// request 저장소 활용
			request.setAttribute("title", title);
			request.setAttribute("regdate", regdate);
			request.setAttribute("writerId", writerId);
			request.setAttribute("hit", hit);
			request.setAttribute("content", content);
			*/
			
			rs.close();
			st.close();
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// redirect ex) 로그인 안했을 경우 로그인 페이지로 보내버리기, 게시글 등록했을때 목록페이지로 보내기
		
		
		
		//forward ex) 여기서 작업한 내용을 다른 servlet(jsp)에서 이어받게끔 하고 싶을때 사용
		request.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp").forward(request, response);
	}
}
