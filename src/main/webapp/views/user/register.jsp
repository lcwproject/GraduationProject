<%--
  Created by IntelliJ IDEA.
  User: hahaha
  Date: 2018/4/23
  Time: 1:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册登录</title>
    <%@ include file="../initResoucePage.jsp"%>
    <link rel="stylesheet" type="text/css"  href="<%=contextPath%>/resources/css/user/mainrl.css" />
</head>
<body class="loading">
<div id="wrapper">
    <div id="bg"></div>
    <div id="overlay"></div>
    <div id="main">

        <!-- Header -->
        <header id="header">
            <h1>Welcome</h1>
            <nav>
                <ul>
                    <li>
                        <a href="#" class="icon fa-edit" data-toggle="modal" data-target="#exampleModal"></a>
                    </li>
                    <li>
                        <a href="#" class="icon fa-bullseye" data-toggle="modal" data-target="#exampleModall"></a>
                    </li>
                </ul>
                <ul>
                    <li><a href="#" data-toggle="modal" data-target="#exampleModal">注册</a></li>
                    <li><a href="#" data-toggle="modal" data-target="#exampleModall">登录</a></li>
                </ul>
            </nav>
        </header>
    </div>

</div>
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">注册</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="rname" class="col-form-label">用户名:</label>
                        <input type="text" class="form-control" id="rname">
                    </div>
                    <div class="form-group">
                        <label for="rpassword" class="col-form-label">密码:</label>
                        <input type="password" class="form-control" id="rpassword">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary">注册</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="exampleModall" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabell">登录</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="lname" class="col-form-label">用户名:</label>
                        <input type="text" class="form-control" id="lname">
                    </div>
                    <div class="form-group">
                        <label for="lpassword" class="col-form-label">密码:</label>
                        <input type="password" class="form-control" id="lpassword">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary">登录</button>
            </div>
        </div>
    </div>
</div>
<!--[if lte IE 8]><script src="<%=contextPath%>/resources/js/user/ie/respond.min.js"></script><![endif]-->
<script>
    window.onload = function() {
        document.body.className = '';
    }
    window.ontouchmove = function() {
        return false;
    }
    window.onorientationchange = function() {
        document.body.scrollTop = 0;
    }
</script>

</body>
</html>
