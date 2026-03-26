package com.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/viewStudents")
public class ViewStudentsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html;charset=UTF-8");

		PrintWriter out = res.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>Student List</title>");
		out.println("<link rel='stylesheet' href='style.css'>");
		out.println("</head>");
		out.println("<body>");

		try {
			Connection con = DBConnection.getConnection();

			String sql = "SELECT * FROM students";
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			out.println("<h2>Student List</h2>");
			out.println("<table>");
			out.println("<tr><th>ID</th><th>Name</th><th>Email</th><th>Action</th></tr>");

			while (rs.next()) {
				int id = rs.getInt("id");

				out.println("<tr>");
				out.println("<td>" + id + "</td>");
				out.println("<td>" + rs.getString("name") + "</td>");
				out.println("<td>" + rs.getString("email") + "</td>");

				out.println("<td>");
				out.println("<a href='editStudent?id=" + id + "'>Edit</a> | ");
				out.println("<a href='deleteStudent?id=" + id + "'>Delete</a>");
				out.println("</td>");

				out.println("</tr>");
			}

			out.println("</table>");

			out.println("<br><a href='index.jsp'>Go Back</a>");

		} catch (Exception e) {
			e.printStackTrace();
			out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
		}

		out.println("</body>");
		out.println("</html>");
	}
}