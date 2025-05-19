package com.nt.servlet;

import java.io.InputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig
public class UploadProjectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String roll = request.getParameter("roll");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String phone = request.getParameter("phone");

        // Get the uploaded ZIP file
        Part filePart = request.getPart("zipFile"); // field name changed
        InputStream zipStream = filePart.getInputStream();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "root");

            String sql = "INSERT INTO projects (name, roll, title, description, phone, pdf) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, roll);
            stmt.setString(3, title);
            stmt.setString(4, description);
            stmt.setString(5, phone);
            stmt.setBlob(6, zipStream); // storing zip as blob (same as before)

            stmt.executeUpdate();
            con.close();

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h3>Project uploaded successfully with ZIP file!</h3>");
            out.println("<a href='home.html'>Back to Home</a>");
        } catch (Exception e) {
            throw new ServletException("DB Error: " + e.getMessage());
        }
    }
}
