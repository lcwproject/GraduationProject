$(document).ready(function() {
    loadCompanyData();
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
                            function (data,type,row,meta) {
                                return '<a href="#" onclick="openDeleteDialog()">删除</a>';
                            }
                    }
                ]
            });
        }
    });
}

function openDeleteDialog() {
    BootstrapDialog.show({
        title:"删除公司",
        message : "确认删除？",
        buttons : [ {
            label : '取消',
            action : function(dialogItself) {
                dialogItself.close();
            }
        } ]
    });
}
