<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ include file="/views/common/header.jsp" %>
<% 
	List<Person> list = new ArrayList();
	list.add(new Person("jackson",30,"hong@naver.com"));
	list.add(new Person("jason",18,"hoang@naver.com"));
	list.add(new Person("patrick",23,"paaa@naver.com"));
	list.add(new Person("jeong",30,"jeong@naver.com"));
	list.add(new Person("cms",35,"cms@naver.com"));
%>
<section>
	
	<table>
		<tr>
			<th>이름</th>
			<th>나이</th>
			<th>이메일</th>
		</tr>
		<% for(Person person : list){ 
			if(person.getAge()>26) {
		%>
			<tr>
				<td><%= person.getName() %></td>
				<td><%= person.getAge() %></td>
				<td><%= person.getEmail() %></td>
			</tr>
		<% }
		}%> 
	</table>
	
	
	
</section>	
	
<%@ include file="/views/common/footer.jsp" %>