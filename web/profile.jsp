<%-- 
    Document   : profile
    Created on : 05 6, 15, 4:10:46 PM
    Author     : asi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
            response.setHeader("Cache-Control", "no-store, must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", -1);
            if(session.getAttribute("username")!=null){ 
        %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
    </head>
    <body>
        
            
            <a href="home.jsp">Home</a>
            <a href="profile.jsp">Profile</a>
            <a href="index.html">Logout</a>
            <br>
            <h1>Hello <%=session.getAttribute("username")%>!!!</h1>
        
            
</html>
<%
            }else{
                response.sendRedirect("index.html");
            }
        %>
              
       

