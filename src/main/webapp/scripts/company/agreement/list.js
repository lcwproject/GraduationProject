$(document).ready(function() {
    alarmTable = null;
    agreeTable = null;
    loadCompanyData();
    loadAlarmData();
    initDetailModal();
});

function loadCompanyData() {
    var dataSource = null;
    $.ajax({
        url:contextPath + "/agreement/queryAgreementByCompany",
        method:"POST",
        success:function (data) {
            dataSource = $.parseJSON(data);
            if(agreeTable!==null){
                agreeTable.destroy();
            }
            agreeTable = $('#agreementTable').DataTable({
                data:dataSource,
                columns:[
                    { data: 'agreementId' },
                    { data: 'staffName' },
                    { data: 'title' },
                    { data: 'startTimeToShow' },
                    { data: 'endTimeToShow' },
                    { data:
                            function (data) {
                                return '<a href="#" data-toggle="modal" data-target="#detialModal" data-detialtitle = "'+ data.title +'" data-detialcontent = " '+ data.content +' ">查看</a>';
                            }
                    }
                ]
            });
        }
    });
}

function loadAlarmData() {
    var dataSource = null;
    $.ajax({
        url:contextPath + "/agreement/queryAlarmAgreementByCompany",
        method:"POST",
        success:function (data) {
            dataSource = $.parseJSON(data)
            if(alarmTable!==null){
                alarmTable.destroy();
            }
            alarmTable = $('#agreementAlarmTable').DataTable({
                data:dataSource,
                columns:[
                    { data: 'agreementId' },
                    { data: 'staffName' },
                    { data: 'title' },
                    { data: 'startTimeToShow' },
                    { data: 'endTimeToShow' }
                ]
            });
        }
    });
}

function initDetailModal() {
    $('#detialModal').on('show.bs.modal', function (event) {
        var trigger = $(event.relatedTarget);
        var title = trigger.data('detialtitle');
        var content = trigger.data('detialcontent');
        var modal = $(this);
        modal.find('.modal-title').text("标题:"+title);
        modal.find('.modal-body').text("内容:"+content);
    });
}




