$(document).ready(function() {
    loadStaffData()

});

function loadStaffData() {
    $.ajax({
        url:contextPath + "/staff/queryStaffByAdmin",
        method:"POST",
        success:function (data) {
            var dataSource = $.parseJSON(data);
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






