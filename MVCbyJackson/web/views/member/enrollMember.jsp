<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <link rel="icon" type="image/png" href="<%= request.getContextPath() %>img/logo.png">
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
                height: 1rem;
            }
            .col-sm {
                height: 40rem;
                text-align: center;
            }
            #loginBtn {
                width: 24em;
                height: 3em;
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
            .form-row {
                margin-bottom: 1em;
            }
        </style>
    </head>
    <body>
        <div id="blank"></div>
        <div class="row">
            <div class="col-sm"></div>
            <div class="col-sm">
                <img src="<%= request.getContextPath() %>/img/logo.png" alt="" width="250em" height="250em">
                <div id="loginForm">
                    <form action="<%= request.getContextPath() %>/enrollMember" method="post">
                        <b>아이디</b>
                        <div class="input-group mb-2">
                            <input type="text" class="form-control" name="userId" placeholder="@email.com" required><br>
                        </div>
                        <b>비밀번호</b>
                        <div class="input-group mb-2">
                            <input type="password" class="form-control" name="password" placeholder="" required><br>
                        </div>
                        <b>비밀번호 확인</b>
                        <div class="input-group mb-2">
                            <input type="password" class="form-control" name="password" placeholder=""><br>
                        </div><br>
                        <!-- 추후 keyup을 활용해서 비밀번호를 확인할 예정 -->
                        <b>이름</b>
                        <div class="input-group mb-2">
                            <input type="text" class="form-control" name="userName" required>
                        </div>
                        <b>생년월일</b>
                        <div class="form-row">
                            <div class="input-group col-md-4" >
                                <input type="text" class="form-control" name="birthYear" maxlength="4" placeholder="년(4자)" required>
                            </div>
                            <div class="input-group col-md-4">
                                <select name="birthMonth" id = "inputState" class = "form-control"> 
                                    <option selected="selected">월</option>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5</option>
                                    <option value="6">6</option>
                                    <option value="7">7</option>
                                    <option value="8">8</option>
                                    <option value="9">9</option>
                                    <option value="10">10</option>
                                    <option value="11">11</option>
                                    <option value="12">12</option>
                                </select>
                            </div>
                            <div class="input-group col-md-4" >
                                <input type="text" class="form-control" name="birthDate" maxlength="2" placeholder="일" required>
                            </div>
                        </div>
                    <b>성별</b>
                    <div class="form-group">
                        <select name="gender" id = "inputState" class = "form-control"> 
                            <option selected="selected">성별</option>
                            <option value="M">남자</option>
                            <option value="F">여자</option>
                        </select>
                    </div>
                    <b>휴대전화</b>
                    <div class="form-group">
                        <input type="text" class="form-control" name="phone" maxlength="11" placeholder="01012345678">
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
