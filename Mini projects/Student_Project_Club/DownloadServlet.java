package com.nt.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

 // Optional: Ensure servlet is mapped if using annotations
public class DownloadServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb", "root", "root");

            PreparedStatement stmt = conn.prepareStatement("SELECT pdf FROM projects WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Set ZIP content type
                response.setContentType("application/zip");
                // Set content disposition with .zip extension
                response.setHeader("Content-Disposition", "attachment; filename=project_" + id + ".zip");

                InputStream in = rs.getBinaryStream("pdf"); // BLOB column still named `pdf`
                OutputStream out = response.getOutputStream();

                byte[] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }

                in.close();
                out.flush();
            } else {
                response.getWriter().write("ZIP file not found.");
            }

            conn.close();
        } catch (Exception e) {
            throw new ServletException("Download error: " + e.getMessage());
        }
    }
}
