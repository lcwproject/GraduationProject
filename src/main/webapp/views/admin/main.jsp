<%@ page import="com.graduate.laborManager.pub.bean.Admin" %><%--
  Created by IntelliJ IDEA.
  User: Dustin
  Date: 2018/4/21
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员首页</title>
    <%@ include file="../initResoucePage.jsp"%>
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/resources/css/main/main.css">

    <%
        Admin admin = (Admin) session.getAttribute("admin");
        if(admin==null){
            RequestDispatcher  rd = request.getRequestDispatcher("/views/registerAndLogin.jsp");
            rd.forward(request,response);
        }
    %>

</head>
<body class="app sidebar-mini rtl">
    <!-- Navbar-->
    <header class="app-header">
        <!-- Sidebar toggle button-->
        <%--<a class="app-sidebar__toggle" href="#" data-toggle="sidebar" aria-label="Hide Sidebar"></a>--%>
        <!-- Navbar Right Menu-->
        <ul class="app-nav">
            <!-- User Menu-->
            <li class="dropdown"><a class="app-nav__item" href="#" data-toggle="dropdown" aria-label="Open Profile Menu"><i class="fa fa-user fa-lg"></i></a>
                <ul class="dropdown-menu settings-menu dropdown-menu-right">
                    <li><a class="dropdown-item" href="<%=contextPath%>/allUser/logOut"><i class="fa fa-sign-out fa-lg"></i> Logout</a></li>
                </ul>
            </li>
        </ul>
    </header>
    <!-- Sidebar menu-->
    <div class="app-sidebar__overlay" data-toggle="sidebar"></div>
    <aside class="app-sidebar">
        <div class="app-sidebar__user"><img class="app-sidebar__user-avatar" src="https://s3.amazonaws.com/uifaces/faces/twitter/jsa/48.jpg" alt="User Image">
            <div>
                <p class="app-sidebar__user-name">管理员</p>
                <p class="app-sidebar__user-designation">${sessionScope.admin.name}</p>
            </div>
        </div>
        <ul class="app-menu">
            <li><a class="app-menu__item" href="#" onclick="loadUrl('/company/listAdmin')">
                <i class="app-menu__icon fa fa-laptop"></i><span class="app-menu__label">单位信息</span>
            </a></li>
            <li><a class="app-menu__item" href="#" onclick="loadUrl('/staff/listAdmin')">
                <i class="app-menu__icon fa fa-pie-chart"></i><span class="app-menu__label">人员信息</span>
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

    </main>

</body>
</html>

