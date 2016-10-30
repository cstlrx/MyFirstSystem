<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();///MyFirstSystem
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
  <center>log in<br/>
  
  	<%
  		String message="";
  		String error = (String)request.getAttribute("error");
		if(error!=null){
			message=error;
		}
	%>
	
	<%
	//名字能在每次重新打开浏览器时将cookie中信息写入名字输入框
		/*
		*读取cookie
		*/
		String uname=""; 
		Cookie[] cs=request.getCookies();
		if(cs!=null){
			for(Cookie c:cs){
				if("uname".equals(c.getName())){
					uname=c.getValue();
				}
			}
			
		}
	 %>
	<font color="red"><b><%=message%></b></font>
    <form action="<%=path%>/LogServlet" method="post">
    
    	<table border="1" cellspacing="0"  height="100">
	    	
	    	<tr>
	    		<td>login:</td>
	    		<td><input type="text" name="username" value="<%=uname %>"/></td>
	    	</tr>
	    	
	    	<tr>
	    		<td>password:</td>
	    		<td><input type="password" name="password"/></td>
	    	</tr>
	    	<tr align="center">
	    		<td colspan="2"><input type="submit" value="登陆"></td>
	    		<%-- <td><a href="<%=path %>/logsign/signin.jsp"></a></td> --%>
	    	</tr>
    		
    	</table>
    </form>
    </center>
  </body>
</html>
