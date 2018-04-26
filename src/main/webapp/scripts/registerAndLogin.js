$(document).ready(function() {

});

function userRegister() {
    var staff = $("#userRegisterForm").serializeObject();
    var title = "员工注册";
    $.ajax({
        url:contextPath + "/staff/register",
        data:staff,
        method:"POST",
        success:function(data) {
            $('#userRegisterModal').modal('hide');
            if(data==='0'){
                showAlertModal(title,'注册成功,请登录',true);
                $("#userLoginModal").modal("show");
            }else{
                showAlertModal(title,data,false);
            }
        },
        error : function() {
            $('#userRegisterModal').modal('hide');
            showAlertModal(title,'系统发生错误',false);
        },
        dataType: 'json'
    });
}

function companyRegister() {
    var company = $("#companyRegisterForm").serializeObject();
    var title = "公司注册";
    $.ajax({
        url:contextPath + "/company/register",
        data:company,
        method:"POST",
        success:function(data) {
            $('#companyRegisterModal').modal('hide');
            if(data==='0'){
                showAlertModal(title,'注册成功,请登录',true);
                $("#companyLoginModal").modal("show");
            }else{
                showAlertModal(title,data,false);
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
    //var staff = form.serializeObject();
    //todo 表单校验
    form.submit();
}

function companyLogin() {
    var form = $("#companyLoginForm");
    //var company = form.serializeObject();
    //todo 表单校验
    form.submit();
}

function adminLogin() {
    var form = $("#adminLoginForm");
    //var admin = form.serializeObject();
    //todo 表单校验
    form.submit();
}