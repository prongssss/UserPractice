<%-- 
    Document   : user
    Created on : 05 8, 15, 3:36:43 PM
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
        <title>JSP Page</title>
    </head>
    <body>
        <a href="home.jsp">Home</a>
        <a href="profile.jsp">Profile</a>
        <a href="index.html">Logout</a>
        <br>
        <h1>Hi <%=session.getAttribute("username")%>!!!</h1>
    </body>
</html>
<%
    }else{
        response.sendRedirect("index.html");
    }
%>