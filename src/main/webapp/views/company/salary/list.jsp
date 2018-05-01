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
                <button class="btn btn-primary" data-toggle="modal" data-target="#addSingModal"><i class="fa fa-plus"></i> 单条新增</button>
                <button class="btn btn-primary" data-toggle="modal" data-target="#addModal"><i class="fa fa-plus"></i> 批量新增</button>
                <table id="salaryTable" class="table table-hover table-bordered">
                    <thead>
                    <tr>
                        <th>名字</th>
                        <th>电话</th>
                        <th>工资</th>
                        <th>日期</th>
                        <th>备注</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>



<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">批量添加</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id = "add_salary_form" name="add_salary_form" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="file" class="col-form-label">工资表:</label>
                        <input type="file" class="form-control" id="file" name="file">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                <button type="button" id="addSalary" class="btn btn-primary" >确认</button>
            </div>
        </div>
    </div>
</div>



<!-- addModal -->
<div class="modal fade" id="addSingModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">添加工资</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id = "add_single_salary_form">
                    <div class="form-group">
                        <label for="name" class="col-form-label">员工名字:</label>
                        <input type="text" class="form-control" id="name" name="name">
                    </div>
                    <div class="form-group">
                        <label for="phone" class="col-form-label">电话:</label>
                        <input type="text" class="form-control" id="phone" name="phone">
                    </div>
                    <div class="form-group">
                        <label for="date" class="col-form-label" placeholder="yyyy-mm-dd">日期:</label>
                        <input type="text" class="form-control" id="date" name="date">
                    </div>
                    <div class="form-group">
                        <label for="salary" class="col-form-label">工资:</label>
                        <input type="text" class="form-control" id="salary" name="salary">
                    </div>
                    <div class="form-group">
                        <label for="tip" class="col-form-label">备注:</label>
                        <input type="text" class="form-control" id="tip" name="tip">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" onclick="addSingleSalary()">确认</button>
            </div>
        </div>
    </div>
</div>

<script src="<%=contextPath%>/scripts/company/salary/list.js"></script>
<script type="text/javascript">
    $(function () {
        $('#addSalary').click(function () {
            var title = "批量新增工资";
            var file = document.add_salary_form.file.files[0];
            var fm = new FormData();
            fm.append('file', file);
            $.ajax(
                {
                    url: contextPath+"/salary/addSalaryByFile",
                    type: 'POST',
                    data: fm,
                    contentType: false, //禁止设置请求类型
                    processData: false, //禁止jquery对DAta数据的处理,默认会处理
                    //禁止的原因是,FormData已经帮我们做了处理
                    success: function (result) {
                        //测试是否成功
                        //但需要你后端有返回值
                        $('#addModal').modal('hide');
                        if(result==='0'){
                            showAlertModal(title,'加入成功',true);
                            loadCompanyData();
                        }else{
                            showAlertModal(title,'产生错误',false);
                        }
                    }
                }
            );
        });
    });
</script>
</body>


</html>
