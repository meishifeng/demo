<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="<%=basePath %>resource/css/welcome/welcome.css">
    <style type="text/css">
        .box_shangquan_icon{
            width: 25px;
            height: 21px;
            margin-right: 7px;
            margin-top: -3px;
            background: url(../images/search_icon_bg.png) no-repeat 0 -185px;
        }
    </style>

</head>
<body style="">


<link href="http://www.fangyouquan.com/script/common/jquery/bigautocomplete/jquery.bigautocomplete.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="http://www.fangyouquan.com/script/common/jquery/bigautocomplete/jquery.bigautocomplete.js"></script>

<div id="head">
    <div id="head_first">
        <div class="logo"><a href="http://www.fangyouquan.com/" target="_blank"><img src="http://www.fangyouquan.com/images/logo.png" alt="北京买房_北京新房_北京新房房价-北京房友圈" title="北京买房_北京新房_北京新房房价-北京房友圈"></a></div>
        <div class="head_mainmenu">
            <div class="li_0"></div>
            <a class="abc a_on" href="/">首页</a>
            <div class="li_0"></div>
            <a class="abc" href="/xinfang/">新房</a>
            <div class="li_0"></div>
            <a class="abc" href="/tuangou/">特惠</a>

        </div>
        <div class="head_log_reg"><a href="http://www.fangyouquan.com/about/sitemap.html#bj">网站地图</a></div>
        <div id="head_log_reg" class="head_log_reg"><a rel="nofollow" href="/login/toLogin.do?backurl=http%3A%2F%2Fbj.fangyouquan.com%2F">登录</a> | <a rel="nofollow" href="/register/toUserRegister.do?backurl=http%3A%2F%2Fbj.fangyouquan.com%2F">免费注册</a><a rel="nofollow" href="/login/toLogin.do?backurl=%2Fuser%2Fmessage.do">个人中心</a></div>
    </div>
    <div class="head_search_bar">
        <div class="head_search_bar_box">
            <div class="right_box"><input type="text" value="" placeholder="请输入楼盘关键词"><a href="javascript:void(0)"></a></div>
        </div>
    </div>
</div>
<script>
    (function($) {
        var h = window.location.href;
        if(h.indexOf('www') < 0 && h.indexOf('fangyouquan.com') >= 0){
            $('.head_mainmenu .abc').each(function(){
                var hr = $(this).attr('href');
                $(this).attr('href', hr.replace(_cityCode + '/', ''));
            });
        }
    })(jQuery);
</script>


<div class="top_photos" isphotobar="true">
    <div class="top_photos_parent" isphotobar="true">
        <div class="photos_box" isphotobar="true">
            <div style="width:2000px;height:300px;position: relative;" isphotobar="true">
                <div style="position:relative;" isphotobar="true">
                    <ul class="photo_ul" isphotobar="true" style="left: -4000px;">
                        <li isphotobar="true"><a href="http://bj.fangyouquan.com/loupan/5813.html" alt="德贤公馆" title="德贤公馆" target="_blank" isphotobar="true"><img src="http://static.fangyouquan.com/html_fragments/index/bj/image/09b3a508d109f7f6707380400afece32.jpg" alt="德贤公馆" title="德贤公馆" isphotobar="true"></a></li>
                        <li isphotobar="true"><a href="http://bj.fangyouquan.com/loupan/5811.html金隅上城郡" alt="" title="" target="_blank" isphotobar="true"><img src="http://static.fangyouquan.com/html_fragments/index/bj/image/099a4d33a4bf02e381b91f740a216e5e.jpg" alt="" title="" isphotobar="true"></a></li>
                        <li isphotobar="true"><a href="http://bj.fangyouquan.com/loupan/5782.html" alt="泷悦长安-大图" title="泷悦长安-大图" target="_blank" isphotobar="true"><img src="http://static.fangyouquan.com/html_fragments/index/bj/image/b3b2b3ae452121a95124f4dcbf1b9325.jpg" alt="泷悦长安-大图" title="泷悦长安-大图" isphotobar="true"></a></li>
                        <li isphotobar="true"><a href="http://bj.fangyouquan.com/loupan/5795.html" alt="中铁华侨城·和园" title="中铁华侨城·和园" target="_blank" isphotobar="true"><img src="http://static.fangyouquan.com/html_fragments/index/bj/image/bdbad063aff788286c5f590e48767261.jpg" alt="中铁华侨城·和园" title="中铁华侨城·和园" isphotobar="true"></a></li>
                        <li isphotobar="true"><a href="http://bj.fangyouquan.com/loupan/5783.html" alt="华润西山墅-大图" title="华润西山墅-大图" target="_blank" isphotobar="true"><img src="http://static.fangyouquan.com/html_fragments/index/bj/image/9cdc921d35d7c9b5608575f5681c95b6.jpg" alt="华润西山墅-大图" title="华润西山墅-大图" isphotobar="true"></a></li>
                    </ul>
                </div>
                <!-- <div class="photo_nav_bg"></div> -->
                <ul class="photo_nav" isphotobar="true">
                    <li isphotobar="true"><a href="javascript:void(0)" slider_index="0" style="background-color: rgb(255, 255, 255);" isphotobar="true">0</a></li>
                    <li isphotobar="true"><a href="javascript:void(0)" slider_index="1" isphotobar="true" style="background-color: rgb(255, 255, 255);">1</a></li>
                    <li isphotobar="true"><a href="javascript:void(0)" slider_index="2" isphotobar="true" style="background-color: red;">2</a></li>
                    <li isphotobar="true"><a href="javascript:void(0)" slider_index="3" isphotobar="true" style="background-color: rgb(255, 255, 255);">3</a></li>
                    <li isphotobar="true"><a href="javascript:void(0)" slider_index="4" isphotobar="true" style="background-color: rgb(255, 255, 255);">4</a></li>
                </ul>
                <div class="photo_ope_bar" isphotobar="true" style="display: none;">
                    <div class="prev" isphotobar="true"><a href="javascript:void(0);" alt="Arrow Prev" isphotobar="true"></a></div>
                    <div class="next" isphotobar="true"><a href="javascript:void(0);" alt="Arrow Next" isphotobar="true"></a></div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="index_intro_bar">
        <div class="box_1"><div class="box_t1">真实房源</div><div class="box_t2">房友圈内容均为真实房源</div></div>
        <div class="box_2"><div class="box_t1">真实服务</div><div class="box_t2">基于真实中介诚信体系</div></div>
        <div class="box_3"><div class="box_t1">平台保障</div><div class="box_t2">24小时400电话服务中心</div></div>
        <div class="box_4"><div class="box_4_1">24小时咨询热线：</div><div class="box_4_2">18611180843 </div></div>
    </div>


