<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/views/common/header.jsp" %>

<% 
	/* 세션값(로그인)없이 마이페이지에 접근시 */
	if(m==null){
	String msg ="잘못된 접근입니다.";
	String loc ="/";
	request.setAttribute("msg", msg);
	request.setAttribute("loc", loc);
	request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
} %>
<style>
			body {
                background-color: rgb(250, 250, 250);
            }
            .wrapper {
            	width:100%;
            	background-color:white;
            	text-align: center;
            }
            #loginBtn {
                width: 100%;
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
                text-align: center;
                position:relative;
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
<section>
    <div class="wrapper">
        <div class="row">
            <div class="col-sm-4"></div>
                <div id="loginForm" class="col-sm-4">
                    <img src="<%= request.getContextPath() %>/img/logo.png" alt="" width="250em" height="250em">
                    <form action="<%= request.getContextPath() %>/updateMember" method="post">
                        <b>아이디</b>
                        <div class="input-group mb-2">
                            <input type="text" class="form-control" name="userId" placeholder="@email.com" readonly value="<%= m!=null?m.getUserId():"" %>" required><br>
                        </div>
                        <b>비밀번호</b>
                        <div class="input-group mb-2">
                            <input type="password" class="form-control" name="password" placeholder="" value="<%= m!=null?m.getPassword():"" %>" required><br>
                        </div>
                        <b>비밀번호 확인</b>
                        <div class="input-group mb-2">
                            <input type="password" class="form-control" name="password" placeholder="" value="<%= m!=null?m.getPassword():"" %>"><br>
                        </div><br>
                        <b>휴대전화</b>
                        <div class="form-group">
                            <input type="text" class="form-control" name="phone" maxlength="11" value="<%= m!=null?m.getPhone():"" %>" placeholder="01012345678">
                        </div>
                        <button class="btn btn-primary" id="loginBtn" type="submit">회원정보수정</button>
                    </form>
                    <br>
                </div>
            <div class="col-sm-4"></div>
        </div>
    </div>
</section>

<%@ include file="/views/common/footer.jsp"%>