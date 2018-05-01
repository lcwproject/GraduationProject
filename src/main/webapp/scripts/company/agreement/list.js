$(document).ready(function() {
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
            $('#agreementTable').DataTable({
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
            dataSource = $.parseJSON(data);
            $('#agreementAlarmTable').DataTable({
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
        modal.find('.modal-title').text(title);
        modal.find('.modal-body').text(content);
    });
}




