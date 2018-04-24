$(document).ready(function(){
    loadCompanyData();
    // loadDealData;
    // loadSalaryData;
});

function loadCompanyData(){

    var dataSource = null;

    $.ajax({
        url:contextPath + "/company/selectList",
        method:"POST",
        success:function (data) {

            dataSource = $.parseJSON(data);

            $('comp').val(dataSource.companyName);
        },
        error:function(){

            showAlertModal(title,'系统发生错误',false);
        }
    })
}