$(document).ready(function() {
    table = null;
    loadStaffData();
    initDeleteModal()
});

function loadStaffData() {
    $.ajax({
        url:contextPath + "/staff/queryStaffByCompany",
        method:"POST",
        success:function (data) {
            var dataSource = $.parseJSON(data);
            if(table!==null){
                table.destroy();
            }
            table = $('#staffTable').DataTable({
                data:dataSource,
                columns:[
                    { data: 'name' },
                    { data: 'phone' },
                    { data: 'address' },
                    { data: 'agreementId' },
                    { data:
                            function (data) {
                                return '<a href="#" data-toggle="modal" data-target="#deleteModal" data-deleteid = "'+ data.staffId +'" data-deletename = " '+ data.name +' ">删除</a>';
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


function deleteStaff() {
    var id = $('#deleteId').val();
    var param = {};
    param.id=id;
    var title = "删除员工";
    $.ajax({
        type: 'POST',
        url: contextPath+"/staff/deleteStaff",
        data:param,
        success : function(data) {
            $('#deleteModal').modal('hide');
            if(data==='0'){
                showAlertModal(title,'删除成功',false);
                loadStaffData();
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

function addStaff() {
    var title = "新增员工";
    var param = $("#add_staff_form").serializeObject();
    //todo 校验表单输入
    $.ajax({
        type: 'POST',
        url: contextPath+"/staff/addStaff",
        data:param,
        success : function(data) {
            $('#addModal').modal('hide');
            if(data==='0'){
                showAlertModal(title,'加入成功',true);
                loadStaffData();
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




