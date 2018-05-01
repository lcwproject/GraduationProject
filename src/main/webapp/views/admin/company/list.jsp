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
    <%@ include file="../../initRequestPage.jsp"%>
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/resources/css/admin/main.css">
</head>
<body>
    <div class="row">
        <div class="col-md-12">
            <div class="tile">
                <h3 class="tile-title">公司信息表</h3>
                <div class="tile-body">
                    <button class="btn btn-primary" data-toggle="modal" data-target="#addModal"><i class="fa fa-plus"></i> 新增</button>
                    <table id="companyTable" class="table table-hover table-bordered">
                        <thead>
                        <tr>
                            <th>名称</th>
                            <th>地址</th>
                            <th>邮箱</th>
                            <th>联系电话</th>
                            <th>介绍</th>
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
                    <h4 class="modal-title">删除公司</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    确认删除？
                </div>
                <form id = "delete_company_form">
                    <input type="hidden" id="deleteId" />
                </form>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary" onclick="deleteCompany()">确认</button>
                </div>
            </div>
        </div>
    </div>

    <!-- addModal -->
    <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">添加公司</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id = "add_company_form">
                        <div class="form-group">
                            <label for="companyName" class="col-form-label">公司名称:</label>
                            <input type="text" class="form-control" id="companyName" name="companyName">
                        </div>
                        <div class="form-group">
                            <label for="address" class="col-form-label">公司地址:</label>
                            <input type="text" class="form-control" id="address" name="address">
                        </div>
                        <div class="form-group">
                            <label for="address" class="col-form-label">联系电话:</label>
                            <input type="text" class="form-control" id="hotlint" name="hotlint">
                        </div>
                        <div class="form-group">
                            <label for="email" class="col-form-label">公司邮箱</label>
                            <input type="text" class="form-control" id="email" name="email">
                        </div>
                        <div class="form-group">
                            <label for="password" class="col-form-label">登录密码</label>
                            <input type="password" class="form-control" id="password" name="password">
                        </div>
                        <div class="form-group">
                            <label for="introduction" class="col-form-label">公司介绍:</label>
                            <textarea  type="text" class="form-control" id="introduction" name="introduction" ></textarea>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary" onclick="addCompany()">确认</button>
                </div>
            </div>
        </div>
    </div>

    <script src="<%=contextPath%>/scripts/admin/company/list.js"></script>
</body>
</html>
