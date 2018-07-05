<%--
  Created by IntelliJ IDEA.
  User: meishifeng
  Date: 2016/12/30
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/commonTools.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户登录</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath %>resource/css/login/base.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>resource/css/login/main.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>resource/css/login/login.css">

</head>

<body>
  <form action="" method="post">
      <div style="width:900px; margin:0 auto; margin-left: 36%;">
          <div class="login_box">
              <table class="login_tb">
                  <tbody>
                      <tr>
                          <th  class="login_th"><div class="logo" ><img alt="" src="<%=basePath %>resource/images/gujinglogo.png"></div></th>
                          <th>
                            <h1 class="logoCon">测试系统</h1>
                          </th>
                          <th></th>
                      </tr>
                      <tr>
                          <td align="right">账号：</td>
                          <td><input type="text" id="account" class="input_txt" maxlength="11"></td>
                          <td>
                            <span id="login_error" style=" color:red;"></span>
                          </td>
                      </tr>
                      <tr>
                          <td align="right">密码：</td>
                          <td><input type="password" id="password" class="input_txt"></td>
                      </tr>
                      <tr>
                          <td>&nbsp;</td>
                          <td>
                            <input id="login" type="button" onclick="userLogin()" class="login_btn" value="登录"><br/>
                          </td>
                      </tr>
                      <tr>
                          <td colspan="3">
                            <br/><br/>
                            <span style="font-size: 12px; margin-left:30px;">如果您在登录时遇到问题，请联系meishifeng1992@163.com</span><br/>
                          </td>
                      </tr>
                      <tr>
                          <td colspan="3">
                            <span style="margin-left:60px;"><a href="http://weibo.com/u/2351779813/home" target="_blank" style="text-decoration:underline;">登陆微博</a></span>
                            <span style="margin-left:40px;"><a href="<%=basePath%>register/toRegister.do" target="_blank" style="text-decoration:underline;">账号注册</a></span>
                            <span style="margin-left:40px;"><a href="http://mail.163.com" target="_blank" style="text-decoration:underline;">登陆邮箱</a></span>
                          </td>
                      </tr>
                  </tbody>
              </table>
          </div>
      </div>
  </form>
</body>
</html>
<script type="text/javascript">
    function userLogin(){
        var account=$("#account").val();
        var password=$("#password").val();

        $.ajax({
            type:"post",
            dataType:"text",
            timeout:9000, // 超时时间设置，单位毫秒
            url:"<%=basePath%>userLogin",
            data:{"account":account, "password":password},
            success:function(data){
                var result=eval("("+data+")");
                $.messager.progress('close'); // hide progress bar while submit successfully
                $.messager.alert("结果", result.msg, 'info');
                if (result.code == "200") {
                    window.location.href = "index.html";
                }
            },
            error:function(XMLHttpRequest, textStatus, errorThrown) {
                if(textStatus=='timeout'){
                    art.dialog({
                        resize:false,
                        drag: false,
                        lock:true,
                        cancel:false,
                        fixed:true,
                        width:200,
                        height:100,
                        title:'Error', icon:'error',
                        content:'请求超时, 请刷新后再次尝试！',
                        ok:function(){

                        }
                    });
                }else{
                    art.dialog({
                        resize:false,
                        drag: false,
                        lock:true,
                        cancel:false,
                        fixed:true,
                        width:200,
                        height:100,
                        title:'Error', icon:'error',
                        content:'网络异常, 请刷新后再次尝试！',
                        ok:function(){

                        }
                    });
                }
            }
        });
    }
</script>
