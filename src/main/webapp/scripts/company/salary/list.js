$(document).ready(function() {
    loadCompanyData();
});

function loadCompanyData() {
    $.ajax({
        url:contextPath + "/salary/querySalaryByCompany",
        method:"POST",
        success:function (data) {
            var dataSource = $.parseJSON(data);
            table = $('#salaryTable').DataTable({
                data:dataSource,
                columns:[
                    { data: 'name' },
                    { data: 'phone' },
                    { data: 'salary' },
                    { data: 'dateToShow' },
                    { data: 'tip' }
                ]
            });
            table.draw(false);
        }
    });
}

function addSingleSalary() {
     var title = "单条新增工资";
     var param = $("#add_single_salary_form").serializeObject();
    //todo 校验表单输入
     $.ajax({
         type: 'POST',
         url: contextPath+"/salary/addSalary",
         data:param,
         success : function(data) {
             $('#addSingModal').modal('hide');
             if(data==='0'){
               showAlertModal(title,'加入成功',true);
                 loadCompanyData();
             }else{
                 showAlertModal(title,'产生错误',false);
             }
         },
         error : function() {
             $('#addSingModal').modal('hide');
             showAlertModal(title,'系统发生错误',false);
         },
         dataType: 'json'
     });
}


