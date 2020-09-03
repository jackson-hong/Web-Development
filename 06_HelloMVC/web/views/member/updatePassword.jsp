<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호변경</title>
<style>
    div#updatePassword-container{
        background:red;
    }
    div#updatePassword-container table {
        margin:0 auto;
        border-spacing: 20px;
    }
    div#updatePassword-container table tr:last-of-type td {
        text-align:center;
    }
</style>
<script src="<%=request.getContextPath() %>/js/jquery-3.5.1.min.js"></script>
</head>
<body>
	<div id="updatePassword-container">
		<form action="<%=request.getContextPath() %>/updatePasswordEnd" method="post">
			<table>
				<tr>
					<th>
						변경할 비밀번호
					</th>
					<td>
						<input type="password" name="password" id="pw">
					</td>
				</tr>
				<tr>
					<th>
						비밀번호확인
					</th>
					<td>
						<input type="password" id="pwck">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="변경" onclick="return validate();">
						&nbsp;
						<input type="button" value="닫기" onclick="self.close();">
					</td>
				</tr>
			</table>	
		<input type="hidden" name="userId" value="<%= request.getParameter("userId") %>">
		</form>
	</div>
	<!-- id를 받아와야 이 창에서 jdbc를 통해 변경이 가능함으로 id를 까먹지 말 것 -->
	<script>
		function validate(){
			let pw=$("#pw").val().trim();
			let pwck=$("#pwck").val().trim();
			if(pw!=pwck){
				alert("비밀번호가 일치하지 않습니다");
				$("#pw").val("");
				$("#pwck").val("");
				$("#pw").focus();
				return false;
			}
		}
	</script>
</body>
</html>
