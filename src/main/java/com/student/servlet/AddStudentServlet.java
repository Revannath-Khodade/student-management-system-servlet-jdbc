package com.student.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html;charset=UTF-8");

		String name = req.getParameter("name");
		String email = req.getParameter("email");

		try {
			Connection con = DBConnection.getConnection();

			if (con == null) {
				res.getWriter().println("DB NOT CONNECTED ❌");
				return;
			}

			String sql = "INSERT INTO students(name, email) VALUES (?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, name);
			ps.setString(2, email);

			int i = ps.executeUpdate();

			if (i > 0) {
				res.getWriter().println("<h2 style='color:green;'>Student Saved in DB ✅</h2>");
				res.getWriter().println("<br><a href='index.jsp'>Go Back</a>");
			} else {
				res.getWriter().println("<h2 style='color:red;'>Error saving student ❌</h2>");
				res.getWriter().println("<br><a href='index.jsp'>Try Again</a>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}