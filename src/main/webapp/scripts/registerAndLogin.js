$(document).ready(function() {

});

function userRegister() {

}

function companyRegister() {
    var company = $("#companyRegisterForm").serializeObject();
    var title = "公司注册";
    $.ajax({
        url:contextPath + "/company/register",
        data:company,
        method:"POST",
        success:function(data) {
            debugger;
            $('#companyRegisterModal').modal('hide');
            if(data.status==='-1'){
                showAlertModal(title,'产生错误',false);
            }else{
                showAlertModal(title,'注册成功,请登录',true);
                $("#companyLoginModal").modal("show");
            }
        },
        error : function() {
            $('#companyRegisterModal').modal('hide');
            showAlertModal(title,'系统发生错误',false);
        },
        dataType: 'json'
    });
}

function userLogin() {
    var form = $("#userLoginForm");
    var company = form.serializeObject();
    //todo 表单校验
    form.submit();
}

function companyLogin() {
    var form = $("#companyLoginForm");
    var company = form.serializeObject();
    //todo 表单校验
    form.submit();
}

function adminLogin() {

}