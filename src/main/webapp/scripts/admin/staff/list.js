$(document).ready(function() {
    loadStaffData();
    table = null;
});

function loadStaffData() {
    $.ajax({
        url:contextPath + "/staff/queryStaffByAdmin",
        method:"POST",
        success:function (data) {
            var dataSource = $.parseJSON(data);
            if(table!==null){
                table.destroy();
            }
            table = $('#companyTable').DataTable({
                data:dataSource,
                columns:[
                    { data: 'name' },
                    { data: 'phone' },
                    { data: 'address' }
                ]
            });
            table.draw(false);
        }
    });
}






