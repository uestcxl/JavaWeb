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

      <div class="request">
        <h3>Get与post请求</h3>
        <p><a href="sayhello">点我查看</a></p>
      </div>

      <div class="web-xml">
        <h3>获取web.xml中的参数</h3>
        <p><a href="initparams">获取initparams中得内容</a></p>
      </div>
    </div>

    <div class="footer">
      <%--<p>copyright©xl</p>--%>
    </div>

  </body>
</html>
