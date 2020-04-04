package org.fkit.hrm.service.impl;

import org.apache.ibatis.reflection.ExceptionUtil;
import org.fkit.hrm.domain.PictureResult;
import org.fkit.hrm.service.PictureService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * 上传图片处理服务实现类
 * <p>Title: PictureService</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.com</p> 
 * @author	入云龙
 * @date	2015年8月15日下午2:59:38
 * @version 1.0
 */
@Service
public class PictureServiceImpl implements PictureService {
	
//	@Value("${FTP_ADDRESS}")
//	private String FTP_ADDRESS;
//	@Value("${FTP_PORT}")
//	private Integer FTP_PORT;
//	@Value("${FTP_USER_NAME}")
//	private String FTP_USER_NAME;
//	@Value("${FTP_PASSWORD}")
//	private String FTP_PASSWORD;
//	@Value("${FTP_BASE_PATH}")
//	private String FTP_BASE_PATH;
//	@Value("${IMAGE_BASE_URL}")
//	private String IMAGE_BASE_URL;
	

	@Override
	public PictureResult uploadPicture(MultipartFile uploadFile) {
		//判断上传图片是否为空
		if (null == uploadFile || uploadFile.isEmpty()) {
			return PictureResult.error("上传图片为空");
		}
		//取文件扩展名
		String originalFilename = uploadFile.getOriginalFilename();
		String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
		
//		try {
//			FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USER_NAME, FTP_PASSWORD, 
//					FTP_BASE_PATH, filePath, imageName + ext, uploadFile.getInputStream());
//		} catch (Exception e) {
//			e.printStackTrace();
//			return PictureResult.error(ExceptionUtil.getStackTrace(e));
//		}
		//返回结果，生成一个可以访问到图片的url返回
		
		return PictureResult.ok("http://127.0.0.1/cncec16/cncec/images" + originalFilename);
	}

}
