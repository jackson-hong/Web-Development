<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<%
	//서버에서 보낸 데이터 받기
	Member m=(Member)request.getAttribute("member");
	String[] hobbys = m.getHobby().split(",");
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
<section id="enroll-container">
	<h2>회원정보수정</h2>
	<form action="<%= request.getContextPath() %>" id="memberFrm" method="post">
			<table>
			<tr>
                <th>아이디</th>
                <td>
                    <input type="text" placeholder="4글자이상"
                    name="userId" id="userId_" readonly value="<%=m.getUserId()%>">
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
                    value="<%=m.getUserName()%>">
                </td>
            </tr>
            <tr>
                <th>나이</th>
                <td>
                    <input type="number" name="age" id="age" min="0"
                    value="<%=m.getAge()%>">
                </td>
            </tr>
            <tr>
                <th>이메일</th>
                <td>
                    <input type="email" placeholder="abc@sdf.com" name="email" id="email"
                    value="<%=m.getEmail()%>">
                </td>
            </tr>
            <tr>
                <th>휴대폰</th>
                <td>
                    <input type="tel" placeholder="(-없이)01012345678" name="phone" id="phone" maxlength="11"
                    value="<%=m.getPhone()%>">
                </td>
            </tr>
            <tr>
                <th>주소</th>
                <td>
                    <input type="text" name="address" id="address" value="<%=m.getAddress()%>">
                </td>
            </tr>
            <tr>
                <th>성별</th>
                <td>
                    <input type="radio" name="gender" id="gender0" value="M"
                    <%=m.getGender().equals("M")?"checked":"" %>>
                    <label for="gender0">남</label>
                    <input type="radio" name="gender" id="gender1" value="F"
                    <%=m.getGender().equals("F")?"checked":"" %>>
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
	<script>
		function fn_update_password(){
			//1. 비밀번호 변경창을 열고
			const url="<%= request.getContextPath() %>/updatePassword?userId="+$("#userId_").val();
			const status = "left=500px, top=200px, width=400px, height=210px";
			
			open(url,"",status);
			//2. 비밀번호 수정하기
		}
		
		function fn_delete_member(){
			//id 서버에 전송해서 그 id랑 일치하는 회원을 삭제
			<%-- <%= logginedMember.getUserId() %> --%>
			if(confirm("정말로 탈퇴하시겠습니까?")){
			location.replace('<%= request.getContextPath() %>/member/deleteMember?userId=<%= logginedMember.getUserId() %>');
			}
		}
	
		function fn_update_submit(){
			const frm = $("#memberFrm");
			const url = "<%= request.getContextPath() %>/member/memberUpdate";
			frm.attr({
				"action":url,
				"method":"post",
			})
			frm.submit();
		}	
	
		$(function(){
			$("#password_2").blur(e=>{
				let pw = $("#password_");
				if($(e.target).val()!=pw.val()){
					alert("비밀번호가 일치하지 않습니다");
					pw.val("");
					$(e.target).val("");
					pw.focus();
				}
			})
		})
	</script>
</section>
<%@ include file="/views/common/footer.jsp" %>
