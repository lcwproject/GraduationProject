<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="zh" manifest="cache.manifest">
<!--缓存，还有缓存更新的问题等待解决-->
<%--<html lang="zh" manifest="cache.manifest">--%>

<head>
    <%@ include file="initRequestPage.jsp"%>
    <meta charset="UTF-8">
    <!--移动设备优先 1:1缩放 用户不可缩放屏幕-->
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/resources/css/bootstrap/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/resources/css/bootstrap/bootstrap-table.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/resources/css/bootstrap/bootstrap-reboot.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/resources/css/bootstrap/bootstrap-grid.min.css" />

    <!-- Font-icon css-->
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
</head>
<body class="app sidebar-mini rtl">

    <!-- alertModal -->
    <div class="modal fade" id="alertModal" tabindex="-1" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 id="alertModal_title" class="modal-title">操作</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div id="alertModal_info" role="alert">信息</div>
                </div>
            </div>
        </div>
    </div>

    <script src="<%=contextPath%>/resources/js/jQuery/jquery-3.2.1.min.js"></script>
    <!-- 可移动效果 -->
    <script src="<%=contextPath%>/resources/js/plugins/popper.min.js"></script>
    <script src="<%=contextPath%>/resources/js/bootstrap/bootstrap.min.js"></script>
    <script src="<%=contextPath%>/resources/js/plugins/bootstrap-table.min.js"></script>
    <script src="<%=contextPath%>/resources/js/plugins/bootstrap-table-locale-all.min.js"></script>
    <script src="<%=contextPath%>/resources/js/main/main.js"></script>
    <!-- 顶部进度条 -->
    <script src="<%=contextPath%>/resources/js/plugins/pace.min.js"></script>
    <!-- 表格 -->
    <script type="text/javascript" src="<%=contextPath%>/resources/js/plugins/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="<%=contextPath%>/resources/js/plugins/dataTables.bootstrap.min.js"></script>

    <script type="text/javascript" src="<%=contextPath%>/resources/js/plugins/jquery.json.min.js"></script>

    <script>
        $.extend( $.fn.dataTable.defaults, {
            searching:false,
            ordering:false,
            serveSide:false,
            lengthChange:false,
            paging:true,
            info:true,
            language: {
                lengthMenu:     "每页 _MENU_ 行",
                info:           "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条数据",
                loadingRecords: "加载中",
                zeroRecords:    "暂时无数据",
                emptyTable:     "暂时无数据",
                paginate: {
                    first:      "首页",
                    previous:   "上一页",
                    next:       "下一页",
                    last:       "尾页"
                }
            }
        } );
    </script>
</body>

</html>
