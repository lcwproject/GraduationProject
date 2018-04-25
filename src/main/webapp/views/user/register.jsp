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
                        <a href="#" class="icon fa-edit" data-toggle="modal" data-target="#userRegisterModal"></a>
                    </li>
                    <li>
                        <a href="#" class="icon fa-snowflake-o" data-toggle="modal" data-target="#userLoginModal"></a>
                    </li>
                    <li>
                        <a href="#" class="icon fa-edit" data-toggle="modal" data-target="#companyRegisterModal"></a>
                    </li>
                    <li>
                        <a href="#" class="icon fa-bullseye" data-toggle="modal" data-target="#companyLoginModal"></a>
                    </li>
                    <li>

                        <a href="#" class="icon fa-user-o" data-toggle="modal" data-target="#adminLoginModal"></a>
                       </li>
                </ul>
                <ul>
                    <li><a href="#" data-toggle="modal" data-target="#userRegisterModal">用户注册</a></li>
                    <li><a href="#" data-toggle="modal" data-target="#userLoginModal">用户登录</a></li>
                    <li><a href="#" data-toggle="modal" data-target="#companyRegisterModal">单位注册</a></li>
                    <li><a href="#" data-toggle="modal" data-target="#companyLoginModal">单位登录</a></li>
                    <li><a href="#" data-toggle="modal" data-target="#adminLoginModal">管理员</a></li>
                </ul>
            </nav>
        </header>
    </div>

</div>

<%--用户注册--%>
<div class="modal fade" id="userRegisterModal" tabindex="-1" role="dialog" aria-labelledby="userRegisterModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="userRegisterModalLabel">注册</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="urname" class="col-form-label">用户名:</label>
                        <input type="text" class="form-control" id="urname">
                    </div>
                    <div class="form-group">
                        <label for="urpassword" class="col-form-label">密码:</label>
                        <input type="password" class="form-control" id="urpassword">
                    </div>
                    <div class="form-group">
                        <label for="uaddress" class="col-form-label">地址:</label>
                        <input type="text" class="form-control" id="uaddress">
                    </div>
                    <div class="form-group">
                        <label for="uphone" class="col-form-label">电话:</label>
                        <input type="text" class="form-control" id="uphone">
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
<%--用户登录--%>
<div class="modal fade" id="userLoginModal" tabindex="-1" role="dialog" aria-labelledby="userLoginModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="userLoginModalLabel">登录</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="ulname" class="col-form-label">用户名:</label>
                        <input type="text" class="form-control" id="ulname">
                    </div>
                    <div class="form-group">
                        <label for="ulpassword" class="col-form-label">密码:</label>
                        <input type="password" class="form-control" id="ulpassword">
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

<%--单位注册--%>
<div class="modal fade" id="companyRegisterModal" tabindex="-1" role="dialog" aria-labelledby="companyRegisterModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="companyRegisterModalLabel">注册</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="crname" class="col-form-label">用户名:</label>
                        <input type="text" class="form-control" id="crname">
                    </div>
                    <div class="form-group">
                        <label for="crpassword" class="col-form-label">密码:</label>
                        <input type="password" class="form-control" id="crpassword">
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
<%--单位登录--%>
<div class="modal fade" id="companyLoginModal" tabindex="-1" role="dialog" aria-labelledby="companyLoginModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="companyLoginModalLabel">登录</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="clname" class="col-form-label">用户名:</label>
                        <input type="text" class="form-control" id="clname">
                    </div>
                    <div class="form-group">
                        <label for="clpassword" class="col-form-label">密码:</label>
                        <input type="password" class="form-control" id="clpassword">
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

<%--管理员登录--%>
<div class="modal fade" id="adminLoginModal" tabindex="-1" role="dialog" aria-labelledby="adminLoginModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="adminLoginModalLabel">登录</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="alname" class="col-form-label">用户名:</label>
                        <input type="text" class="form-control" id="alname">
                    </div>
                    <div class="form-group">
                        <label for="alpassword" class="col-form-label">密码:</label>
                        <input type="password" class="form-control" id="alpassword">
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