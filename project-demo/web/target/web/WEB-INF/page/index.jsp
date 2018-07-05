<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="common/commonTools.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>工作台</title>
    <style type="text/css">
        .ul{
            list-style-type:none;
            margin-top: -5px;
        }
        .ul li{
            margin-left: -35px;
            line-height: 20px;
        }
        .ul li :HOVER {
            background-color: #ccc;
        }
        .ul li a {
            text-decoration:none;
            color: #404040;
        }
    </style>
</head>
<body style="background-color: #669999">
<div class="easyui-layout" data-options="fit:true">
    <!-- 头部 -->
    <div data-options="region:'north'" style="height:50px;text-align: center;">
        <div style="float: left;width: 20%;height:100%;"><img alt="" src="<%=basePath%>/resource/images/indexHead.jpg" style="height:100%;float: left" width="154px"></div>
        <div style="text-align: center;float: left;width: 55%;"><span style="font-size: 30px;">工作台</span></div>
        <div style="float: right;width: 20%;margin-right: 10px;margin-top: 10px;">
            <span> 欢迎您：${bean.name }</span>&nbsp;&nbsp;
            <a href="javascript:void(0)" onclick="addWindow('./sysUser/update?id=${bean.id }','修改密码','300','170')">修改密码</a>
            <a href="javascript:void(0)" onclick="loginout()">退出</a>
        </div>

    </div>

    <div id="mm" class="easyui-menu" style="width:100px;">
        <div id="closeCurrent" name="closeCurrent" data-options="iconCls:'icon-no'">关闭当前</div>
        <div id="closeOthers" name="closeOthers" data-options="iconCls:'icon-no'">关闭其它</div>
        <div id="closeAll" name="closeAll" data-options="iconCls:'icon-cancel'">关闭所有</div>
    </div>
    <div data-options="region:'west',split:true" title="菜单导航" style="width:160px;">
        <!-- menu -->
        <div class="easyui-accordion" data-options="fit:true,border:false">

            <c:forEach items="${menus }" var="item">
                <div title="${item.name }" style="padding:10px">
                    <ul class="ul">
                        <c:forEach items="${item.subList }" var="subItem">
                            <c:if test="${subItem.isShow == 1 }">
                                <li onclick="addTab('${subItem.name}','${subItem.url}','')"><a href="javascript:void(0)"  >${subItem.name}</a></li>
                            </c:if>
                        </c:forEach>
                    </ul>
                </div>
            </c:forEach>

        </div>
    </div>
    <div data-options="region:'center',title:'',iconCls:'icon-ok'" >
        <div id="tt" class="easyui-tabs" data-options="fit:true,border:false,plain:true" style="padding-bottom: 10px;">
            <div title="欢迎" data-options="href:'welcome'" style="padding:10px"></div>
        </div>
    </div>
