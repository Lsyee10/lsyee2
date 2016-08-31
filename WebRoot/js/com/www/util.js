/**
 * Project:jteip 
 * Copyright (c) Hang Zhou Daily Press Group All rights reserved
 * 
 * @author wu guang jing
 */

/**
 * 表单序列化
 */
$.fn.serializeObject = function() {
	var o = {};
	var a = this.serializeArray();
	try{
		$.each(a, function() {
			if (o[this.name] !== undefined) {
				if (!o[this.name].push) {
					o[this.name] = [ o[this.name] ];
				}
				o[this.name].push(this.value || '');
			} else {
				o[this.name] = this.value || '';
			}
		});
		return o;
	}catch(e){
		alert(e.message);
	}finally{
		o = null;
		a = null;
	}
};

util = {
	RESULT_NONE : "none",
	RESULT_EXIST : "exist",
	RESULT_ERROR : "error",
	RESULT_LOGIN : "login",
	RESULT_INPUT : "input",
	RESULT_SUCCESS : "success",
	RESULT_FAILURE : "failure",
	IF_LOGIN_URL :"/fore/user/inout/ifLogin.action"
};

/**
 * 本地化日期插件
 */
util.DATE_ZH_CN={ 
    clearText: '清除', 
    clearStatus: '清除已选日期', 
    closeText: '关闭', 
    closeStatus: '不改变当前选择', 
    prevText: '<上月', 
    prevStatus: '显示上月', 
    prevBigText: '<<', 
    prevBigStatus: '显示上一年', 
    nextText: '下月>', 
    nextStatus: '显示下月', 
    nextBigText: '>>', 
    nextBigStatus: '显示下一年', 
    currentText: '今天', 
    currentStatus: '显示本月', 
    monthNames: ['一月','二月','三月','四月','五月','六月', '七月','八月','九月','十月','十一月','十二月'], 
    monthNamesShort: ['一','二','三','四','五','六', '七','八','九','十','十一','十二'], 
    monthStatus: '选择月份', 
    yearStatus: '选择年份', 
    weekHeader: '周', 
    weekStatus: '年内周次', 
    dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'], 
    dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'], 
    dayNamesMin: ['日','一','二','三','四','五','六'], 
    dayStatus: '设置 DD 为一周起始', 
    dateStatus: '选择 m月 d日, DD', 
    dateFormat: 'yy-mm-dd', 
    firstDay: 1, 
    initStatus: '请选择日期', 
    isRTL: false
};

/**
 * 登录校验
 */
util.ifLogin = function(){
	var rst = true;
	$.ajax({
		async : false,
		type : "GET",
		url : util.IF_LOGIN_URL,
		dataType : "json",
		success : function(data) {
			if(data.actionDealMsg==util.RESULT_NONE){
				rst = false;
			}
		}
	});
	return rst;
};

/**
 * 获取当前日期
 */
util.curDate = function(){
	var d= new Date();
	var dd=d.getDate();
	var mm= d.getMonth()+1;
	var yyyy= d.getFullYear();
	if(parseInt(mm)<10){
		mm="0"+mm;
	}
	if(parseInt(dd)<10){
		dd="0"+dd;
	}
	return yyyy+"-"+mm+"-"+dd;
};

/**
 * 获取比较日期
 * 
 * @param startDate
 * @param endDate
 */
util.cmpDate = function(strDate1,strDate2){
	var date1 = new Date(strDate1.replace(/\-/g, "\/"));
    var date2 = new Date(strDate2.replace(/\-/g, "\/"));
    return date1-date2;
};

/**
 * 获取日期差值
 * 
 * @param startDate
 * @param endDate
 */
util.diffDate = function(strDate1,strDate2){
	var date1 = new Date(strDate1.replace(/\-/g, "\/"));
    var date2 = new Date(strDate2.replace(/\-/g, "\/"));
    return (date1-date2)/(24 * 60 * 60 *1000);
};

/**
 * 获取日期加天数
 * 
 * @param startDate
 * @param endDate
 */
util.addDate = function(strDate,days){
	var date = new Date(strDate.replace(/\-/g, "\/"));
	date.setDate(date.getDate()+parseInt(days));
	var dd=date.getDate();
	var mm= date.getMonth()+1;
	if(parseInt(mm)<10){
		mm="0"+mm;
	}
	if(parseInt(dd)<10){
		dd="0"+dd;
	}
	return date.getFullYear()+"-"+mm+"-"+dd;
}; 

/**
 * 获取月份的最后一天
 * 
 * @param year
 * @param month
 */
util.getMonthLastDate = function(year, month){
	var date = new Date(year,month,0);
	var dd=date.getDate();
	var mm= date.getMonth()+1;
	if(parseInt(mm)<10){
		mm="0"+mm;
	}
	if(parseInt(dd)<10){
		dd="0"+dd;
	}
	return date.getFullYear()+"-"+mm+"-"+dd;
}; 
