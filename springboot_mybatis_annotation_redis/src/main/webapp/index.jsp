<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
  
  <script type="text/javascript" src="js/index.js"></script></head>
  
  <body>
   <body>  
      
    <h3>查询界面</h3>  
    <input type="text" name="cityid" id="cityid"/>  
    <h3 id="c1"></h3>  
    <h3 id="c2"></h3>  
    <p><input type="button"  value="查询" id="ajaxFind"/> 
       <input type="button"  value="删除" id="ajaxDel"/>
    
    
    <fieldset>
    <legend>添加城市</legend>
      pid: <input type="text"  id="pid"/>  
      uname: <input type="text" id="uname"/>  
      desc: <input type="text"  id="desc"/> 
     <input type="button"  value="添加" id="ajaxAdd"/>
    </fieldset>
   
   <p/><p/><p/>
    
     <fieldset>
    <legend>修改城市</legend>
      id: <input type="text" name="cityid" id="cid"/>  
      pid: <input type="text"  id="ppid"/>  
      uname: <input type="text" id="puname"/>  
      desc: <input type="text"  id="pdesc"/> 
       <input type="button"  value="修改" id="ajaxPut"/>
    </fieldset>

    
    </p>  
      
</body> 

</html>
