<%--
  Created by IntelliJ IDEA.
  User: meishifeng
  Date: 2017/7/19
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/commonTools.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>jsonToHtml</title>
</head>
<body>
    <form name="json" method="post">
        请输入json：<input type="textarea" id="jsonIn" name="jsonIn" type="hidden"><br>
        <input type="button" id="button1" value="转换" onclick="toHtml1()">
        <p>内容：</p>
    </form>
</body>

<script type="application/javascript">
  function toHtml1(){
    $("p").children().remove();
    var jsonIn = $("#jsonIn").val();
    var jsonObj = eval("(" + jsonIn + ")");
    var json = jsonObj.content.Fields;

    for(var i=0,l=json.length;i<l;i++){
      var html1 = "";

      var dt;
      if(json[i].dt.toString() == 'hd'){
        dt = 1;
      } else if(json[i].dt.toString() == 'iTi') {
        dt = 2;
      } else if(json[i].dt.toString() == 'l'){
        dt = 3;
      } else {
        dt = 4
      }

      switch (dt){
        case 1 : html1 = "<input class='json' name='" + json[i].fd1 + "' value='" + json[i].v1 + "' type='hidden' />";
        break;
        case 2 : html1 = "<br><label>" + json[i].dn + "：</label>" + "<input class='json' type='" + json[i].dt + "' name='" + json[i].fd1 + "' value='" + json[i].v1 + "' placeholder='"+ json[i].ph1 + "'/><label>" + json[i].un + " — " + "</label><input type='" + json[i].dt + "' name='" + json[i].fd2 + "' value='" + json[i].v1 + "' placeholder='"+ json[i].ph2 + "'/><label>" + json[i].un + "</label>";
        break;
        case 4 : html1 = "<br><label>" + json[i].dn + "：</label>" + "<input class='json' type='" + json[i].dt + "' name='" + json[i].fd1 + "' value='" + json[i].v1 + "'/>";
        break;
        case 3 : html1 = "<br><label>" + json[i].dn + "：</label>" + "<input class='json' type='" + json[i].dt + "' name='" + json[i].fd1 + "' value='" + json[i].v1 + "' disabled='disabled' />";
        break;
      }

      $("p").append(html1);
    }
  }
</script>

</html>