</div>
<div id="win"></div>
</body>
<script type="text/javascript">


    $(function() {
        //生成右键菜单
        $('#tt').tabs({
            onContextMenu : function(e, title, index) {
                //选中标签
                $('#tt').tabs('select', index);
                //显示右键菜单
                $('#mm').menu('show', {
                    left : e.pageX,
                    top : e.pageY+10
                });
            }
        });

        //为每个菜单绑定点击事件
        //关闭选中的标签
        $("#closeCurrent").click(function() {
            //获取选中的标签索引
            var tab = $('#tt').tabs('getSelected');
            var index = $('#tt').tabs('getTabIndex', tab);
            $("#tt").tabs("close", index);
        });
        //关闭选中标签之外的标签
        $("#closeOthers").click(function() {
            //获取所有标签
            var tabs = $("#tt").tabs("tabs");
            var length = tabs.length;
            //获取选中标签的索引
            var tab = $('#tt').tabs('getSelected');
            var index = $('#tt').tabs('getTabIndex', tab);
            //关闭选中标签之前的标签
            for (var i = 1; i < index; i++) {
                $("#tt").tabs("close", 1);
            }
            //关闭选中标签之后的标签
            for (var i = 0; i < length - index - 1; i++) {
                $("#tt").tabs("close", 2);
            }
        });
        //关闭所有标签
        $("#closeAll").click(function() {
            var tabs = $("#tt").tabs("tabs");
            var length = tabs.length;
            for (var i = 0; i < length; i++) {
                $("#tt").tabs("close", 1);//第一个标签不关闭
            }
        });

    });

    var winWidth;
    var winHeight;
    //获取窗口宽度
    if (window.innerWidth) {
        winWidth = window.innerWidth;
    } else if ((document.body) && (document.body.clientWidth)) {
        winWidth = document.body.clientWidth;
    }
    // 获取窗口高度
    if (window.innerHeight) {
        winHeight = window.innerHeight;
    } else if ((document.body) && (document.body.clientHeight)) {
        winHeight = document.body.clientHeight;
    }
    // 通过深入 Document 内部对 body 进行检测，获取窗口大小
    if (document.documentElement && document.documentElement.clientHeight
        && document.documentElement.clientWidth) {
        winHeight = document.documentElement.clientHeight;
        winWidth = document.documentElement.clientWidth;
    }
    $(".easyui-layout").css("width", winWidth - 20);
    $(".easyui-layout").css("height", winHeight - 20);

    /* 加载菜单 */
    function addTab(title, href, icon) {
        var tt = $('#tt');
        if (tt.tabs('exists', title)) {//如果tab已经存在,则选中并刷新该tab
            tt.tabs('select', title);
            /* refreshTab({
             tabTitle : title,
             url : href
             }); */
        } else {
            var content;
            if (href) {
                content = '<iframe scrolling="no" frameborder="0"  src="'
                    + href + '" style="width:100%;height:100%;"></iframe>';
            } else {
                content = '未实现';
            }
            tt.tabs('add', {
                title : title,
                closable : true,
                content : content,
                collapsible : true,
                tools : [ {
                    iconCls : 'icon-mini-refresh',
                    handler : function() {
                        //refreshTab(title);

                    }
                } ]
            });
        }
    }

    function refreshTab(title) {
        var tt = $('#tt');
        tt.tabs('select', title);//跳转到指定tab
        var cruuTab = tt.tabs('getTab', title);//获取到当前tab的title
        var url = $(cruuTab.panel('options').content).attr('src');//获取当前tab的url
        tt.tabs('update', {
            tab : cruuTab,
            options : {
                title : title,
                href : url
                // the new content URL
            }
        });
    }

    /**
     * 刷新tab
     * @cfg
     *example: {tabTitle:'tabTitle',url:'refreshUrl'}
     *如果tabTitle为空，则默认刷新当前选中的tab
     *如果url为空，则默认以原来的url进行reload
     */
    function refreshTab1(cfg) {
        debugger
        var refresh_tab = cfg.tabTitle ? $('#tt').tabs('getTab', cfg.tabTitle)
            : $('#tt').tabs('getSelected');
        if (refresh_tab && refresh_tab.find('iframe').length > 0) {
            var _refresh_ifram = refresh_tab.find('iframe')[0];
            var refresh_url = cfg.url ? cfg.url : _refresh_ifram.src;
            //_refresh_ifram.src = refresh_url;
            _refresh_ifram.contentWindow.location.href = refresh_url;
        }
    }
    function addWindow(url, title, width, height) {
        if (width == null) {
            width = 600;
        }
        if (height == null) {
            height = 400;
        }
        $('#win').window({
            width : width,
            height : height,
            href : url,
            title : title,
            modal : true
        });
    }
    function save(url) {
        var json = $('#ff').serializeNestedObject();
        $.messager.progress(); // display the progress bar
        $('#ff').form('submit', {
            url : url,
            data : json,
            dataType : "json",
            //contentType : "application/json;charset=utf-8",
            onSubmit : function() {
                var isValid = $(this).form('validate');
                if (!isValid) {
                    $.messager.progress('close'); // hide progress bar while the form is invalid
                }
                return isValid; // return false will stop the form submission
            },
            success : function(data) {
                var data = eval('(' + data + ')'); // change the JSON string to javascript object
                $.messager.progress('close'); // hide progress bar while submit successfully
                $.messager.alert("结果", data.msg, 'info');
                closeWindow();
            },
            error : function(jqXHR) {
                alert("发生错误：" + jqXHR.status);
            }
        });
    }
    /**
     * 功能：序列化form表单元素
     * 1.同名的name属性，值会被序列化为数组，例如checkbox等控件
     * 2.可以嵌套对象，name和value会被序列化为嵌套的json对象格式
     * 3.可以嵌套对象列表，name和value会被序列化成嵌套的json数组对象
     */
    $.fn.serializeNestedObject = function() {
        var json = {};
        var arrObj = this.serializeArray();
        //alert(JSON.stringify(arrObj));
        $.each(arrObj, function() {
            // 对重复的name属性，会将对应的众多值存储成json数组
            if (json[this.name]) {
                if (!json[this.name].push) {
                    json[this.name] = [ json[this.name] ];
                }
                json[this.name].push(this.value || '');
            } else {
                // 有嵌套的属性，用'.'分隔的
                if (this.name.indexOf('.') > -1) {
                    var pos = this.name.indexOf('.');
                    var key = this.name.substring(0, pos);
                    // 判断此key是否已存在json数据中，不存在则新建一个对象出来
                    if (!existKeyInJSON(key, json)) {
                        json[key] = {};
                    }
                    var subKey = this.name.substring(pos + 1);
                    json[key][subKey] = this.value || '';
                }
                // 普通属性
                else {
                    json[this.name] = this.value || '';
                }

            }
        });

        // 处理那些值应该属于数组的元素，即带'[number]'的key-value对
        var resultJson = {};
        for ( var key in json) {
            // 数组元素
            if (key.indexOf('[') > -1) {
                var pos = key.indexOf('[');
                var realKey = key.substring(0, pos);
                // 判断此key是否已存在json数据中，不存在则新建一个数组出来
                if (!existKeyInJSON(realKey, resultJson)) {
                    resultJson[realKey] = [];
                }
                resultJson[realKey].push(json[key]);

            } else { // 单元素
                resultJson[key] = json[key];
            }
        }
        return resultJson;
    };
    /**
     * 功能：判断key在Json结构中是否存在
     * 存在，返回true; 否则，返回false.
     */
    function existKeyInJSON(key, json) {
        if (key == null || key == '' || $.isEmptyObject(json)) {
            return false;
        }
        var exist = false;
        for ( var k in json) {
            if (key === k) {
                exist = true;
            }
        }
        return exist;
    }
    function closeWindow() {
        $('#win').window('close');
    }

    function loginout() {
        $.messager.confirm('提示', '您确定要退出吗?', function(r) {
            if (r) {
                window.location.href = "logout.html";
            }
        });
    }
</script>
</html>