<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.onebyn.member.model.vo.Member" %>
<% 
	Member m = (Member)session.getAttribute("member");
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Main</title>
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
            #logo{
                padding: 10px;
            }
            #mypageSection{
                text-align: right;
                padding-top: 2em;
            }
            div#mypageSection>ul>li{
                display: inline;
                margin-left: 1em;
            }
            li>a{
                text-decoration: none;
                color: black;
            }
            input[type="search"]{
                margin-left: 1em;
            }
            #searchBtn{
                color: brown;
                border: 1px brown solid;
            }
            #searchBtn:hover{
                background-color: bisque;
            }
            li.nav-item{
                margin-left: 3em;
                margin-right: 7.5em;
            }
            .board {
                height: 35em;
            }
            .board>h3 {
                text-align: center;
            }
            footer {
                height: 15em;
                background-color: gray;
                text-align:center;
            }
        </style>
    </head>
    <body>
        <div id="wrapper">
            <header>
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-sm" id="logo">
                            <form class="form-inline">
                                <a href="">
                                <img src="<%= request.getContextPath() %>/img/logoTitle.png" width="200" height="66">
                            </a>
                            <input class="form-control mr-sm-2" type="search" placeholder="물건 색" aria-label="Search">
                            <button id="searchBtn" class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
                          </form>
                        </div>

                        <div class="col-sm" id="mypageSection">
                            <ul>
                            <% if(m==null) { %>
                            <li><a href="<%= request.getContextPath() %>/views/member/login.jsp">로그인</a></li>
                            <li><a href="<%= request.getContextPath() %>/views/member/enrollMember.jsp">회원가입</a></li>
                            <li><a href="">고객센터</a></li>
                            <li><a href="<%= request.getContextPath() %>/views/member/login.jsp">마이페이지</a></li>
                            <% } else{ %>
                            <li><b><%= m.getUserName() %></b>님 반갑습니다!</li>
                            <li><a href="<%= request.getContextPath() %>/logoutMember">로그아웃</a></li>
                            <li><a href="">고객센터</a></li>
                            <li><a href="<%= request.getContextPath() %>/views/member/myPage.jsp">마이페이지</a></li>
                            <% } %>
                        </ul>
                        </div>
                    </div>
                </div>
            </header>