package com.kh.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;


//양방향 암호화 처리 객체
//양방향 암호화처리시에는 key 관리가 중요함!

public class AESCrypto {
	private static SecretKey key;// 암호화키 객체
	private String path; // 키를 저장하는 위치

	public AESCrypto() {
		// 생성과 동시에 key값을 가져와야함.
		// key가 없으면 암호화 key를 생성하고
		// 있으면 있는 key(SecretKey)를 가져옴

		// WEB-INF 경로가져오기
		this.path = AESCrypto.class.getResource("/").getPath();

		// key가 있는지 확인
		File f = new File(this.path + "/bslove.bs");

		if (f.exists()) {
			// 있으면 bslove.bs 파일 불러오기
			try (ObjectInputStream oid = new ObjectInputStream(new FileInputStream(f))) {
				key = (SecretKey) (oid.readObject());// 파일에 저장되어있는 key값을 불러옴
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			// key 객체 만들고 파일에 저장 없으면 만들기
			if (key == null) {
				getGenerator();
			}
		}
	}

	private void getGenerator() {
		// 랜덤값을 가져오는 객체 -> key값을 만들 때 salt값 (기준이 되는 값)
		SecureRandom ser = new SecureRandom();
		// key를 생성하는 객체
		KeyGenerator keygen = null;
		try {
			keygen = KeyGenerator.getInstance("AES");// 알고리즘 이름
			keygen.init(128, ser); // 생성할 key 설정
			key = keygen.generateKey();// key 생성
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// 파일로 저장해서 현재 생성된 key만 이용할 수 있게 처리
		File f = new File(this.path + "/bslove.bs");
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
			oos.writeObject(this.key);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 암호화 메소드
	public static String encrypt(String str)
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException,
				IllegalBlockSizeException{
		// Cipher 객체를 이용해서 key값을 가지고 암호화 작업을 함.
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(cipher.ENCRYPT_MODE, key);
		//매개변수로 넘어온 값을 암호화해주기
		//byte로 변환해서 암호화처리를 함.
		byte[] encrypt = str.getBytes(Charset.forName("UTF-8"));
		byte[] result = cipher.doFinal(encrypt);
		String strResult = Base64.getEncoder().encodeToString(result);
		return strResult;
	}

	// 복호화 메소드
	public static String decrypt(String str) 
			throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException,
			IllegalBlockSizeException{
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(cipher.DECRYPT_MODE, key);
		byte[] decodeStr = Base64.getDecoder().decode(str.getBytes(Charset.forName("UTF-8")));
		byte[] decrypt = cipher.doFinal(decodeStr);
		
		return new String(decrypt);
	}
}
