<%@ page import="com.graduate.laborManager.pub.bean.Staff" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户首页</title>
    <%@ include file="../initResoucePage.jsp"%>
    <link rel="stylesheet" type="text/css"  href="<%=contextPath%>/resources/css/user/main.css" />
</head>
<body>
<!-- Header -->
<header id="header">
    <h1>昆明理工大学</h1>
    <nav>
        <ul>
            <li><a href="#home">首页</a></li>
            <li><a href="#company">单位</a></li>
            <li><a href="#deal">协议</a></li>
            <li><a href="#salary">工资</a></li>
            <li><a href="<%=contextPath%>/allUser/logOut">退出</a></li>
        </ul>
    </nav>

    <%
        Staff currentStaff = (Staff) session.getAttribute("currentStaff");
        if(currentStaff==null){
            RequestDispatcher  rd = request.getRequestDispatcher("/views/registerAndLogin.jsp");
            rd.forward(request,response);
        }
    %>

</header>

<!-- home -->
<section id="home" class="main style1 dark fullscreen">
    <div class="content">
        <header>
            <h2>Hey.</h2>
        </header>
        <p>欢迎访问学生生产实习系统</p>
        <a href="#company" class="button style2 down">More</a>

    </div>
</section>

<!-- company -->
<section id="company" class="main style2 right dark fullscreen">
    <div class="content box style1">
        <header>
            <h4 id="companyNameShow">您还未加入任何公司</h4>
        </header>
        <p id="introductionShow">您还未加入任何公司</p>
    </div>
    <a href="#deal" class="button style2 down anchored">Next</a>
</section>

<!-- deal -->
<section id="deal" class="main style2 left dark fullscreen">
    <div class="content box style2">
        <header>
            <h4 id="agreementTitle">暂无协议</h4>
        </header>

        <label id="agreementContent">暂无协议</label>
    </div>
    <a href="#salary" class="button style2 down anchored">Next</a>
</section>

<!-- salary -->
<section id="salary" class="main style1 dark fullscreen">
    <div class="content box style2">
        <header>
            <h4>工资</h4>
        </header>
        <div class="row">
            <div class="col-md-12">
            <table id="salaryTable" class="table table-hover">
                <thead>
                <tr>
                    <th>日期</th>
                    <th>金额</th>
                    <th>备注</th>
                </tr>
                </thead>
            </table>
            </div>
        </div>
    </div>
</section>

<!-- Footer -->
<footer id="footer">

    <!-- Icons -->
    <ul class="actions">
        <li><a href="#">昆明理工大学</a></li>
    </ul>

    <!-- Menu -->
    <ul class="menu">
        <li>&copy; 2018</li>
        <li>Design</li>
    </ul>

</footer>

<!-- Scripts -->
<script src="<%=contextPath%>/resources/js/user/jquery.poptrox.min.js"></script>
<script src="<%=contextPath%>/resources/js/user/jquery.scrolly.min.js"></script>
<script src="<%=contextPath%>/resources/js/user/jquery.scrollex.min.js"></script>
<script src="<%=contextPath%>/resources/js/user/skel.min.js"></script>
<script src="<%=contextPath%>/resources/js/user/util.js"></script>
<!--[if lte IE 8]>-->
<script src="<%=contextPath%>/resources/js/user/ie/respond.min.js"></script>
<!--[endif]-->
<script src="<%=contextPath%>/resources/js/user/main.js"></script>

<script src="<%=contextPath%>/scripts/user/user.js"></script>
</body>
</html>
