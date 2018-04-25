$(document).ready(function() {
    "use strict";
    var treeviewMenu = $('.app-menu');
    // Toggle Sidebar
    $('[data-toggle="sidebar"]').click(function(event) {
        event.preventDefault();
        $('.app').toggleClass('sidenav-toggled');
    });
    // Activate sidebar treeview toggle
    $("[data-toggle='treeview']").click(function(event) {
        event.preventDefault();
        if(!$(this).parent().hasClass('is-expanded')) {
            treeviewMenu.find("[data-toggle='treeview']").parent().removeClass('is-expanded');
        }
        $(this).parent().toggleClass('is-expanded');
    });
    // Set initial active toggle
    $("[data-toggle='treeview.'].is-expanded").parent().toggleClass('is-expanded');
    //Activate bootstrip tooltips
    $("[data-toggle='tooltip']").tooltip();
    loadUrl("/home/homePage")
});
// (function() {
//     "use strict";
//
//     var treeviewMenu = $('.app-menu');
//
//     // Toggle Sidebar
//     $('[data-toggle="sidebar"]').click(function(event) {
//         event.preventDefault();
//         $('.app').toggleClass('sidenav-toggled');
//     });
//
//     // Activate sidebar treeview toggle
//     $("[data-toggle='treeview']").click(function(event) {
//         event.preventDefault();
//         if (!$(this).parent().hasClass('is-expanded')) {
//             treeviewMenu.find("[data-toggle='treeview']").parent().removeClass('is-expanded');
//         }
//         $(this).parent().toggleClass('is-expanded');
//     });
//
//     // Set initial active toggle
//     $("[data-toggle='treeview.'].is-expanded").parent().toggleClass('is-expanded');
//
//     //Activate bootstrip tooltips
//     $("[data-toggle='tooltip']").tooltip();
//
// })();
function loadUrl(url) {
    $("#main_content").load(contextPath + url);
}

function showAlertModal(title,info,isSuccess) {
    var customAlert =  $('#alertModal');
    customAlert.find("#alertModal_title").text(title);
    var realAlert = customAlert.find("#alertModal_info");
    realAlert.text(info);
    if(isSuccess){
        realAlert.attr("class","alert alert-success");
    }else{
        realAlert.attr("class","alert alert-danger");
    }
    customAlert.modal('show');
}
