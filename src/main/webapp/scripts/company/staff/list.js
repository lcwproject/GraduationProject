$(document).ready(function() {
    loadCompanyData();
    initDeleteModal()
});

function loadCompanyData() {
    var dataSource = null;
    $.ajax({
        url:contextPath + "/staff/queryStaff",
        method:"POST",
        success:function (data) {
            dataSource = $.parseJSON(data);
            $('#companyTable').DataTable({
                data:dataSource,
                columns:[
                    { data: 'name' },
                    { data: 'phone' },
                    { data: 'address' },
                    { data: 'aId' },
                    { data:
                            function (data) {
                                return '<a href="#" data-toggle="modal" data-target="#deleteModal" data-deleteid = "'+ data.id +'" data-deletename = " '+ data.name +' ">删除</a>';
                            }
                    }
                ]
            });
        }
    });
}

function openAddModal() {

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
    var title = "删除人员";
    $.ajax({
        type: 'POST',
        url: contextPath+"/staff/deleteStaff",
        data:param,
        success : function(data) {
            $('#deleteModal').modal('hide');
            if(data==='error'){
                showAlertModal(title,'产生错误',false);
            }else{
                showAlertModal(title,'删除成功',true);
            }
        },
        error : function() {
            $('#deleteModal').modal('hide');
            showAlertModal(title,'系统发生错误',false);
        },
        dataType: 'json'
    });
}
