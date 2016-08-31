<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set id="URI_PATH" value="#request.get('struts.request_uri')"/>
<!DOCTYPE html>
<!--[if lte IE 7]><script type="text/javascript">window.location.href="/ie/index.html";</script><![endif]-->
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
    <!-- 如果使用的是IE且支持GCF，则使用GCF渲染，否则忽略；如果使用的是IE8或以上，则使用最高版本IE渲染，否则忽略 -->
    <!--[if IE]><meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><![endif]-->
    <!-- 使用响应式布局 -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <!-- 上述3个meta标签必须放在最前面，任何其他内容都必须跟随其后！ -->
    <!-- 让国产浏览器使用高速模式渲染页面 -->
    <meta name="renderer" content="webkit">
    <!-- 禁止手机百度转码 -->
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <!-- 网站图标 -->
    <link rel="icon" type="image/x-icon" href="/img/www/favicon.ico">
    <!-- Android设备浏览器设置 -->
    <meta name="mobile-web-app-capable" content="yes">
    <link rel="icon" sizes="192x192" href="/img/www/app-icon72x72@2x.png">
    <!-- iOS设备浏览器设置 -->
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="telephone=no">
    <meta name="apple-mobile-web-app-title" content="KPKPW" />
    <link href="/img/www/app-icon72x72@2x.png" rel="apple-touch-icon-precomposed">
    <!-- Win8磁贴设置 -->
    <meta name="msapplication-TileImage" content="/img/www/app-icon72x72@2x.png">
    <meta name="msapplication-TileColor" content="#ec6617">
	<meta content="all" name="robots" />
	<meta name="renderer" content="webkit">
	<meta name="author" content="www.hbjt.com.cn,杭州日报报业集团信息技术处,杭报集团信息技术处"/>
	<meta name="copyright" content="www.kpkpw.com,快拍快拍网,都市快报,杭州日报报业集团,杭报集团" />
	<meta name="keywords" content="快拍,快拍快拍,摄影活动,深度摄影,摄影名家,摄影展览,每天看世界上最好的照片,快拍之星,摄影基地,摄影微博,摄影器材,摄影论坛,名家访谈,抢书读,市民摄影节 " />
	<meta name="description" content="快拍快拍网，是一个当代图片社区网站，隔三差五发起一些又好玩又温暖，又有点意思又有点意义的各种快拍活动。" />
	<title><decorator:title default="快拍快拍网- 生活因温暖而美好 - 快拍快拍"/></title>
	<link href="/css/www/common.min.css?r=<%=new Random().nextInt()%>" rel="stylesheet">
	<!--[if lt IE 9]><script src="/js/plus/html5shiv.min.js"></script><![endif]-->
	<script src="/js/lib/jquery/jquery-2.1.4.min.js" type="text/javascript"></script>
	<script src="/js/lib/jquery/jquery-migrate-1.2.1.js" type="text/javascript"></script>
	<script src="/js/lib/jquery/html5/html5shiv.min.js" type="text/javascript"></script>
	<script src="/js/lib/jquery/html5/respond.min.js" type="text/javascript"></script>
	<script src="/js/lib/jquery/html5/jquery.lazyload.min.js" type="text/javascript"></script>
	<script src="/js/lib/jquery/modal/box.min.js" type="text/javascript"></script>
	<script src="/js/com/www/util.js?r=<%=new Random().nextInt()%>" type="text/javascript"></script>
	<script src="/js/com/www/plus.js?r=<%=new Random().nextInt()%>" type="text/javascript"></script>
	<script src="/js/com/www/user/relation.js?r=<%=new Random().nextInt()%>" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			// 返回顶部
			plus.backTop();
			
			// 图片延迟加载
			$(".img img").lazyload({
                //图片延时加载
                threshold: 400, 
                effect: "fadeIn", //淡入效果
                load: function () {//加载成功之后，移除gif背景图
                    $(this).parent().css('backgroundImage', 'none');
                }
                
            });
            
		    //顶部导航下拉
		    $('.dropdown').hover(function () {
		        $(this).addClass('active').children('ul').stop(true, false).fadeIn(150);
		    }, function () {
		        $(this).removeClass('active').children('ul').stop(true, false).fadeOut(150);
		    });
		
		    //小分辨率下顶部菜单展开与收缩
		    $(document).on("click", ".navbar-toggle", function () {
		        $(this).next().toggle().next().toggle();
		    });
		    
			//搜索
			$('.search-key').bind('keyup focus', function() {
				//输入的内容
				var key = $(this).val();
				var down_div = $('.search-type');
				
				if (key.length > 0) {
			        //如果输入的文字大于0，则显示搜索类型
			        down_div.show().find('span').text(key);
					down_div.find('a').eq(0).attr("href", "/sys/search/works.action?keyword=" + key);
					down_div.find('a').eq(1).attr("href", "/sys/search/user.action?keyword=" + key);
					down_div.find('a').eq(2).attr("href", "/sys/search/activity.action?keyword=" + key);
			    } else {
			        //如果小于0，隐藏搜索类型
			        down_div.slideUp(100);
			    }
			}).blur(function() {
				//失去焦点，隐藏下拉框
				$('.search-type').delay(200).slideUp(100);
			});
		});
	</script>
	<decorator:head/>
</head>
<body <decorator:getProperty property="page.bodyClass"/>>
	<page:applyDecorator name="head1"/>
		<!--正文右侧-->
		<decorator:body />
	<page:applyDecorator name="foot1"/>
</body>
</html>
