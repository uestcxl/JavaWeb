<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.beans.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%--
  Created by IntelliJ IDEA.
  User: xl
  Date: 15/4/21
  Time: 下午2:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Java王者归来代码演示</title>
    <meta charset="utf-8"/>
    <script>
      function change(){
        document.getElementById('btn').disabled=true;
        document.getElementById('identify').src='identify?ts='+ new Date().getTime();
      }
    </script>
    <style>
      h3{
        font-weight: bold;
      }
      a{
        text-decoration: none;
      }
    </style>
  </head>
  <body>

    <div class="header">
      <h1>Java王者归来代码实例</h1>
    </div>

    <div class="content">

      <div class="identify">
        <h3>验证码图片</h3>
        <img src="identify" alt="identify" id="identify" onload="btn.disabled=false;"/>
        <button id="btn" type="button" value="换个图片" onclick="change()">点我换图</button>
      </div>
      <hr/>

      <div class="request">
        <h3>Get与post请求</h3>
        <p><a href="sayhello">点我查看</a></p>
      </div>
      <hr/>

      <div class="web-xml">
        <h3>获取web.xml中的参数</h3>
        <p><a href="initparams">获取initparams中得内容</a></p>
        <p><a href="contentParams">获取content中得内容</a></p>
        <p><a href="contentParams">通过@Resource获取env-entry中的参数</a></p>
      </div>
      <hr/>

    </div>

    <div class="footer">
      <%--<p>copyright©xl</p>--%>
    </div>

    <%
      Class.forName("com.mysql.jdbc.Driver");
      java.sql.Connection connection = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/awesome", "xl", "xulei123");
      java.sql.Statement statement = connection.createStatement();
      java.sql.ResultSet resultSet = statement.executeQuery("select * from user");
      while (resultSet.next()){
        %>
      <h1><%=resultSet.getString(1)%></h1>
      <h1><%=resultSet.getString(2)%></h1>
      <h1><%=resultSet.getString(3)%></h1>
    <%
      }
    %>
  </body>
</html>
