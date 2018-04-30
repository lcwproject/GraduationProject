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
                <button class="btn btn-primary" data-toggle="modal" data-target="#addModal"><i class="fa fa-plus"></i> 新增</button>
                <table id="staffTable" class="table table-hover table-bordered">
                    <thead>
                    <tr>
                        <th>名字</th>
                        <th>电话</th>
                        <th>地址</th>
                        <th>协议编号</th>
                        <th>操作</th>
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
                <h4 class="modal-title">删除员工</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                确认删除？
            </div>
            <form id = "delete_Staff_form">
                <input type="hidden" id="deleteId" />
            </form>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" onclick="deleteStaff()">确认</button>
            </div>
        </div>
    </div>
</div>

<!-- addModal -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">添加员工</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id = "add_staff_form">
                    <div class="form-group">
                        <label for="name" class="col-form-label">员工名字:</label>
                        <input type="text" class="form-control" id="name" name="name">
                    </div>
                    <div class="form-group">
                        <label for="address" class="col-form-label">地址:</label>
                        <input type="text" class="form-control" id="address" name="address">
                    </div>
                    <div class="form-group">
                        <label for="phone" class="col-form-label">联系电话:</label>
                        <input type="text" class="form-control" id="phone" name="phone">
                    </div>
                    <div class="form-group">
                        <label for="title" class="col-form-label">协议:</label>
                        <input type="text" class="form-control" id="title" name="title">
                    </div>
                    <div class="form-group">
                        <label for="content" class="col-form-label">协议内容:</label>
                        <textarea  type="text" class="form-control" id="content" name="content" ></textarea>
                    </div>
                    <div class="form-group">
                        <label for="startTime" class="col-form-label">开始时间:</label>
                        <input  type="text" class="form-control" id="startTime" name="startTime" ></input>
                    </div>
                    <div class="form-group">
                        <label for="endTime" class="col-form-label">结束时间:</label>
                        <input  type="text" class="form-control" id="endTime" name="endTime" ></input>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" onclick="addStaff()">确认</button>
            </div>
        </div>
    </div>
</div>

<script src="<%=contextPath%>/scripts/company/staff/list.js"></script>
</body>
</html>
