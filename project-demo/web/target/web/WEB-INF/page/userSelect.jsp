<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/commonTools.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="<%=basePath %>js/common/jquery-1.11.1.js"></script>

</head>
<body>
	
	<h2> -------------------- 用户信息查询页面  ------------------- </h2>
	
	<a href="<%=basePath %>jsp/userAdd.jsp">新增</a><br/><br/><br/>
	
	<table border="1">
		<tr>
			<th style="width:300px;">姓名</th>
			<th style="width:300px;">账号</th>
			<th style="width:300px;">手机号</th>
			<th style="width:300px;">性别</th>
			<th style="width:300px;">邮箱</th>
			<th style="width:300px;">地址</th>
			<th style="width:300px;">备注</th>
			<th style="width:300px;">操作</th>
		</tr>
		<c:forEach items="${userList }" var="u">
			<tr>
				<td>${u.userName }</td>
				<td>${u.accountNo }</td>
				<td>${u.phone }</td>
				<td>${u.gender }</td>
				<td>${u.email }</td>
				<td>${u.adress }</td>
				<td>${u.remark }</td>
				<td>&nbsp;
					<a href="<%=basePath %>user/selectUser/${u.id}">修改</a>  &nbsp;
					<a href="javascript:void(0);" onclick="delUser(${u.id})">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>

	
	<script type="text/javascript">
		function delUser(obj){
			art.dialog({
				resize:false,
				drag: false,
				lock:true,
				cancel:false,
				fixed:true,
				width:200,
				height:100,
				title: '提示',
				content: '您确定要删除该吗？',
				okValue: '确定',
				ok: function() {
					$.ajax({
						type:"DELETE",
						dataType:'json',
						url:"<%=basePath %>user/deleteUser/"+obj,
						data:{},
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
									content:'恭喜您, 删除成功！',
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
									content:'删除失败, 请重新尝试！',
									ok:function(){

									}
								});
							}
						}
					});

				},
				cancelValue: '取消',
				cancel: function() {}
			});
		}
	</script>
	

</body>
</html>