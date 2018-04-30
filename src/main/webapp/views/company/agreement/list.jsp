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
            <h3 class="tile-title">公司协议表</h3>
            <div class="tile-body">
                <table id="agreementTable" class="table table-hover table-bordered">
                    <thead>
                    <tr>
                        <th>编号</th>
                        <th>员工</th>
                        <th>标题</th>
                        <th>开始时间</th>
                        <th>结束时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>

<div class="row">
    <div class="col-md-12">
        <div class="tile">
            <h3 class="tile-title">公司协议预警表</h3>
            <div class="tile-body">
                <table id="agreementAlarmTable" class="table table-hover table-bordered">
                    <thead>
                    <tr>
                        <th>编号</th>
                        <th>员工</th>
                        <th>标题</th>
                        <th>开始时间</th>
                        <th>结束时间</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>

<!-- detailModal -->
<div class="modal fade" id="detialModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title"></h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">

            </div>
            <form id = "delete_company_form">
                <input type="hidden" id="deleteId" />
            </form>
            <div class="modal-footer">

                <button type="button" class="btn btn-primary" data-dismiss="modal">确认</button>
            </div>
        </div>
    </div>
</div>





<script src="<%=contextPath%>/scripts/company/agreement/list.js"></script>


</body>
</html>