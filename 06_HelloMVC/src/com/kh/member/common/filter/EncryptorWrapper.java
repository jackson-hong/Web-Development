package com.kh.member.common.filter;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncryptorWrapper extends HttpServletRequestWrapper {
	
	public EncryptorWrapper(HttpServletRequest request) {
		super(request);
	}
	
	//재정의하고 싶은 메소드를 작성 -> @override
	@Override
	public String getParameter(String name) {
		
		//client가 전달한 값 중 비밀번호(password)에 해당하는 name값만
		//암호화 처리하고 나머지 name은 정상적으로 처리
		String returnValue = "";
		if(name.equals("password")) {
			//암호화 처리 후 반환
			String pw = super.getParameter(name);
			String encPw = getSha512(pw);
			returnValue = encPw;
		}else {
			//원래대로 반환
			returnValue = super.getParameter(name); //원래대로 값을 반환
		}
		return returnValue;
	}
	
	private String getSha512(String value) {
		String encPwd = null; //암호화한 값을 보관
		
		//암호화 처리 객체
		MessageDigest md = null; //java.security.MessageDigest
		
		//1. 암호화 알고리즘을 불러옴
		try {
			md = MessageDigest.getInstance("SHA-512");
		}catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		//2. 알고리즘을 이용해서 Byte단위로 암호화 처리를 함
		byte[] bytes = value.getBytes(Charset.forName("UTF-8"));//패스워드 값을 byte로 변경
		//byte값을 MessageDigest를 이용해서 암호화함.
		//md.update()메소드를 이용
		md.update(bytes);//md에 지정된 암호화 알고리즘에 의해 매개변수의 값을 암호화함
		
		//3. Byte로 쪼개서 암호화한 내용을 String 값으로 변환
		encPwd = Base64.getEncoder().encodeToString(md.digest());
		
		//4. 변환값 리턴
		return encPwd;
	}
}
