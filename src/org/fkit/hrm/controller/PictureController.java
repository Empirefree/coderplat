package org.fkit.hrm.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.fkit.hrm.domain.PictureResult;
import org.fkit.hrm.service.PictureService;
import org.fkit.hrm.util.DateUtil;
import org.fkit.hrm.util.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class PictureController {
//	@Autowired
//	private PictureService pictureService;
	
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String upload(MultipartFile uploadFile ,
			HttpServletRequest request ) {
		System.out.println("===============  /pic/upload");
		PictureResult result = null ;
		// 如果文件不为空，写入上传路径
				if(!uploadFile.isEmpty()){
					// 上传文件路径
					String path = request.getServletContext().getRealPath(
			                "/cncec/images");
					String contextPath = request.getContextPath() + "/cncec/images" ;
								// 上传文件名
					String filename = uploadFile.getOriginalFilename();
					filename.lastIndexOf(".") ;
					String suffix = filename.substring(filename.lastIndexOf(".") + 1);
								
					filename = DateUtil.getSdfTimes() + "_" + System.currentTimeMillis() + "." + suffix ;
					System.out.println( filename );
								
				    File filepath = new File(path,filename);
					// 判断路径是否存在，如果不存在就创建一个
			        if (!filepath.getParentFile().exists()) { 
			        	filepath.getParentFile().mkdirs();
			        }
			        // 将上传文件保存到一个目标文件当中
//			        File.separator
			        try {
						uploadFile.transferTo(new File(path+"/"+ filename));
					} catch (IllegalStateException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("==服务器保存图片文件物理路径：" + (path+"/"+ filename));
//					System.out.println("======path:======" + path+File.separator+ filename );
					System.out.println("==浏览器回显图片路径：" +  contextPath +"/"+ filename );
					System.out.println("==浏览器回显图片路径filename：" +   filename );
					result = PictureResult.ok(contextPath+"/"+ filename );
				}else{
					result = PictureResult.error("图片上传错误！") ;
				}
		
//		PictureResult result = pictureService.uploadPicture(uploadFile);
		return JsonUtils.objectToJson(result);
	}
	
}
