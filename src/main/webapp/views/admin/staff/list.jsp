<%--
  Created by IntelliJ IDEA.
  User: Dustin
  Date: 2018/4/21
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工列表</title>
    <%@ include file="../../initRequestPage.jsp"%>
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/resources/css/admin/main.css">
</head>
<body>
<div class="row">
    <div class="col-md-12">
        <div class="tile">
            <h3 class="tile-title">员工信息表</h3>
            <div class="tile-body">
                <table id="companyTable" class="table table-hover table-bordered">
                    <thead>
                    <tr>
                        <th>名字</th>
                        <th>电话</th>
                        <th>地址</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>
<script src="<%=contextPath%>/scripts/admin/staff/list.js"></script>
</body>
</html>
