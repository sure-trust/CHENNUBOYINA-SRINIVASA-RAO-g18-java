package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String service = req.getParameter("service");

        String username = "";
        String password = "";
        boolean found = false;

        try (Connection con = DriverManager.getConnection("jdbc:mysql:///password_db", "root", "root")) {
            PreparedStatement ps = con.prepareStatement("SELECT username, password FROM credentials WHERE service = ? LIMIT 1");
            ps.setString(1, service);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                username = rs.getString("username");
                password = EncryptionUtil.decrypt(rs.getString("password"));  // Ensure EncryptionUtil is implemented
                found = true;
            }

            res.setContentType("text/html");
            PrintWriter out = res.getWriter();

            if (found) {
                out.println("{");
                out.println("\"success\": true,");
                out.println("\"username\": \"" + username + "\",");
                out.println("\"password\": \"" + password + "\"");
                out.println("}");
            } else {
                out.println("{ \"success\": false }");
            }

        } catch (Exception e) {
            e.printStackTrace();
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
