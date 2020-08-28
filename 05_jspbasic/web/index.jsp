<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	/* 선언문 : class 클래스명 { 여기에 작성할 수 있는 코드} 
		멤버변수 : 접근제한자 자료형 변수명;
		메소드 : 접근제한자 반환형 메소드명(매개변수s)
*/
	public String name = "홍지운";
	public int sum(int su, int su2) {
		return su+su2;
	}
	
	//조건문, 반복문, 메소드 호출은 작성이 불가능함
	/* if(true){
		
	} */
%>

<% /* 스크릿트릿 : 자바의 메소드 안에 들어가는 javacode를 작성할 수 있음
		조건문, 반복문, 지역변수, 메소드 호출
	*/ 
	int age = 19;
	/* private String address="ji"; 안된다 */
	if(age > 19){
		System.out.println("ADULT");
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>나의 첫 jsp페이지</h1>
    <p>Welcome to JSP</p>
</body>
</html>