<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <link rel="icon" type="image/png" href="img/logo.png">
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
                height: 2rem;
            }
            .col-sm {
                height: 40rem;
                text-align: center;
            }
            #loginBtn {
                width: 24em;
                background-color: #735020;
                border: 1px #735020 solid;
            }
            #loginBtn:hover {
                background-color: #524737;
            }
            p > a {
                margin: 0.5em;
                text-decoration: none;
                color: black;
            }
            #loginForm {
                width: 24em;
                margin-left: 10em;
                margin-right: 10em;
                text-align: left;
            }
            .genderBtn {
                background-color: #735020;
                border: 1px #735020 solid;
            }
            .genderBtn:focus {
                background-color: #524737;
            }
        </style>
    </head>
    <body>
        <div id="blank"></div>
        <div class="row">
            <div class="col-sm"></div>
            <div class="col-sm">
                <img src="img/logo.png" alt="" width="250em" height="250em">
                <div id="loginForm">
                    <form action="signinAction.jsp">
                        아이디
                        <div class="input-group mb-2">
                            <input type="text" class="form-control" name="memberId" placeholder="@email.com"><br>
                        </div>
                        비밀번호
                        <div class="input-group mb-2">
                            <input type="password" class="form-control" name="memberPwd" placeholder=""><br>
                        </div>
                        비밀번호 확인
                        <div class="input-group mb-2">
                            <input type="password" class="form-control" name="memberPwdCheck" placeholder=""><br>
                        </div>
                        이름
                        <div class="input-group mb-2">
                            <input type="text" class="form-control" name="memberName"><br>
                        </div>
                        성별
                        <div class="form-group">
                            <div class="btn-group" data-toggle="buttons">
                                <label class="btn btn-primary active genderBtn">
                                    <input
                                        type="radio"
                                        name="gender"
                                        autocomplete="off"
                                        value="남자"
                                        checked="checked">남자
                                </label>
                                <label class="btn btn-primary genderBtn">
                                    <input type="radio" name="gender" id="" autocomplete="off" value="여자">여자
                                </label>
                            </div>
                        </div>
                        <button class="btn btn-primary" id="loginBtn" type="submit">가입하기</button>
                    </form>
                </div>
                <br>
            </div>
            <div class="col-sm"></div>
        </div>
    </body>
</html>