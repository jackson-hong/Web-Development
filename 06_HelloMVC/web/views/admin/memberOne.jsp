<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>

<%
	Member searchedMember = (Member)request.getAttribute("searchedMember");
	String[] hobbys = searchedMember.getHobby().split(",");
	String[] checks = new String[5];
	if(hobbys!=null){
		for(String v : hobbys){
			switch(v){
			case "운동" : checks[0]="checked"; break;
			case "등산" : checks[1]="checked";break;
			case "독서" : checks[2]="checked";break;
			case "게임" : checks[3]="checked";break;
			case "여행" : checks[4]="checked";break;
			}
		}
	}
%>
<section>
	<h2>회원정보수정</h2>
	<form action="<%= request.getContextPath() %>" id="memberFrm" method="post">
			<table>
			<tr>
                <th>아이디</th>
                <td>
                    <input type="text" placeholder="4글자이상"
                    name="userId" id="userId_" readonly value="<%=searchedMember.getUserId()%>">
                </td>
            </tr>
            <%-- <tr>
                <th>패스워드</th>
                <td>
                    <input type="password" name="password" id="password_" required
                    value="<%=m.getPassword()%>">
                </td>
            </tr>
            <tr>
                <th>패스워드확인</th>
                <td><input type="password" id="password_2" value="<%=m.getPassword()%>"></td>
            </tr> --%>
            <tr>
                <th>이름</th>
                <td>
                    <input type="text" name="userName" id="userName" required
                    value="<%=searchedMember.getUserName()%>">
                </td>
            </tr>
            <tr>
                <th>나이</th>
                <td>
                    <input type="number" name="age" id="age" min="0"
                    value="<%=searchedMember.getAge()%>">
                </td>
            </tr>
            <tr>
                <th>이메일</th>
                <td>
                    <input type="email" placeholder="abc@sdf.com" name="email" id="email"
                    value="<%=searchedMember.getEmail()%>">
                </td>
            </tr>
            <tr>
                <th>휴대폰</th>
                <td>
                    <input type="tel" placeholder="(-없이)01012345678" name="phone" id="phone" maxlength="11"
                    value="<%=searchedMember.getPhone()%>">
                </td>
            </tr>
            <tr>
                <th>주소</th>
                <td>
                    <input type="text" name="address" id="address" value="<%=searchedMember.getAddress()%>">
                </td>
            </tr>
            <tr>
                <th>성별</th>
                <td>
                    <input type="radio" name="gender" id="gender0" value="M"
                    <%=searchedMember.getGender().equals("M")?"checked":"" %>>
                    <label for="gender0">남</label>
                    <input type="radio" name="gender" id="gender1" value="F"
                    <%=searchedMember.getGender().equals("F")?"checked":"" %>>
                    <label for="gender1">여</label>
                </td>
            </tr>
            <tr>
                <th>취미</th>
                <td>
                    <input type="checkbox" name="hobby" id="hobby0" value="운동"
                    <%= checks[0] %>>
                    <label for="hobby0">운동</label>
                    <input type="checkbox" name="hobby" id="hobby1" value="등산"
                    <%= checks[1] %>>
                    <label for="hobby1">등산</label>
                    <input type="checkbox" name="hobby" id="hobby2" value="독서"
                    <%= checks[2] %>>
                    <label for="hobby2">독서</label>
                    <input type="checkbox" name="hobby" id="hobby3" value="게임"
                    <%= checks[3] %>>
                    <label for="hobby3">게임</label>
                    <input type="checkbox" name="hobby" id="hobby4" value="여행"
                    <%= checks[4] %>>
                    <label for="hobby4">여행</label>
                </td>
            </tr>
        </table>
        <button type="button" onclick="fn_update_password();">비밀번호변경</button> <!-- submit 역할까지 한다 -->
        <!--  폼 안에 버튼이 있을 경우 type을 button으로 설정해주지 않으면 submit이 된다 -->
        <input type="button" onclick="fn_update_submit();" value="정보수정">
        <input type="button" onclick="fn_delete_member();" value="탈퇴">
	</form>
</section>

<%@ include file="/views/common/footer.jsp"%>