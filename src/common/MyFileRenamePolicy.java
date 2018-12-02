package common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

import admin.model.service.AdminService;

public class MyFileRenamePolicy implements FileRenamePolicy {
	String str;

	@Override
	public File rename(File oldFile) {
		File newFile = null;
		
		do {
			// 유니크한 파일명을 위해서 현재시각정보와 난수를 사용
			long currentTime = System.currentTimeMillis();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd_HHmmssSS");
			int rndNum = (int)(Math.random()*1000);
			
			// 확장자명 가져오기
			String fname = oldFile.getName();
			String ext = "";
			int dot = fname.lastIndexOf(".");
			if(dot > -1) {
				ext = fname.substring(dot);
			}
			
			// 새 파일명 생성
			String newFname = sdf.format(new Date(currentTime)) + "_" + rndNum + ext;
			
			// 새 파일 생성
			// getParent : 부모 파일의 주소 리턴
			newFile = new File(oldFile.getParent(), newFname);
			System.out.println("newFile@MyFileRenamePolicy = " + newFile.getName());
			System.out.println("newFile.exists() = " + newFile.exists());	// true이면, 새 이름 부여
			
		} while(!createNewFile(newFile));
		
		return newFile;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	private boolean createNewFile(File newFile) {
		
		try {
			// 파일이 존재하지 않으면, 파일 생성 후 true를 리턴.
			// 파일이 존재하면, 파일을 생성하지 않고 false를 리턴.
			return newFile.createNewFile();
		} catch (IOException e) {
			return false;
		}
	}
}