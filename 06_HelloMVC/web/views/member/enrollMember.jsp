<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/views/common/header.jsp"%>
<section id="enroll-container">
    <h2>회원가입정보</h2>
    <form name="memberEnrollFrm" action="memberEnrollEnd" method="post">
        <table>
            <tr>
                <th>아이디</th>
                <td><input type="text" placeholder="4글자이상" name="userId" id="userId_" required>
                    <input type="button" value="중복검사" onclick="fn_id_duplicate();">
                </td>
            </tr>
            <tr>
                <th>패스워드</th>
                <td><input type="password" name="password" id="password_"
                    required></td>
            </tr>
            <tr>
                <th>패스워드확인</th>
                <td><input type="password" id="password_2"
                    ></td>
            </tr>
            <tr>
                <th>이름</th>
                <td><input type="text" name="userName" id="userName" required></td>
            </tr>
            <tr>
                <th>나이</th>
                <td><input type="number" name="age" id="age" min="0"></td>
            </tr>
            <tr>
                <th>이메일</th>
                <td><input type="email" placeholder="abc@sdf.com" name="email" id="email"></td>
            </tr>
            <tr>
                <th>휴대폰</th>
                <td><input type="tel" placeholder="(-없이)01012341234" name="phone" id="phone" maxlength="11"></td>
            </tr>
            <tr>
                <th>주소</th>
                <td><input type="text" name="address" id="address"></td>
            </tr>
            <tr>
                <th>성별</th>
                <td><input type="radio" name="gender" id="gender0" value="M">
                    <label for="gender0">남</label>
                    <input type="radio" name="gender" id="gender1" value="F">
                    <label for="gender1">여</label>
                </td>
            </tr>
            <tr>
                <th>취미</th>
                <td><input type="checkbox" name="hobby" id="hobby0" value="운동">
                <label for="hobby0">운동</label>
                <input type="checkbox" name="hobby" id="hobby1" value="등산">
                <label for="hobby1">등산</label>
                <input type="checkbox" name="hobby" id="hobby2" value="독서">
                <label for="hobby2">독서</label>
                <input type="checkbox" name="hobby" id="hobby3" value="게임">
                <label for="hobby3">게임</label>
                <input type="checkbox" name="hobby" id="hobby4" value="여행">
                <label for="hobby4">여행</label></td>
            </tr>
        </table>
        <input type="submit" value="가입">
        <input type="reset" value="취소">
    </form>
    <form action="" name="checkIdDuplicate">
    	<input type="hidden" name="userId">
    </form>
</section>
<script>
	$(function(){
		$("#password_2").blur(e=>{
			let pw=$("#password_").val();
			let pwck=$(e.target).val();
			if(pw.trim()!=pwck.trim()){
				alert("비밀번호가 일치하지 않습니다.");
				$("#password_").val("");
				$(e.target).val("");
				$("#password_").focus();
			}
		})
	});
	
	//아이디 중복확인하는 함수
	function fn_id_duplicate(){
		//중복확인 창을 출력하기
		//중복확인전 아이디는 기본 4글자 이상입력을 해야하기 때문에
		//입력된 아이디값이 4글자 이상인지 확인
		let id=$("#userId_").val().trim();
		if(id.length<4){
			alert("아이디는 4글자 이상입력하세요!");
			return;
		}
		
		//중복확인할 새창을 띄우기
		const url="<%=request.getContextPath()%>/checkIdDuplicate";
		const title="checkIdDuplicate";
		const status="left=500px,top=100px,width=300px,height=200px";
		
		open("",title,status);
		
		//form에 데이터를 채우고 open된 윈도우에서 결과를 받는 로직을 구성
		//자바스크립트에서 form은 name속성으로 요소를 가져올 수 있음
		console.log(checkIdDuplicate);
		checkIdDuplicate.target=title;//form을 전송하는 윈도우를 선정
		checkIdDuplicate.action = url;
		checkIdDuplicate.method="post";
		//input에 userId값 넣기 formnam속성값에서 inputname 속성값으로 가져올 수 있음
		
		console.log(checkIdDuplicate.name);
		checkIdDuplicate.userId.value=id;
		
		//form 전송하기
		checkIdDuplicate.submit();
	}
</script>
<%@ include file="/views/common/footer.jsp"%>