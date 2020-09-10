<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>

<section>
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
						<input type="submit" value="수정하기" onclick="return validate();">
					</th>
				</tr>
			</table>
		</form>
</section>

<%@ include file="/views/common/footer.jsp"%>