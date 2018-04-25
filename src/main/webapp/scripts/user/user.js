$(document).ready(function(){
    loadCompanyData();
    loadAgreementData();
    loadSalaryData();
});

function loadCompanyData(){
    $.ajax({
        url:contextPath + "/staff/companyInfo",
        method:"POST",
        success:function (data) {
            var company= $.parseJSON(data);
            $('#companyNameShow').val(company.companyName);
            $('#introductionShow').val(company.introduction);
        }
    });
}

function loadAgreementData() {
    $.ajax({
        url:contextPath + "/staff/agreeInfo",
        method:"POST",
        success:function (data) {
            var agreement= $.parseJSON(data);
            $('#agreementTitle').val(agreement.title);
            $('#agreementContent').val(agreement.content);
            $('#agreementStart').val(agreement.startTime);
            $('#agreementEnd').val(agreement.endTime);
        }
    });
}

function loadSalaryData() {
    $.ajax({
        url:contextPath + "/userCtr/salaryInfo",
        method:"POST",
        success:function (data) {
            var salaryList = $.parseJSON(data);
            $('#salaryTable').DataTable({
                data:salaryList,
                columns:[
                    { data: 'date' },
                    { data: 'salary' },
                    { data: 'tip' }
                ]
            });
        }
    });
}