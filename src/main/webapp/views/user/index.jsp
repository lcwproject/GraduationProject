<%--
  Created by IntelliJ IDEA.
  User: hahaha
  Date: 2018/4/23
  Time: 1:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
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
            <li><a href="register.jsp">退出</a></li>
        </ul>
    </nav>
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
<section id="company" class="main style2  dark fullscreen">
    <div class="content box style1">
        <header>
            <h4 id="comp">公司名称</h4>
        </header>
        <p id="intro" >介绍</p>

            <a href="#deal" class="button style2 down anchored">Next</a>
    </div>
</section>

<!-- deal -->
<section id="deal" class="main style2 left dark fullscreen">
    <div class="content box style2">
        <header>
            <h4 >协议</h4>
        </header>
        <label>协议1</label>
        <label>协议2</label>
        <label>协议3</label>
        <label>协议4</label>
    </div>
    <a href="#salary" class="button style2 down anchored">Next</a>
</section>

<!-- person -->
<section id="salary" class="main style2 left dark fullscreen">
    <div class="content box style2">
        <header>
            <h4>工资</h4>
        </header>

            <table>
                <thead>
                <tr>
                    <th>
                        日期
                    </th>
                    <th>
                        金额
                    </th>
                    <th>
                        提示
                    </th>

                </tr>

                </thead>

                <tbody>
                <tr>
                    <th>1</th>
                    <th>2</th>
                    <th>3</th>
                </tr>
                <tr>
                    <th>1</th>
                    <th>2</th>
                    <th>3</th>
                </tr>
                <tr>
                    <th>1</th>
                    <th>2</th>
                    <th>3</th>
                </tr>
                </tbody>
            </table>
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
<script src="<%=contextPath%>/resources/js/user/jquery.min.js"></script>
<script src="<%=contextPath%>/resources/js/user/jquery.poptrox.min.js"></script>
<script src="<%=contextPath%>/resources/js/user/jquery.scrolly.min.js"></script>
<script src="<%=contextPath%>/resources/js/user/jquery.scrollex.min.js"></script>
<script src="<%=contextPath%>/resources/js/user/skel.min.js"></script>
<script src="<%=contextPath%>/resources/js/user/util.js"></script>
<!--[if lte IE 8]><script src="<%=contextPath%>/resources/js/user/ie/respond.min.js"></script><![endif]-->
<script src="<%=contextPath%>/resources/js/user/main.js"></script>

<script src="<%=contextPath%>/scripts/user/user.js"></script>
</body>
</html>
