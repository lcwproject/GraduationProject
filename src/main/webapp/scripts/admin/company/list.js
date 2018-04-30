$(document).ready(function() {
    loadCompanyData();
    initDeleteModal()
});

function loadCompanyData() {
    $.ajax({
        url:contextPath + "/company/queryCompanyByAdmin",
        method:"POST",
        success:function (data) {
            var dataSource = $.parseJSON(data);
            table = $('#companyTable').DataTable({
                data:dataSource,
                columns:[
                    { data: 'companyName' },
                    { data: 'address' },
                    { data: 'email' },
                    { data: 'hotlint' },
                    { data: 'introduction' },
                    { data:
                            function (data) {
                                return '<a href="#" data-toggle="modal" data-target="#deleteModal" data-deleteid = "'+ data.companyId +'" data-deletename = " '+ data.companyName +' ">删除</a>';
                            }
                    }
                ]
            });
            table.draw(false);
        }
    });
}

function initDeleteModal() {
    $('#deleteModal').on('show.bs.modal', function (event) {
        var trigger = $(event.relatedTarget);
        var id = trigger.data('deleteid');
        var name = trigger.data('deletename');
        var modal = $(this);
        modal.find('.modal-body').text("确认删除"+name+"?");
        modal.find('#deleteId').val(id);
    })
}

function deleteCompany() {
    var id = $('#deleteId').val();
    var param = {};
    param.id=id;
    var title = "删除公司";
    $.ajax({
        type: 'POST',
        url: contextPath+"/company/deleteCompany",
        data:param,
        success : function(data) {
            $('#deleteModal').modal('hide');
            if(data==='0'){
                showAlertModal(title,'删除成功',true);
            }else{
                showAlertModal(title,'产生错误',false);
            }
        },
        error : function() {
            $('#deleteModal').modal('hide');
            showAlertModal(title,'系统发生错误',false);
        },
        dataType: 'json'
    });
}

function addCompany() {
    var title = "新增公司";
    var param = $("#add_company_form").serializeObject();
    //todo 校验表单输入
    $.ajax({
        type: 'POST',
        url: contextPath+"/company/addCompany",
        data:param,
        success : function(data) {
            $('#addModal').modal('hide');
            if(data==='0'){
                showAlertModal(title,'加入成功',true);
            }else{
                showAlertModal(title,'产生错误',false);
            }
        },
        error : function() {
            $('#addModal').modal('hide');
            showAlertModal(title,'系统发生错误',false);
        },
        dataType: 'json'
    });
}
