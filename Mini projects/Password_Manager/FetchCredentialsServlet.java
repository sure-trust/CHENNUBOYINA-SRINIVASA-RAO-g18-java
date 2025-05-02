package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/FetchCredentialsServlet")
public class FetchCredentialsServlet extends HttpServlet {

    // Fetch list of services for dropdown
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<String> services = new ArrayList<>();

        try (Connection con = DriverManager.getConnection("jdbc:mysql:///password_db", "root", "root")) {
            PreparedStatement ps = con.prepareStatement("SELECT DISTINCT service FROM credentials");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                services.add("\"" + rs.getString("service") + "\"");
            }

            res.setContentType("application/json");
            PrintWriter out = res.getWriter();
            out.println("{ \"services\": [" + String.join(",", services) + "] }");

        } catch (Exception e) {
            e.printStackTrace();
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    // Fetch username and password for selected service
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String service = req.getParameter("service");
        res.setContentType("application/json");
        PrintWriter out = res.getWriter();

        try (Connection con = DriverManager.getConnection("jdbc:mysql:///password_db", "root", "root")) {
            PreparedStatement ps = con.prepareStatement("SELECT username, password FROM credentials WHERE service = ? LIMIT 1");
            ps.setString(1, service);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String username = rs.getString("username");
                String password = EncryptionUtil.decrypt(rs.getString("password")); // Assumes encrypted storage
                out.println("{ \"success\": true, \"username\": \"" + username + "\", \"password\": \"" + password + "\" }");
            } else {
                out.println("{ \"success\": false }");
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.println("{ \"success\": false, \"error\": \"Server error\" }");
        }
    }
}
