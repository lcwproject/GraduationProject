<%--
  Created by IntelliJ IDEA.
  User: Dustin
  Date: 2018/4/21
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <%@ include file="../initResoucePage.jsp"%>
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/resources/css/main/main.css">
</head>
<body class="app sidebar-mini rtl">
    <!-- Navbar-->
    <header class="app-header">
        <a class="app-header__logo" href="#">Demo</a>
        <ul class="app-nav">
            <!-- User Menu-->
            <li class="dropdown"><a class="app-nav__item" href="#" data-toggle="dropdown" aria-label="Open Profile Menu"><i class="fa fa-user fa-lg"></i></a>
                <ul class="dropdown-menu settings-menu dropdown-menu-right">
                    <li><a class="dropdown-item" href="#"><i class="fa fa-cog fa-lg"></i> Settings</a></li>
                    <li><a class="dropdown-item" href="#"><i class="fa fa-user fa-lg"></i> Profile</a></li>
                    <li><a class="dropdown-item" href="#"><i class="fa fa-sign-out fa-lg"></i> Logout</a></li>
                </ul>
            </li>
        </ul>
    </header>
    <!-- Sidebar menu-->
    <div class="app-sidebar__overlay" data-toggle="sidebar"></div>
    <aside class="app-sidebar">
        <div class="app-sidebar__user"><img class="app-sidebar__user-avatar" src="https://s3.amazonaws.com/uifaces/faces/twitter/jsa/48.jpg" alt="User Image">
            <div>
                <p class="app-sidebar__user-name">DustinChen</p>
                <p class="app-sidebar__user-designation">Full Stack Developer</p>
            </div>
        </div>
        <ul class="app-menu">
            <li><a class="app-menu__item" href="#" onclick="loadUrl('/agreement/listCompany')">
                <i class="app-menu__icon fa fa-laptop"></i><span class="app-menu__label">协议信息</span>
            </a></li>
            <li><a class="app-menu__item" href="#" onclick="loadUrl('/staff/listCompany')">
                <i class="app-menu__icon fa fa-pie-chart"></i><span class="app-menu__label">人员信息</span>
            </a></li>
            <li><a class="app-menu__item" href="#" onclick="loadUrl('/salary/listCompany')">
                <i class="app-menu__icon fa fa-edit"></i><span class="app-menu__label">工资信息</span>
            </a></li>
        </ul>
    </aside>
    <main class="app-content">
        <div class="app-title">
            <div>
                <h1><i class="fa fa-dashboard"></i>学生生产实习管理系统</h1>
            </div>
        </div>
        <div id = "main_content"></div>

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

    </main>

</body>
</html>

