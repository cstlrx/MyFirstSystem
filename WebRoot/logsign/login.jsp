<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	
	<script>
		function _change(){
			/*
				javascript实现点击换验证码
			*/
			//获取image元素
			var ele = document.getElementById("vcode");
			//重新得到验证码图片，为了处理浏览器缓存，以时间做参数，保证每次请求不同
			ele.src="<c:url value='/VerifyCodeServlet'/>?xxx="+new Date().getTime();
			
		}
	</script>
  </head>
  <body>
  <center>log in<br/>
  
  	<!-- 错误信息的显示，改用EL表达式改进 -->
  	<%-- <%
  		String message="";
  		String error = (String)request.getAttribute("error");
		if(error!=null){
			message=error;
		}
	%> --%>
	
	<%-- <%
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
	 %> --%>
	
	<%-- <font color="red"><b><%=message%></b></font> --%>
	
    <form action="<%=path%>/LogServlet" method="post">
    
    	<table border="1" cellspacing="0"  height="100">
	    	<p style="color:red; font-weight: 900">${msg}</p>
	    	<!-- 每次显式上一次user内容 -->
	    	<tr>
	    		<td>username:</td>
	    		<td><input type="text" name="username" value="${user.username }"/></td>
	    	</tr>
	    	
	    	<tr>
	    		<td>password:</td>
	    		<td><input type="password" name="password" value="${user.password }"/></td>
	    	</tr>
	    	<tr>
	    		<td>验证码：</td>
	    					<!-- 不知道为什么在这里使用EL表达式显示verifycode会出错 
	    					原因：verifyCode中的C字母没有大写，EL表达式查找时小数点后边的变量为get方法后边首字母小写其余不变-->
	    		<td><input type="text" name="verifycode" value="${user.verifyCode }">
	    		</td>
	    	</tr>
	    	<tr align="center">
	    		<td colspan="2">
	    			<a href="javascript:_change()"><!-- 使用url标签指向servlet ，默认get请求-->
	    				<img id=vcode src="<c:url value='/VerifyCodeServlet'></c:url>"/></a>
	    			
	    		</td>
	    		<td><font color="blue"><a href="javascript:_change()">看不清换一张</a></font></td>
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
