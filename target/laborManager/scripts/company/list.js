$(document).ready(function() {
    loadCompanyData();
    initDeleteModal()
});

function loadCompanyData() {
    var dataSource = null;
    $.ajax({
        url:contextPath + "/company/selectList",
        method:"POST",
        success:function (data) {
            dataSource = $.parseJSON(data);
            $('#companyTable').DataTable({
                data:dataSource,
                columns:[
                    { data: 'companyName' },
                    { data: 'address' },
                    { data: 'email' },
                    { data: 'hotlint' },
                    { data: 'introduction' },
                    { data:
                            function (data) {
                                debugger;
                                return '<a href="#" data-toggle="modal" data-target="#deleteModal" data-deleteid = "'+ data.id +'" data-deletename = " '+ data.companyName +' ">删除</a>';
                            }
                    }
                ]
            });
        }
    });
}

function initDeleteModal() {
    $('#deleteModal').on('show.bs.modal', function (event) {
        var trigger = $(event.relatedTarget);
        var id = trigger.data('deleteid');
        var name = trigger.data('deletename');
        debugger;
        var modal = $(this);
        modal.find('.modal-body').text("确认删除"+name+"?");
        modal.find('#deleteId').val(id);
    })
}

function deleteCompany() {
    var id = $('#deleteId').val();
    debugger;
}