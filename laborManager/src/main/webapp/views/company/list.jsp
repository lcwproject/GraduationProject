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
    <title>公司信息</title>
    <%@ include file="../initRequestPage.jsp"%>
    <script src="<%=contextPath%>/scripts/company/list.js"></script>
</head>
<body>
    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <h3 class="tile-title">公司信息表</h3>
                <div class="tile-body">
                    <button class="btn btn-primary" onclick=""><i class="fa fa-plus"></i> 新增</button>
                    <table id="companyTable" class="table table-hover table-bordered">
                        <thead>
                        <tr>
                            <th>名称</th>
                            <th>地址</th>
                            <th>邮箱</th>
                            <th>热力链接</th>
                            <th>介绍</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
