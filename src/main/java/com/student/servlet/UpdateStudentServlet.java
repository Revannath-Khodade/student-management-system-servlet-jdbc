package com.student.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String email = req.getParameter("email");

		try {
			Connection con = DBConnection.getConnection();

			String sql = "UPDATE students SET name=?, email=? WHERE id=?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, name);
			ps.setString(2, email);
			ps.setInt(3, Integer.parseInt(id));

			int i = ps.executeUpdate();

			if (i > 0) {
				// redirect back to list
				res.sendRedirect("viewStudents");
			} else {
				res.getWriter().println("Update Failed");
			}

		} catch (Exception e) {
			e.printStackTrace();
			res.getWriter().println("Error: " + e.getMessage());
		}
	}
}