</div>



<div class="container">
    <div class="link">
        <div class="link_title"><a class="on" href="#">合作伙伴</a> </div>
        <div class="link_content2"> <a><img src="http://bj.fangyouquan.com/images/logo_baoli.jpg"></a><a><img src="http://bj.fangyouquan.com/images/logo_yuexiu.jpg"></a><a><img src="http://bj.fangyouquan.com/images/logo_shidai.jpg"></a><a><img src="/images/logo_fuli.jpg"></a><a><img src="/images/logo_hesheng.jpg"></a><a><img src="/images/logo_huarun.jpg"></a><a><img src="/images/logo_longhu.jpg"></a><a><img src="/images/logo_beichen.jpg"></a><a><img src="/images/logo_hejingtaifu.jpg"></a><a><img src="/images/logo_jiazhaoye.jpg"></a><a><img src="/images/logo_lvdi.jpg"></a><a><img src="/images/logo_xinshijie.jpg"></a><a><img src="/images/logo_zhonghai.jpg"></a><a><img src="/images/logo_yajule.jpg"></a>

        </div>
    </div>
    <div class="link">
        <div class="link_title"> <a class="on" href="#">友情链接</a></div>
        <div class="link_content">
            <p><a title="承德房产新闻" href="http://news.focus.cn/chengde/" target="_blank">承德房产新闻</a><a title="中式装修" href="http://www.cnszw.net/" target="_blank">中式装修</a></p>
        </div>
    </div>


</div>



<div class="footer">

    <%--<a href="http://www.fangyouquan.com/" target="_blank">房友圈</a> ┊<a rel="nofollow" href="http://www.fangyouquan.com/about/aboutus.html" target="_blank">关于我们</a> ┊  <a rel="nofollow" href="http://www.fangyouquan.com/about/contactus.html" target="_blank">联系我们</a> ┊  <a href="http://www.fangyouquan.com/about/joinus.html" target="_blank">加入我们</a> ┊  <a rel="nofollow" href="http://www.fangyouquan.com/about/notice.html" target="_blank">服务声明</a> ┊  <a rel="nofollow" href="http://www.fangyouquan.com/register/toUserRegister.do" target="_blank">注册会员</a> ┊  <a rel="nofollow" href="http://www.fangyouquan.com/help/feedback.html" target="_blank">意见反馈</a> ┊  <a href="http://m.fangyouquan.com/bj/">手机版</a> ┊  <a href="http://www.fangyouquan.com/sitemap/sitemap.xml">网站地图</a>┊<script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_1255697231'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s11.cnzz.com/z_stat.php%3Fid%3D1255697231' type='text/javascript'%3E%3C/script%3E"));</script><script src=" http://s11.cnzz.com/z_stat.php?id=1255697231" type="text/javascript"></script><script src="http://c.cnzz.com/core.php?web_id=1255697231&amp;t=z" charset="utf-8" type="text/javascript"></script><br>--%>
    <%--Copyright © 2014 www.fangyouquan.com All Rights Reserved     ICP号：<a rel="nofollow" href="http://www.miitbeian.gov.cn" target="_blank">粤ICP备14037918号-1</a>--%>

</div>





</html>
