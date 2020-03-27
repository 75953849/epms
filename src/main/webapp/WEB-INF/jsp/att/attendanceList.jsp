<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="itheima" uri="http://itheima.com/common/" %>
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
	<link href="bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
     <link href="css/main.css" rel="stylesheet">
</head>
<body>
	<div class="row divtable">
	    <jsp:include page="../header.jsp"></jsp:include>
    	<div id="content" class="col-md-10 col-xs-10 col-sm-10" style="padding-top: 0;margin: 0;">
			<div  style="margin-top: 30px;">
				<form class="form-inline" action="toAttendanceList">
						<input type="search" name="empId" value="${param.empId }" class="form-control" placeholder="请输入职工编号">
						<input type="search" name="empName" value="${param.empName }" class="form-control" placeholder="请输入职工姓名">
						
						<button type="submit" class="btn btn-primary">Search</button>
				</form>
				<div class="table-responsive"  style="margin-top: 20px;">
						<table class="table_list table-condensed table-hover table-bordered  table-striped" >
							<thead>
								<tr>
									<th>编号</th>
									<th>姓名</th>
									<th>上午上班</th>
									<th>上午上班状态</th>
									<th>上午下班</th>
									<th>上午下班状态</th>
									<th>下午上班</th>
									<th>下午上班状态</th>
									<th>下午下班</th>
									<th>下午下班状态</th>
								</tr>	
							</thead>
							<tbody>
							<%-- <c:forEach items="${list }" var="empl">
								<tr>
									<td>${empl.id }</td>
									<td>${empl.empName }</td>
									<td>${empl.gender }</td>
									<td><fmt:formatDate value="${empl.birthday }" pattern="yyyy-MM-dd"/></td>
									<td>${empl.depId }</td>
									<td>${empl.impRoleId }</td>
									
									<td>${empl.tel }</td>
									<td>${empl.email }</td>
									<td>
										<a href="showEmp?id=${empl.id }">
											<button class="btn btn-primary btn-sm">查看</button>
										</a>
									</td>
								</tr>
								</c:forEach> --%>
							<c:forEach items="${page.list }" var="att">
								<tr>
									<td>${att.id }</td>
									<td>${att.empName }</td>
									<td><fmt:formatDate value="${att.amDate1 }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
									<td>${att.amState1 }</td>
									<td><fmt:formatDate value="${att.amDate2 }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
									<td>${att.amState2 }</td>
									<td><fmt:formatDate value="${att.pmDate1 }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
									<td>${att.pmState1 }</td>
									<td><fmt:formatDate value="${att.pmDate2 }" pattern="yyyy-MM-dd HH:mm:ss"/></td>
									<td>${att.pmState2 }</td>
								</tr>
							</c:forEach>	
							</tbody>
							<tfoot>
								<tr>
									<td colspan="10"  style="text-align: right;"> 
										<!-- 分页插件 -->
										<itheima:page url="${pageContext.request.contextPath }/toEmpList" />
			      					</td>
								</tr>
						</tfoot>
						</table>
				</div>
			</div>
        </div>
    </div>
    <script src="js/jquery-3.2.1.min.js " type="text/javascript"></script>
    <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/date.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap-datetimepicker.min.js"></script>
   	<script type="text/javascript" src="bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
    <script type="text/javascript" src="js/menu.js"></script>
</body>
</html>