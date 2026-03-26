package com.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/editStudent")
public class EditStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();

		String id = req.getParameter("id");

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Edit Student</title>");
		out.println("<link rel='stylesheet' href='style.css'>");
		out.println("</head>");
		out.println("<body>");

		try {
			Connection con = DBConnection.getConnection();

			String sql = "SELECT * FROM students WHERE id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(id));

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				out.println("<h2>Edit Student</h2>");

				out.println("<form action='updateStudent' method='post'>");

				out.println("<input type='hidden' name='id' value='" + rs.getInt("id") + "'>");

				out.println("Name: <input type='text' name='name' value='" + rs.getString("name") + "'><br><br>");
				out.println("Email: <input type='email' name='email' value='" + rs.getString("email") + "'><br><br>");

				out.println("<button type='submit'>Update Student</button>");
				out.println("</form>");
			}

		} catch (Exception e) {
			e.printStackTrace();
			out.println("Error: " + e.getMessage());
		}

		out.println("</body>");
		out.println("</html>");
	}
}