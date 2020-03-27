<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>表格</title>
<base href="<%= request.getServletContext().getContextPath()%>/">
<link rel="shortcut icon" href="img/favicon.ico">
<!-- Bootstrap3.3.5 CSS -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!-- datatime -->
<link href="bootstrap/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet">
<link href="css/main.css" rel="stylesheet">

</head>

<body>
	<div class="row">
		<jsp:include page="../header.jsp"></jsp:include>
		<div id="content" class="col-md-10 col-xs-10 col-sm-10" style="padding-top: 0; margin: 0;">
		<div  style="margin-top: 30px;">
			<div id="personaldiv">
				<form class="form-horizontal" action="attendance" method="post"
					enctype="multipart/form-data">
					<fieldset>
						
						<script>
					        Date.prototype.format = function (fmt) {
					            var o = {
					                "y+": this.getFullYear, //年
					                "M+": this.getMonth() + 1, //月份
					                "d+": this.getDate(), //日
					                "h+": this.getHours(), //小时
					                "m+": this.getMinutes(), //分
					                "s+": this.getSeconds() //秒
					            };
					            if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
					            for (var k in o)
					                if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
					            return fmt;
					        }
					        setInterval("document.getElementById('dateTime').innerHTML = (new Date()).format('yyyy-MM-dd hh:mm:ss');", 1000);
					    </script>
					    <input type="hidden" name="empId" value="${e.id }" />
					    <input type="hidden" name="empName" value="${e.empName }" />
					    
					    <div class="form-group">
							<label class="control-label col-md-2 col-xs-2 col-sm-2">当前时间:</label>
							<div class="col-md-4 col-xs-4 col-sm-4">
								<label id="dateTime" class="control-label col-md-2 col-xs-2 col-sm-2"></label>
								
							</div>
						</div>
					    <div class="form-group">
							<label class="control-label col-md-2 col-xs-2 col-sm-2">${msg }</label>
							<div class="col-md-4 col-xs-4 col-sm-4">
								
								
							</div>
						</div>
					 	
						
						
					</fieldset>
					
					<div class="form-group col-md-5 col-xs-5 col-sm-5"
						style="text-align: center;">
						<input type="submit" class="btn btn-success" value="签 到" />
					</div>
				</form>
			</div>
			
			
			
			
			</div>
		</div>
	</div>
	<script src="js/jquery-3.2.1.min.js "></script>
	<script src="bootstrap/js/bootstrap.min.js "></script>
	<script type="text/javascript" src="js/date.js"></script>
	<script type="text/javascript"
		src="bootstrap/js/bootstrap-datetimepicker.min.js"></script>
	<script type="text/javascript"
		src="bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
	<script type="text/javascript" src="js/menu.js"></script>
	<script>
		$(function() {
			$('#datetimepicker').datetimepicker({
				format : 'yyyy-MM-dd HH:mm:ss',
				autoclose : true,
				minView : 2
			});
		});
	</script>
</body>

</html>




