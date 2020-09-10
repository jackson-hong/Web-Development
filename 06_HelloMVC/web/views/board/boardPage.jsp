<%@page import="com.kh.board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/header.jsp" %>
<% Board b = (Board)request.getAttribute("board"); %>
<!-- include 다음에 객체 불러오기 -->
<section>
	<style>
    section#board-container{width:600px; margin:0 auto; text-align:center;}
    section#board-container h2{margin:10px 0;}
    table#tbl-board{width:500px; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
    table#tbl-board th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;} 
    table#tbl-board td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
    </style>
   
		<div id="board-container">
		<h2>게시판</h2>
		<table id="tbl-board">
			<tr>
				<th>글번호</th>
				<td><%= b.getBoardNo() %></td>
			</tr>
			<tr>
				<th>제 목</th>
				<td><%= b.getBoardTitle() %></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%= b.getBoardWriter() %></td>
			</tr>
			<tr>
				<th>조회수</th>
				<td><%= b.getBoardReadcount() %></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
				<% if(b.getBoardOriginalFilename() != null) {%>
				<a href="javascript:fn_fileDownload('<%= b.getBoardOriginalFilename()%>', '<%= b.getBoardRenamedFilename() %>')">
				<img alt="" src="<%= request.getContextPath() %>/images/file.png" width="20" height="20">
				</a>
				<script>
					function fn_fileDownload(oriname,rename){
						const url="<%= request.getContextPath()%>/board/boardFileDown";
						let oName=encodeURIComponent(oriname);
						location.assign(url+'?oName='+oName+'&rName='+rename);
					}
				</script>
				<%}%>
				</td>
			</tr>
			<tr>
				<th>내 용</th>
				<td><%= b.getBoardContent() %></td>
			</tr>
			<tr>
				<th colspan="2">
					<% if(logginedMember.getUserId().equals(b.getBoardWriter())||
					logginedMember.getUserId().equals("admin")){ %>
					<button type="button" onclick="update();">수정하기</button>
					<button type="button" onclick="delete();">삭제하기</button>
					<% } %>
					<button type="button" onclick="location.replace('<%= request.getContextPath() %>/board/boardList')">목록으로</button>
				</th>
			</tr>
		</table>
    </div>
</section>

<%@ include file="/views/common/footer.jsp"%>