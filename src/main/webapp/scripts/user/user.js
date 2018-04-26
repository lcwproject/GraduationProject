$(document).ready(function(){
    loadCompanyData();
    loadAgreementData();
    loadSalaryData();
});

function loadCompanyData(){
    $.ajax({
        url:contextPath + "/company/queryCompanyByStaff",
        method:"POST",
        success:function (data) {
            debugger;
            var company= $.parseJSON(data);
            $('#companyNameShow').html(company.companyName);
            $('#introductionShow').html(company.introduction);
        }
    });
}

function loadAgreementData() {
    $.ajax({
        url:contextPath + "/agreement/queryAgreementByStaff",
        method:"POST",
        success:function (data) {
            var agreement= $.parseJSON(data);
            $('#agreementTitle').html(agreement.title);
            $('#agreementContent').html(agreement.content);
            $('#agreementStart').html(agreement.startTime);
            $('#agreementEnd').html(agreement.endTime);
        }
    });
}

function loadSalaryData() {
    $.ajax({
        url:contextPath + "/salary/querySalaryByStaff",
        method:"POST",
        success:function (data) {
            debugger;
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