package com.kh.common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

//file rename 정책만들기
//FileRenamePolicy 인터페이스를 구현
public class MyFileRename implements FileRenamePolicy{
	
	
	@Override
	public File rename(File oldFile) {
		//rename 을 실행하는 메소드
		File newFile = null;
		do {
			long currentTime = System.currentTimeMillis();//현재시간 가져옴
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmssSSS");
			int rndNum=(int)(Math.random()*1000);
			//현재파일의 명칭을 변경하기 위해
			//확장자명만 가져오기
			String orlName = oldFile.getName();//확장자 포함 파일명 가져오기
			String ext = "";
			int dot = orlName.lastIndexOf(".");
			if(dot>-1) {
				//.이 없는 경우 -1 = 파일이 이상함
				ext = orlName.substring(dot);
			}
			//새파일이름을 변경하기
			String newName = sdf.format(new Date(currentTime)) + "_" +rndNum + ext;
			newFile = new File(oldFile.getParent(),newName);
		}while(!createNewFile(newFile));
		return newFile;
	}
	private boolean createNewFile(File f) {
		try {
			return f.createNewFile();
		}catch(IOException e) {
			return false;
		}
	}
}
