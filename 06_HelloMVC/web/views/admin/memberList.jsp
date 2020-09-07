<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>

<%
	List<Member> list = (List) request.getAttribute("members");
	String type = (String)request.getParameter("searchType");
	String keyword = (String)request.getParameter("searchkeyword");
%>
<%@ include file="/views/common/header.jsp"%>
<style type="text/css">
section#memberList-container {
	text-align: center;
}

section#memberList-container table#tbl-member {
	width: 100%;
	border: 1px solid gray;
	border-collapse: collapse;
}

section#memberList-container table#tbl-member th, table#tbl-member td {
	border: 1px solid gray;
	padding: 10px;
}

div#search-container {
	margin: 0 0 10px 0;
	padding: 3px;
	background-color: rgba(0, 188, 212, 0.3);
}
div#search-userId {
	display: inline-block;
}

div#search-userName {
	display: none;
}

div#search-gender {
	display: none;
}
</style>
<section id="memberList-container">
	<!-- 페이지 구성 -> 서버에서 보내준 members데이터를 table태그에 넣어서 출력하는 페이지 -->
	<h2>회원관리</h2>
	<div id="search-container">
		검색타입 : <select  id="searchType">
			<option value="userId" <%=type!=null && type.equals("userId")?"selected":"" %>>아이디</option>
			<option value="userName" <%=type!=null && type.equals("userName")?"selected":"" %>>이름</option>
			<option value="gender" <%=type!=null && type.equals("gender")?"selected":"" %>>성별</option>			
		</select>
		<div id="search-userId">
			<form action="<%= request.getContextPath()%>/admin/memberSearch">
				<input type="hidden" name="searchType" value="userId"> <input
					type="text" name="searchkeyword" size="25"
					placeholder="검색할 아이디를 입력하세요"
					value="<%= type!=null&&type.equals("userId")?keyword:""%>">
				<button type="submit">검색</button>
			</form>
		</div>
		<div id="search-userName">
			<form action="<%= request.getContextPath()%>/admin/memberSearch">
				<input type="hidden" name="searchType" value="userName"> <input
					type="text" name="searchkeyword" size="25"
					placeholder="검색할 이름을 입력하세요"
					value="<%= type!=null&&type.equals("userName")?keyword:""%>">
				<button type="submit">검색</button>
			</form>
		</div>
		<div id="search-gender">
			<form action="<%= request.getContextPath()%>/admin/memberSearch">
				<input type="hidden" name="searchType" value="gender"> <label><input
					type="radio" name="searchkeyword" value="M" <%= type!=null && type.equals("gender") && keyword.equals("M")?"checked":"" %>>남</label> <label><input
					type="radio" name="searchkeyword" value="F" <%= type!=null && type.equals("gender") && keyword.equals("F")?"checked":"" %>>여</label>
				<button type="submit">검색</button>
			</form>
		</div>
	</div>
	<div id="numberPage-container">
		<form id="numberPageFrm" action="">
			<select>
				<option value="5">5</option>
				<option value="10">10</option>
				<option value="15">15</option>
			</select>
		</form>
	</div>
	<table id="tbl-member">
		<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>성별</th>
				<th>나이</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>취미</th>
				<th>가입일</th>
			</tr>
		</thead>
		<tbody>
			<!--  서버에서 보내준 실제 데이터 출력 -->
			<%
				for (Member m : list) {
			%>
			<tr>
				<td><%=m.getUserId()%></td>
				<td><%=m.getUserName()%></td>
				<td><%=m.getGender()%></td>
				<td><%=m.getAge()%></td>
				<td><%=m.getEmail()%></td>
				<td><%=m.getPhone()%></td>
				<td><%=m.getAddress()%></td>
				<td><%=m.getHobby()%></td>
				<td><%=m.getEnrollDate()%></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	<div id="pageBar">
		<%= request.getAttribute("pageBar") %>
	</div>
</section>
<script>
$(function(){
	$("#searchType").change(e => {
		let userId=$("#search-userId");
		let userName=$("#search-userName");
		let gender=$("#search-gender");
		
		userId.css("display","none");
		userName.css("display","none");
		gender.css("display","none");
		
		let value=$(e.target).val();//userId, userName, gender;
		$("#search-"+value).css("display","inline-block");
	});
	$("#searchType").change();
})
</script>

<%@ include file="/views/common/footer.jsp"%>