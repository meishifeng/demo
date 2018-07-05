<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/commonTools.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户管理</title>

</head>
<body >
<div id="main"  class="main">
    <div id="tb" style="padding:5px;height:auto">
        <div style="margin-bottom:5px">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" title="添加" plain="true" onclick="addWindow('sms/add','添加短信平台',600,500)"></a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" title="修改" plain="true" onclick="edit('sms/edit','修改短信平台',600,500)"></a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" title="删除" plain="true" onclick="del('sms/del')"></a>
            供应商名：<input class="easyui-textbox" id="name" name="name" style="width:180px" >
            创建日期： <input class="easyui-datebox" id="start" name="start" style="width:100px">
            至: <input class="easyui-datebox" id="end" name="end" style="width:100px">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="search1()">查询</a>
        </div>
    </div>

    <div>
        <a class="aui_button" href="javascript:importExecl()">
            <div class="ui_button_fzy btnblue" style="margin-left: 0;">批量导入经纪人</div>
        </a>
    </div>


</div>

</body>
<script type="text/javascript">
    function search1(){
        $('#dg').datagrid({
            queryParams: {
                name: $("#name").val(),
                start: $("#start").val(),
                end: $("#end").val()
            }
        });
    }
    // 绑定查询参数,此方法在head.jsp中调用 ，
    function initParams(){
        var queryParams = $('#dg').datagrid('options').queryParams;
        queryParams.name =$("#name").val();
        queryParams.start =  $("#start").val();
        queryParams.end= $("#end").val();
    };

    function getTemplate(){
        window.location.href="<%=basePath%>excel/getTemplate.do";
    }

    function importExecl() {
        var b ="<input id='file' type='file' name='file'/> <input id='template' onclick='getTemplate()' type='button' value='导入模版'/>";
        doDialog(b,function(){
            var fileLen=$("#file").val();
            if(!fileLen){
                closeWin();
                artDialogError("上传文件不能空","reload");
                return false;
            }
            var form = $('<form></form>');
            form.attr('action', '<%=basePath%>noCentalineAgentApp/importExecl.do');
            form.attr('enctype', 'multipart/form-data');
            form.attr('method', 'post');
            form.css('display','none');
            form.append($("#file"));
            closeWin();
            $(document.body).append(form);
            form.submit();
        });
    }

    function doDialog(content,func) {
        art.dialog({
            cancel : false,
            title : "提示",
            resize : false,
            lock : true,
            icon : "warning",
            content : content,
            button : [ {
                name : "取消",
                callback : function() {
                    closeWin();
                }
            }, {
                name : "确认",
                callback : function() {
                    func();
                }
            }]
        });
    }



    // 错误提示
    function artDialogError(content, url){
        art.dialog({
            resize:false,
            drag: false,
            lock:true,
            cancel:false,
            fixed:true,
            width:200,
            height:100,
            title:'Error',
            icon:'error',
            content:content,
            ok:function(){
                if(null != url && 'reload'== url){
                    window.location.reload();
                }
                else if(null!=url){
                    window.location.href=url;
                }
            }
        });
    }

    function closeWin() {
        var list = art.dialog.list;
        for (var tmp in list) {
            if(typeof list[tmp] != 'undefined' || list[tmp] != null){
                list[tmp].close();
            }
        }
    }





</script>
</html>