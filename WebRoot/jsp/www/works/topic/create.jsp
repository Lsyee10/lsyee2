<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html lang="zh-CN">
<head>
	<title>发布照片</title>
	<script src="/js/lib/jquery/uploadify/jquery.uploadify.js" type="text/javascript"></script>
	<script src="/js/lib/jquery/validate/jquery.validate.min.js" type="text/javascript"></script>
	<script src="/js/lib/jquery/validate/jquery.validate.hook.min.js"></script>
	<script src="/js/com/www/works/topic.js?r=<%=new Random().nextInt()%>" type="text/javascript"></script>
	<script src="/js/com/www/works/photo.js?r=<%=new Random().nextInt()%>" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			topic.prepCreate("${pageContext.session.id}");
		});
	</script>
</head>
<body>
    <section class="container edit upload-pic-wrapper">
    	<span class="help right"></span>
        <ul class="thumbnails uploading-list auto"></ul>
        <div class="upload-btn">
        	<input type="file" name="image" id="upload"/>
        </div>
        <p class="text-center text-gray">
        	支持jpg、png格式，单张图片不超过10MB，尺寸不低于1200px，一次最多可以上传30张照片。
        </p>
	</section>
    <section class="container form" style="display:none;">
        <s:form method="post" theme="simple" cssClass="form">
            <s:hidden name="photoJson"/>
            <s:if test="null!=#request.tags&&#request.tags.size>0">
            <div class="select-tag-group">
            	<s:iterator value="#request.tags">
            		<span class="btn"><s:property value="value"/></span>
            	</s:iterator>
            </div>
            </s:if>
            <div class="form-group">
                <label for="">组图总说明（必填）</label>
                <span class="help right"></span>
                <s:textarea name="intro" rows="5" data-maxsize="300" placeholder="请给这组照片写文字（故事、心情、拍摄手记等都可） "/>
                <span class="help limit right">还可以输入<b>300</b>字</span>
            </div>
            <div class="form-group">
                <label for="">任务（非必选）</label>
                <span class="help right"></span>
                <s:select name="taskId" list="#request.tasks" listKey="key" listValue="value" headerKey="0" headerValue="请选择任务"/>
            </div>
            <div class="form-group">
                <label for="">小站（非必选）</label>
                <span class="help right"></span>
                <s:select name="stationId" list="#request.stations" listKey="key" listValue="value" headerKey="0" headerValue="请选择小站"/>
            </div>
            <div class="form-group">
                <label for="">填写拍摄的城市或地区（非必填）</label>
                <span class="help right"></span>
                <s:textfield name="city" placeholder="在杭州市拍摄的可填“杭州”"/>
            </div>
            <div class="form-group">
                <button type="button" class="btn btn-primary btn-xl btn-submit" onclick="topic.dealCreate()">发布</button>
                <button type="button" class="btn btn-gray btn-xl" onclick="window.location.reload()">取消</button>
            </div>
        </s:form>
    </section>
</body>
</html>
