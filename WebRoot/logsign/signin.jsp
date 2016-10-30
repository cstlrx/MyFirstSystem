<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'signin.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <center>sign in<br/>
    <form action="<%=path%>/SignServlet" method="post">
    	<table border="1" cellspacing="0"  height="100">
	    	<tr>
	    		<td>name:</td>
	    		<td><input type="text" name="username"/></td>
	    	</tr>
	    	
	    	<tr>
	    		<td>password:</td>
	    		<td><input type="password" name="password"/></td>
	    	</tr>
	    	
	    	<tr>
	    		<td>email:</td>
	    		<td><input type="email" name="email"/></td>
	    	</tr>

	    	<tr align="center">
	    		<td colspan="2"><input type="submit" value="signin"></td>
	    	</tr>
    		
    	</table>
    </form>
    </center>
  </body>
</html>
