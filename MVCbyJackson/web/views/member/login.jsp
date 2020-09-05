<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="icon" type="image/png" href="<%=request.getContextPath()%>/img/logo.png">
        <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
            integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
            crossorigin="anonymous">
        <script src="jquery-3.5.1.min.js"></script>
        <script
            src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
        <script
            src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
            integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
            crossorigin="anonymous"></script>
        <script
            src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
            integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
            crossorigin="anonymous"></script>
        <style>
            body {
                background-color: rgb(250, 250, 250);
            }
            #blank {
                width: 100%;
                height:5rem;
            }
            .col-sm {
                height: 40rem;
                text-align: center;
            }   
            #loginBtn {
                width:19em;
                background-color: #735020;
                border: 1px #735020 solid;
            }
            #loginBtn:hover {
                background-color: #524737;
            }
            p>a {
                margin: 0.5em;
                text-decoration: none;
                color: black;
            }
            #loginForm {
                width: 19em;
                margin-left: 10em;
                margin-right: 10em;
            }
        </style>
</head>
<body>
    <div id="blank"></div>
    <div class="row">
        <div class="col-sm"></div>
        <div class="col-sm">
            <a href="<%= request.getContextPath()%>">
            <img src="<%=request.getContextPath()%>/img/logo.png" alt="" width="300em" height="300em">
            </a>
            <div id="loginForm">
            <form action="<%=request.getContextPath()%>/loginMember" method="post">
                <div class="input-group mb-2">
                <input type="text" class="form-control" name="userId" placeholder="ID"><br>
            </div>
            <div class="input-group mb-2">
                <input type="password" class="form-control" name="password" placeholder="Password"><br>
            </div>
            <button class="btn btn-primary" id="loginBtn" type="submit">로그인</button>
            </form>
            </div>
            <br>
            <p>
                <a href="">아이디찾기</a>
                <a href="">비밀번호찾기</a>
                <a href="<%= request.getContextPath() %>/views/member/enrollMember.jsp">회원가입</a>
            </p>
        </div>
        <div class="col-sm"></div>
    </div>
</body>
</html>