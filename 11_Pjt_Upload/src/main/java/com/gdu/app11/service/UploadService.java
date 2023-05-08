package com.gdu.app11.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface UploadService {
	
	// 파일업로드일땐 MultipartHttpServletRequest를 사용한다.
	public int addUpload(MultipartHttpServletRequest multipartRequest);
	
	
}
