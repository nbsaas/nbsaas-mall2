/**
 * 
 */
package com.quhaodian.actions.front;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

/**
 * 上传图片
 * @author langhsu
 *
 */
@Controller
@RequestMapping("/image")
public class UploadController  {
	private static Map<String, String> errors = new HashMap<String, String>();
	
	// 文件允许格式
	private String[] allowFiles = { ".gif", ".png", ".jpg", ".jpeg", ".bmp" };
	
	static {
		errors.put("SUCCESS", "SUCCESS"); //默认成功
		errors.put("NOFILE", "未包含文件上传域");
		errors.put("TYPE", "不允许的文件格式");
		errors.put("SIZE", "文件大小超出限制");
		errors.put("REQUEST", "上传请求异常");
		errors.put("UNKNOWN", "未知错误");
	}
	
	@RequestMapping("/upload")
    public @ResponseBody Data upload(@RequestParam(value = "file", required=false) MultipartFile file,
    		Boolean scale, Integer size) {
    	Data data = Data.failure("error");
    	
    	if (file == null || file.isEmpty()) {
    		data = Data.failure(errors.get("NOFILE"));
			return data;
		}
    	
    	if (!checkFileType(file.getOriginalFilename())) {
    		data = Data.failure(errors.get("TYPE"));
			return data;
    	}
    	
    	try {
    		String path = null;
    		Auth auth = Auth.create("U5VKtUFe6bCJ642tnFu4--fP2DSydhNxJ13Dc74O",
    				"Exi35KBoHRKw6ensQMJBECKnRTEIEsu4aXvMJDA2");
    		String token = auth.uploadToken(domain);
    		UploadManager manager = new UploadManager();
    		try {
    			String key = UUID.randomUUID().toString().toLowerCase()
    					.replace("-", "");
    			path = url + key;
    			Response r = manager.put(file.getBytes(), key, token);
    		} catch (QiniuException e) {
    			e.printStackTrace();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
			data = Data.success("", path);
		} catch (Exception e) {
			//FIXME: error handle
			data = Data.failure(errors.get("UNKNOWN"));
		}
    	
    	return data;
    }
	final String url = "http://7xiowm.com1.z0.glb.clouddn.com/";;
	String domain = "openyelp";

	protected String cccc(MultipartFile file, HttpServletRequest request,
			ModelMap model) {

		Auth auth = Auth.create("U5VKtUFe6bCJ642tnFu4--fP2DSydhNxJ13Dc74O",
				"Exi35KBoHRKw6ensQMJBECKnRTEIEsu4aXvMJDA2");
		String token = auth.uploadToken(domain);
		UploadManager manager = new UploadManager();
		try {
			String key = UUID.randomUUID().toString().toLowerCase()
					.replace("-", "");
			String murl = url + key;
			Response r = manager.put(file.getBytes(), key, token);
			System.out.println(r.address);
			System.out.println(r.bodyString());
			ImageAction.Upitem itemss = new ImageAction.Upitem();
			itemss.setError(0);
			itemss.setUrl(murl);
			Gson gson = new Gson();
			model.addAttribute("msg", gson.toJson(itemss));
		} catch (QiniuException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "common/text";
	}

	/**
	 * 文件类型判断
	 * 
	 * @param fileName
	 * @return
	 */
	private boolean checkFileType(String fileName) {
		Iterator<String> type = Arrays.asList(this.allowFiles).iterator();
		while (type.hasNext()) {
			String ext = type.next();
			if (fileName.toLowerCase().endsWith(ext)) {
				return true;
			}
		}
		return false;
	}
}
