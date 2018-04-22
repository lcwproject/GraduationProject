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
            <h3 class="tile-title">公司信息</h3>
            <div class="tile-body">
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal"><i class="fa fa-plus"></i>新增</button>
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
<!-- 删除Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">确定删除吗？</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary">确定</button>
            </div>
        </div>
    </div>
</div>
<%--新增modal--%>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">新增公司信息</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="company-name" class="col-form-label">名称:</label>
                        <input type="text" class="form-control" id="company-name">
                    </div>
                    <div class="form-group">
                        <label for="address-text" class="col-form-label">地址:</label>
                        <textarea class="form-control" id="address-text"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="email" class="col-form-label">邮箱:</label>
                        <input type="text" class="form-control" id="email">
                    </div>
                    <div class="form-group">
                        <label for="hotlink" class="col-form-label">热力链接:</label>
                        <textarea class="form-control" id="hotlink"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="introduction" class="col-form-label">介绍:</label>
                        <textarea class="form-control" id="introduction"></textarea>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
