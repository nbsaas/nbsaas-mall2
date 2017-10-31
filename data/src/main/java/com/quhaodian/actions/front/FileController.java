/*
 * 
 * 
 * 
 */
package com.quhaodian.actions.front;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.quhaodian.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ada.plug.data.vo.FileInfo;
import com.ada.plug.data.vo.FileInfo.FileType;
import com.ada.plug.data.vo.FileInfo.OrderType;
import com.quhaodian.services.file.FileService;

/**
 * Controller - 文件处理
 * 
 * 
 * 
 */
@Controller("fileController")
@RequestMapping("files")
public class FileController  {

	@Resource(name = "fileServiceImpl2")
	private FileService fileService;



	/**
	 * 上传
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
	public void upload(FileType fileType, MultipartFile file, HttpServletResponse response) {
		Map<String, Object> data = new HashMap<String, Object>();
		if (!fileService.isValid(fileType, file)) {
			data.put("message", "");
		} else {
			String url = fileService.upload(fileType, file, false);
			if (url == null) {
				data.put("message", "");
			} else {
				data.put("message", "");
				data.put("url", url);
			}
		}
		try {
			response.setContentType("text/html; charset=UTF-8");
			JsonUtils.writeValue(response.getWriter(), data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * 浏览
	 */
	@RequestMapping(value = "/browser", method = RequestMethod.GET)
	public @ResponseBody List<FileInfo> browser(String path, FileType fileType, OrderType orderType) {
		return fileService.browser(path, fileType, orderType);
	}

}