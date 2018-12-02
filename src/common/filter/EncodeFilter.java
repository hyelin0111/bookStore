package common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodeFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//1.전송값에 한글이 있을경우대비 인코딩처리
		request.setCharacterEncoding("utf-8");
		//2.응답객체에 mime 및 인코딩세팅
		response.setContentType("text/html; charset=utf-8");
		//System.out.println("[utf-8 인코딩처리됨@EncodeFilter]");
		
		//필터채인의 다음필터를 호출함.
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
