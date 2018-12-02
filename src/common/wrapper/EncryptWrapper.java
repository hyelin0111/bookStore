package common.wrapper;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class EncryptWrapper extends HttpServletRequestWrapper {

	//기본생성자가 없으므로
	//반드시 HttpServletRequest를 매개변수로 하는 생성자를 작성해야함.
	public EncryptWrapper(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String key) {
		String value = "";
		//if(key != null && key.equals("password")) {
		//비밀번호수정시 파라미터 password_new추가  || key.equals("password_new")
		if(key != null && (key.equals("password")||key.equals("memPwd")||key.equals("pwd_n"))) {
			value = super.getParameter(key);
//			System.out.println("암호화전 : "+value);
			//암호화처리 메소드호출
			value = getSha512(value);
//			System.out.println("암호화후 : "+value);
		}
		else {
			value = super.getParameter(key);
		}
		return value;
	}

	private String getSha512(String password) {
		String encPwd = null;
		//암호화객체 MessageDigest 생성
		MessageDigest md = null;
		try {
			//MD2, MD5, SHA-1, SHA-256, SHA-384 등의 해싱알고리즘을 지원
			md = MessageDigest.getInstance("SHA-512");
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		//전달받은 password 문자열을 byte[]로 변환.
		byte[] bytes = password.getBytes(Charset.forName("UTF-8"));
		
		//md객체에 바이트배열을 전달해서 update
		md.update(bytes);
		//md객체에 알고리즘을 적용 계산처리함.
		byte[] encryptedBytes = md.digest();
		
		//바이너리데이터 포맷팅으로 Base64인코더를 이용.
		//바이트배열 => 문자열
		encPwd = Base64.getEncoder().encodeToString(encryptedBytes);
		
		return encPwd;
	}
	
	
	
	
	
	
}
