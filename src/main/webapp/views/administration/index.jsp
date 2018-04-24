<%--
  Created by IntelliJ IDEA.
  User: hahaha
  Date: 2018/4/23
  Time: 1:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <%@ include file="../initResoucePage.jsp"%>
    <link rel="stylesheet" type="text/css" href="<%=contextPath%>/resources/css/administration/main.css" />
</head>
<body>
<!-- Wrapper -->
<div id="wrapper">

    <!-- Main -->
    <div id="main">
        <div class="inner">

            <!-- Header -->
            <header id="header">
                <a href="index.jsp" class="logo">
                    <h2>学生生产实习管理系统</h2>
                </a>
                <ul class="icons">
                    <li><a href="#" class="icon fa-snapchat-ghost">退出</a></li>
                </ul>
            </header>

            <!-- Banner -->
            <section id="banner">
                <div class="content">
                    <header>
                        <h1>Welcome</h1>
                        <p>Today is a good day</p>
                    </header>
                    <ul class="actions">
                        <li><a href="#" class="button big">Learn More</a></li>
                    </ul>
                </div>
                <span class="image object">
										<img src="/images/pic10.jpg" alt="" />
									</span>
            </section>

            <%--<!-- Section -->--%>
            <%--<section id="company">--%>
                <%--<header class="major">--%>
                    <%--<h2>公司信息</h2>--%>
                <%--</header>--%>
                <%--<div class="features">--%>
                    <%--<article>--%>
                        <%--<span class="icon fa-diamond"></span>--%>
                        <%--<div class="content">--%>
                            <%--<h3>Portitor ullamcorper</h3>--%>
                            <%--<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>--%>
                        <%--</div>--%>
                    <%--</article>--%>

                <%--</div>--%>
            <%--</section>--%>

            <%--<!-- Section -->--%>
            <%--<section id="deal">--%>
                <%--<header class="major">--%>
                    <%--<h2>协议信息</h2>--%>
                <%--</header>--%>
                <%--<div class="features">--%>
                    <%--<article>--%>
                        <%--<span class="icon fa-diamond"></span>--%>
                        <%--<div class="content">--%>
                            <%--<h3>Portitor ullamcorper</h3>--%>
                            <%--<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>--%>
                        <%--</div>--%>
                    <%--</article>--%>

                <%--</div>--%>
            <%--</section>--%>

            <%--<!-- Section -->--%>
            <%--<section id="person">--%>
                <%--<header class="major">--%>
                    <%--<h2>人员信息</h2>--%>
                <%--</header>--%>
                <%--<div class="features">--%>
                    <%--<article>--%>
                        <%--<span class="icon fa-diamond"></span>--%>
                        <%--<div class="content">--%>
                            <%--<h3>Portitor ullamcorper</h3>--%>
                            <%--<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>--%>
                        <%--</div>--%>
                    <%--</article>--%>

                <%--</div>--%>
            <%--</section>--%>

            <%--<!-- Section -->--%>
            <%--<section id="view">--%>
                <%--<header class="major">--%>
                    <%--<h2>查看</h2>--%>
                <%--</header>--%>
                <%--<div class="features">--%>
                    <%--<article>--%>
                        <%--<span class="icon fa-diamond"></span>--%>
                        <%--<div class="content">--%>
                            <%--<h3>Portitor ullamcorper</h3>--%>
                            <%--<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>--%>
                        <%--</div>--%>
                    <%--</article>--%>

                <%--</div>--%>
            <%--</section>--%>

            <%--<section id="import">--%>
                <%--<header class="major">--%>
                    <%--<h2>导入</h2>--%>
                <%--</header>--%>
                <%--<div class="features">--%>
                    <%--<article>--%>
                        <%--<span class="icon fa-diamond"></span>--%>
                        <%--<div class="content">--%>
                            <%--<h3>Portitor ullamcorper</h3>--%>
                            <%--<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>--%>
                        <%--</div>--%>
                    <%--</article>--%>

                <%--</div>--%>
            <%--</section>--%>


        </div>
    </div>

    <!-- Sidebar -->
    <div id="sidebar">
        <div class="inner">

            <!-- Search -->
            <section id="search" class="alt">
                <form method="post" action="#">
                    <input type="text" name="query" id="query" placeholder="Search" />
                </form>
            </section>

            <!-- Menu -->
            <nav id="menu">
                <header class="major">
                    <h2>菜单</h2>
                </header>
                <ul>
                    <li><a href="<%=contextPath%>/views/administration/index.jsp">主页</a></li>
                    <li><a href="<%=contextPath%>/views/company/list.jsp">单位信息</a></li>
                    <li><a href="<%=contextPath%>/views/agreement/list.jsp">协议信息</a></li>
                    <li><a href="<%=contextPath%>/views/staff/list.jsp">人员信息</a></li>
                    <li>
                        <span class="opener">工资信息</span>
                        <ul>
                            <li><a href="../salary/list.jsp">查看</a></li>
                            <%--<li><a href="#import">导入</a></li>--%>

                        </ul>
                    </li>

                </ul>

                <%--<ul>--%>
                    <%--<li><a href="#home">主页</a></li>--%>
                    <%--<li><a href="#company">单位信息</a></li>--%>
                    <%--<li><a href="#deal">协议信息</a></li>--%>
                    <%--<li><a href="#person">人员信息</a></li>--%>
                    <%--<li>--%>
                        <%--<span class="opener">工资信息</span>--%>
                        <%--<ul>--%>
                            <%--<li><a href="#view">查看</a></li>--%>
                            <%--<li><a href="#import">导入</a></li>--%>

                        <%--</ul>--%>
                    <%--</li>--%>

                <%--</ul>--%>
            </nav>
            <!-- Footer -->
            <footer id="footer">
                <p class="copyright">&copy; 2018. All rights reserved.</p>
            </footer>

        </div>
    </div>

</div>

<!-- Scripts -->
<script src="<%=contextPath%>/resources/js/administration/jquery.min.js"></script>
<script src="<%=contextPath%>/resources/js/administration/skel.min.js"></script>
<script src="<%=contextPath%>/resources/js/administration/util.js"></script>
<!--[if lte IE 8]><script src="<%=contextPath%>/resources/js/administration/ie/respond.min.js"></script><![endif]-->
<script src="<%=contextPath%>/resources/js/administration/main.js"></script>

</body>
</html>
