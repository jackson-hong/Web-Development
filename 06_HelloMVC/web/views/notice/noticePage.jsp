<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.kh.notice.model.vo.Notice" %>
<%@ include file="/views/common/header.jsp" %>
<% Notice n = (Notice)request.getAttribute("notice"); %>

<section>
	<div id="notice-container">
        <table id="tbl-notice">
        <tr>
            <th>제 목</th>
            <td><%= n.getNoticeTitle() %></td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><%= n.getNoticeWriter() %></td>
        </tr>
        <tr>
            <th>첨부파일</th>
            <td>
           	<% if(n.getFilepath()!=null) {%>
           	<a href="<%= request.getContextPath() %>/notice/noticeFileDownload?fname=<%= n.getFilepath() %>">
           	<img src="<%=request.getContextPath() %>/images/file.png" width="20" height="20">
           	</a>
           	<% }else{ %>
           	No file <%} %>
            </td>
        </tr>
        <tr>
            <th>내 용</th>
            <td><%= n.getNoticeContent() %></td>
        </tr>
        <tr>
            <th colspan="2">
                <input type="button" value="수정하기" 
                onclick="location.assign('<%= request.getContextPath() %>/views/notice/noticeModify.jsp')">
                <input type="button" value="삭제하기" 
                onclick="location.assign('<%= request.getContextPath() %>/notice/deleteNotice?noticeNo=<%= n.getNoticeNo() %>')">
            </th>
        </tr>
    </table>
    </div>
</section>
	<style>
    section#notice-container{width:600px; margin:0 auto; text-align:center;}
    section#notice-container h2{margin:10px 0;}
    table#tbl-notice{width:500px; margin:0 auto; border:1px solid black; border-collapse:collapse; clear:both; }
    table#tbl-notice th {width: 125px; border:1px solid; padding: 5px 0; text-align:center;} 
    table#tbl-notice td {border:1px solid; padding: 5px 0 5px 10px; text-align:left;}
    </style>
<%@ include file="/views/common/footer.jsp"%>