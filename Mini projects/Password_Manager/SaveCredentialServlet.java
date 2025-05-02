package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SaveCredentialServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String service = request.getParameter("service");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int a=0;
         String query = "INSERT INTO credentials(service,username,password)VALUES(?, ?, ?)";

        String encryptedPassword = EncryptionUtil.encrypt(password);
        System.out.println(service);
        System.out.println(username);     
        System.out.println(encryptedPassword);
        

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql:///password_db","root","root");


            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, service);
            ps.setString(2, username);
            ps.setString(3, encryptedPassword);
            a=ps.executeUpdate();

            
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(a);
        if(a!=0) {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>Credential saved successfully!</h3>");
        out.println("<a href='index.html'>Go Back</a>");
    }
        else {
        	response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h3>Credential saved unsuccessfully!</h3>");
            out.println("<a href='index.html'>Go Back</a>");
        	
        }
        
    }
}
