<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/commonTools.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	
	<form id="addUser"  method="post">
		<table>
			<tr>
				<td>姓名：<input type="text" id="userName" name="userName" /></td>
			</tr>
			<tr>
				<td>账号：<input type="text" id="accountNo" name="accountNo" /></td>
			</tr>
			<tr>
				<td>手机号：<input type="text" id="phone" name="phone" /></td>
			</tr>
			<tr>
				<td>性别：<input type="text" id="gender" name="gender" /></td>
			</tr>
			<tr>
				<td>邮箱：<input type="text" id="email" name="email" /></td>
			</tr>
			<tr>
				<td>地址：<input type="text" id="adress" name="adress" /></td>
			</tr>
			<tr>
				<td>备注：<input type="text" id="remark" name="remark" /></td>
			</tr>
			<tr>
				<td><input type="button" value="提交" onclick="addUser()" /></td>
			</tr>
		</table>
	</form>
</body>
<script>
	function addUser(){
		var userName = $("#userName").val();
		var accountNo = $("#accountNo").val();
		var phone = $("#phone").val();
		var email = $("#email").val();
		var adress = $("#adress").val();
		var remark = $("#remark").val();
		var gender = $("#gender").val();
		$.ajax({
			type:"post",
			timeout:9000, // 超时时间设置，单位毫秒
			url:"<%=basePath %>user/addUser",
			data:{"userName":userName,"accountNo":accountNo,"phone":phone,"gender":gender,"email":email,"adress":adress,"remark":remark},
			success:function(msg){
				var result=eval("("+msg+")");
				if(result>0){
					art.dialog({
						resize:false,
						drag: false,
						lock:true,
						cancel:false,
						fixed:true,
						width:200,
						height:100,
						title:'Success', icon:'succeed',
						content:'恭喜您, 操作成功！',
						ok:function(){
							window.location.href="<%=basePath%>user/selectUser";
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
						content:'操作失败, 请刷新后再次尝试！',
						ok:function(){

						}
					});
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
</html>