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

    <!-- Modal -->
    <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
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
                <input type="hidden" id="deleteId" />
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary" onclick="deleteCompany()">确认</button>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
