<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp"%>

<section>
	<div id="notice-container">
		<h2>공지사항작성</h2>
		<!-- 
			파일 업로드 할 때 반드시 form속성 설정!
			1. entype 속성을 설정 -> multipart/formdata
			2. method -> post로 설정
		 -->
		<form enctype="multipart/form-data" action="<%= request.getContextPath() %>/notice/noticeWriteEnd" method="post">
			<table id="tbl-notice">
				<tr>
					<th>제 목</th>
					<td><input type="text" name="title" id="title" size="45" required></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td><input type="text" name="writer" id="writer"
						value="<%= logginedMember.getUserId() %>" readonly></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type="file" name="upfile" id=""></td>
				</tr>
				<tr>
					<th>내 용</th>
					<td><textarea name="content" id="" cols="50" rows="5"></textarea></td>
				</tr>
				<tr>
					<th colspan="2">
						<input type="submit" value="등록하기" onclick="return validate();">
					</th>
				</tr>
			</table>
		</form>
	</div>
	<script>
		function validate(){
			const content = $("[name=content]").val();
			if(content.trim().length=0) {
				alert("내용을 입력해주세요!");
				$("[name=content]").focus();
				return false;
			}
		}
	</script>
</section>
<style>
    section#notice-container{width:600px; margin:0 auto; text-align:center;}
    section#notice-container h2{margin:10px 0;}
    table#tbl-notice{width:500px; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
    table#tbl-notice th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;} 
    table#tbl-notice td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
</style>

<%@ include file="/views/common/footer.jsp"%>