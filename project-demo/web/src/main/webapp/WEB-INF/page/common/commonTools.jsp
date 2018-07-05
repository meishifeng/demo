<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page isELIgnored="false" %>

<head>
    <meta charset="UTF-8">
    <link href="<%=basePath %>/resource/images/logo.ico" rel="shortcut icon">

    <script type="text/javascript" src="<%=basePath %>resource/artDialog/artDialog.source.js?skin=idialog"></script>
    <script type="text/javascript" src="<%=basePath %>resource/js/common/jquery-1.11.1.js"></script>

    <link rel="stylesheet" type="text/css" href="<%=basePath %>resource/jquery-easyui-1.5.1/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>resource/jquery-easyui-1.5.1/themes/icon.css">
    <script type="text/javascript" src="<%=basePath %>resource/jquery-easyui-1.5.1/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath %>resource/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=basePath %>resource/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js"></script>
</head>

