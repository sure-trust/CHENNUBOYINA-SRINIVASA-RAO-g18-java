package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ShowProjectsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Adding CSS Styles inline
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin: 20px; background-color: #f4f4f9; }");
        out.println("h2 { color: #4CAF50; text-align: center; }");
        out.println("table { width: 100%; border-collapse: collapse; margin: 20px 0; }");
        out.println("table, th, td { border: 1px solid #ddd; text-align: left; padding: 8px; }");
        out.println("th { background-color: #4CAF50; color: white; }");
        out.println("tr:nth-child(even) { background-color: #f2f2f2; }");
        out.println("a { color: #4CAF50; text-decoration: none; }");
        out.println("a:hover { text-decoration: underline; }");
        out.println("table { margin: auto; width: 80%; }");
        out.println("td, th { text-align: center; }");
        out.println("td a { font-weight: bold; }");
        out.println("</style>");

        out.println("<h2>List of Uploaded Projects</h2>");
        out.println("<table><tr><th>Name</th><th>Roll</th><th>Title</th><th>Description</th><th>Phone</th><th>Download PDF</th></tr>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "root");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM projects");

            while (rs.next()) {
                int id = rs.getInt("id");
                String phone = rs.getString("phone");
                String whatsappLink = "https://wa.me/" + phone;

                out.println("<tr><td>" + rs.getString("name") + "</td><td>" +
                        rs.getString("roll") + "</td><td>" +
                        rs.getString("title") + "</td><td>" +
                        rs.getString("description") + "</td><td>" +
                        "<a href='" + whatsappLink + "' target='_blank'>" + phone + "</a></td><td>" +
                        "<a href='download?id=" + id + "'>Download Project Zip Files</a></td></tr>");
            }

            out.println("</table><br><a href='home.html'>Back to Home</a>");
            conn.close();
        } catch (Exception e) {
            throw new ServletException("DB Error: " + e.getMessage());
        }
    }
}
