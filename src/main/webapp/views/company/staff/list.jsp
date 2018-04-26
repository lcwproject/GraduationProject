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
    <title>人员信息</title>
    <%@ include file="../../initRequestPage.jsp"%>
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/resources/css/admin/main.css">
</head>
<body>
<div class="row">
    <div class="col-md-12">
        <div class="tile">
            <h3 class="tile-title">人员信息表</h3>
            <div class="tile-body">
                <table id="agreementTable" class="table table-hover table-bordered">
                    <thead>
                    <tr>
                        <th>姓名</th>
                        <th>电话</th>
                        <th>地址</th>
                        <th>协议编号</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>

<!-- deleteModal -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">删除人员</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                确认删除？
            </div>
            <form id = "delete_staff_form">
                <input type="hidden" id="deleteId" />
            </form>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" onclick="deleteStaff()">确认</button>
            </div>
        </div>
    </div>
</div>

<script src="<%=contextPath%>/scripts/company/staff/list.js"></script>
</body>
</html>
