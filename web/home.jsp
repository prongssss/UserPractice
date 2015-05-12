<%-- 
    Document   : home
    Created on : 05 6, 15, 3:55:14 PM
    Author     : asi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>Homepage</title>
    </head>
    <body>
        
            <a href="home.jsp">Home</a> |
            <a href="profile.jsp">Profile</a> |
            <a href="user.jsp">Add User</a> |
            <a href="index.html">Logout</a>
            <br>
            <h1>Hi <%=session.getAttribute("username")%>!!!</h1>
            <table border="2">
                <thead>
                    <th>User ID</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Action</th>
                </thead>
                <tbody>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td><c:out value="${user.userid}"/></td>
                            <td><c:out value="${user.username}"/></td>
                            <td><c:out value="${user.password}"/></td>
                            <td><a href="UserController?action=edit&userid=<c:out value="${user.userid}"/>">Edit</a></td>
                            <td><a href="UserController?action=delete&userid=<c:out value="${user.userid}"/>" >Delete</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        
    </body>
</html>
<%
    }else{
        response.sendRedirect("index.html");
    }
%>