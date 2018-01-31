package com.quhaodian.haodian.actions.front;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.storage.model.FileListing;
import com.qiniu.util.Auth;

@Controller
@RequestMapping(value = "image")
public class ImageAction {

	String domain = "openyelp";

	@RequestMapping(value = "upimg", method = RequestMethod.POST)
	@ResponseBody
	public String upimg(
			@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request, ModelMap model) {

		String origName = file.getOriginalFilename();
		String ext = FilenameUtils.getExtension(origName).toLowerCase(
				Locale.ENGLISH);
		System.out.println(origName);

		return "{'success', 'true'}";
	}

	@RequestMapping(value = "upimgwork", method = RequestMethod.POST)
	public String upimgwork(
			@RequestParam(value = "imgFile", required = false) MultipartFile file,
			HttpServletRequest request, ModelMap model)
			throws FileUploadException {
		return cccc(file, request, model);
	}

	@RequestMapping(value = "upremoteimgwork", method = RequestMethod.POST)
	public String upremoteimgwork(
			@RequestParam(value = "imgFile", required = false) MultipartFile file,
			HttpServletRequest request, ModelMap model)
			throws FileUploadException {
		return cccc(file, request, model);
	}

	@RequestMapping(value = "upmendaoimgwork", method = RequestMethod.POST)
	public String upmendaoimgwork(
			@RequestParam(value = "imgFile", required = false) MultipartFile file,
			HttpServletRequest request, ModelMap model)
			throws FileUploadException {
		return cccc(file, request, model);
	}

	final String url = "http://7xiowm.com1.z0.glb.clouddn.com/";;

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
			Upitem itemss = new Upitem();
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

	@RequestMapping(value = "listimages", method = RequestMethod.GET)
	public String listimages(HttpServletRequest request, ModelMap model) {

		Auth auth = Auth.create("U5VKtUFe6bCJ642tnFu4--fP2DSydhNxJ13Dc74O",
				"Exi35KBoHRKw6ensQMJBECKnRTEIEsu4aXvMJDA2");
		String token = auth.uploadToken("fatherknow");
		System.out.println(token);
		BucketManager manager = new BucketManager(auth);
		List<Item> itemss = new ArrayList<ImageAction.Item>();
		try {
			FileListing list = manager.listFiles(domain, "", "", 100, "");

			FileInfo[] items = list.items;
			for (FileInfo fileInfo : items) {
				System.out.println(fileInfo.key);
				Item e = new Item();
				e.filesize = (int) fileInfo.fsize;
				e.filename = url + fileInfo.key;
				itemss.add(e);
			}
		} catch (QiniuException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ItemInfo info = new ItemInfo();
		info.setFile_list(itemss);
		info.setTotal_count(itemss.size());
		Gson gson = new Gson();
		model.addAttribute("msg", gson.toJson(info));
		return "common/text";
	}

	private Upinfo getError(String message) {
		Upinfo info = new Upinfo();
		info.setError(1);
		info.setMessage(message);
		return info;
	}

	private String getErrorString(String message, ModelMap model) {
		Upinfo info = new Upinfo();
		info.setError(1);
		info.setMessage(message);
		Gson gson = new Gson();
		model.addAttribute("msg", gson.toJson(info));

		return "common/text";
	}

	public class Upinfo {

		private int error;
		private String message;

		public int getError() {
			return error;
		}

		public void setError(int error) {
			this.error = error;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}

	public static class Upitem {

		private int error;
		private String url;

		private String width;
		private String height;

		public String getWidth() {
			return width;
		}

		public void setWidth(String width) {
			this.width = width;
		}

		public String getHeight() {
			return height;
		}

		public void setHeight(String height) {
			this.height = height;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public int getError() {
			return error;
		}

		public void setError(int error) {
			this.error = error;
		}

	}

	public class Item {

		private boolean is_dir = false;
		private boolean has_file = false;
		private boolean is_photo = true;
		private String filetype = "jpg";
		private int filesize = 0;
		private String filename;
		private String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new Date());

		public boolean isIs_dir() {
			return is_dir;
		}

		public void setIs_dir(boolean is_dir) {
			this.is_dir = is_dir;
		}

		public boolean isHas_file() {
			return has_file;
		}

		public void setHas_file(boolean has_file) {
			this.has_file = has_file;
		}

		public boolean isIs_photo() {
			return is_photo;
		}

		public void setIs_photo(boolean is_photo) {
			this.is_photo = is_photo;
		}

		public String getFiletype() {
			return filetype;
		}

		public void setFiletype(String filetype) {
			this.filetype = filetype;
		}

		public int getFilesize() {
			return filesize;
		}

		public void setFilesize(int filesize) {
			this.filesize = filesize;
		}

		public String getFilename() {
			return filename;
		}

		public void setFilename(String filename) {
			this.filename = filename;
		}

		public String getDatetime() {
			return datetime;
		}

		public void setDatetime(String datetime) {
			this.datetime = datetime;
		}

	}

	public class ItemInfo {
		private List<Item> file_list;
		private int total_count;
		private String current_url = "";
		private String current_dir_path = "";
		private String moveup_dir_path = "";

		public String getCurrent_url() {
			return current_url;
		}

		public void setCurrent_url(String current_url) {
			this.current_url = current_url;
		}

		public String getCurrent_dir_path() {
			return current_dir_path;
		}

		public void setCurrent_dir_path(String current_dir_path) {
			this.current_dir_path = current_dir_path;
		}

		public String getMoveup_dir_path() {
			return moveup_dir_path;
		}

		public void setMoveup_dir_path(String moveup_dir_path) {
			this.moveup_dir_path = moveup_dir_path;
		}

		public List<Item> getFile_list() {
			return file_list;
		}

		public void setFile_list(List<Item> file_list) {
			this.file_list = file_list;
		}

		public int getTotal_count() {
			return total_count;
		}

		public void setTotal_count(int total_count) {
			this.total_count = total_count;
		}
	}
}
