/*
 * 
 * 
 * 
 */
package com.quhaodian.services.file.impl;

import com.quhaodian.plug.api.StoragePlugin;
import com.quhaodian.plug.data.vo.FileInfo;
import com.quhaodian.plug.data.vo.FileInfo.FileType;
import com.quhaodian.plug.data.vo.FileInfo.OrderType;
import com.quhaodian.services.file.FileService;
import com.quhaodian.services.file.PluginFileService;
import com.quhaodian.utils.FreemarkerUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.io.File;
import java.util.*;

/**
 * Service - 文件
 * 
 * 
 * 
 */
@Service("fileServiceImpl")
public class FileServiceImpl implements FileService, ServletContextAware {

	/** servletContext */
	private ServletContext servletContext;

	@Resource(name = "taskExecutor")
	private TaskExecutor taskExecutor;

	@Resource(name = "pluginFileServiceImpl")
	private PluginFileService pluginService;

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	/**
	 * 添加上传任务
	 * 
	 * @param storagePlugin
	 *            存储插件
	 * @param path
	 *            上传路径
	 * @param tempFile
	 *            临时文件
	 * @param contentType
	 *            文件类型
	 */
	private void addTask(final StoragePlugin storagePlugin, final String path, final File tempFile,
			final String contentType) {
		taskExecutor.execute(new Runnable() {
			public void run() {
				try {
					storagePlugin.upload(path, tempFile, contentType);
				} finally {
					FileUtils.deleteQuietly(tempFile);
				}
			}
		});
	}

	public boolean isValid(FileType fileType, MultipartFile multipartFile) {
		if (multipartFile == null) {
			return false;
		}
		// Setting setting = SettingUtils.get();
		// if (setting.getUploadMaxSize() != null && setting.getUploadMaxSize()
		// != 0 && multipartFile.getSize() > setting.getUploadMaxSize() * 1024L
		// * 1024L) {
		// return false;
		// }
		String[] uploadExtensions = null;
		if (fileType == FileType.flash) {
			uploadExtensions = "swf,flv".split(",");
		} else if (fileType == FileType.media) {
			uploadExtensions = "swf,flv,mp3,wav,avi,rm,rmvb".split(",");
		} else if (fileType == FileType.file) {
			uploadExtensions = "zip,rar,7z,doc,docx,xls,xlsx,ppt,pptx".split(",");
		} else {
			uploadExtensions = "jpg,jpeg,bmp,gif,png".split(",");
		}
		if (ArrayUtils.isNotEmpty(uploadExtensions)) {
			return FilenameUtils.isExtension(multipartFile.getOriginalFilename(), uploadExtensions);
		}
		return false;
	}

	public String upload(FileType fileType, MultipartFile multipartFile, boolean async) {
		if (multipartFile == null) {
			return null;
		}
		String uploadPath;
		if (fileType == FileType.flash) {
			uploadPath = "/flash/${.now?string('yyyyMM')}/";
		} else if (fileType == FileType.media) {
			uploadPath = "/media/${.now?string('yyyyMM')}/";
		} else if (fileType == FileType.file) {
			uploadPath = "/file/${.now?string('yyyyMM')}/";
		} else {
			uploadPath = "/images/${.now?string('yyyyMM')}/";
		}
		String backpath = "";
		try {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("uuid", UUID.randomUUID().toString());
			String path = FreemarkerUtils.process(uploadPath, model);
			String destPath = path + UUID.randomUUID() + "."
					+ FilenameUtils.getExtension(multipartFile.getOriginalFilename());
			File tempFile = new File(System.getProperty("java.io.tmpdir") + "/upload_" + UUID.randomUUID() + ".tmp");
			if (!tempFile.getParentFile().exists()) {
				tempFile.getParentFile().mkdirs();
			}
			multipartFile.transferTo(tempFile);
			for (StoragePlugin storagePlugin : pluginService.getStoragePlugins(true)) {

				if (async) {
					addTask(storagePlugin, destPath, tempFile, multipartFile.getContentType());
				} else {
					try {
						storagePlugin.upload(destPath, tempFile, multipartFile.getContentType());
					} finally {

					}
				}
				//
					backpath = storagePlugin.getUrl(destPath);
					
			}
			FileUtils.deleteQuietly(tempFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return backpath;
	}

	public String upload(FileType fileType, MultipartFile multipartFile) {
		return upload(fileType, multipartFile, false);
	}

	public String uploadLocal(FileType fileType, MultipartFile multipartFile) {
		if (multipartFile == null) {
			return null;
		}
		String uploadPath;
		if (fileType == FileType.flash) {
			uploadPath = "flash";
		} else if (fileType == FileType.media) {
			uploadPath = "media";
		} else if (fileType == FileType.file) {
			uploadPath = "file";
		} else {
			uploadPath = "images";
		}
		try {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("uuid", UUID.randomUUID().toString());
			String path = FreemarkerUtils.process(uploadPath, model);
			String destPath = path + UUID.randomUUID() + "."
					+ FilenameUtils.getExtension(multipartFile.getOriginalFilename());
			File destFile = new File(servletContext.getRealPath(destPath));
			if (!destFile.getParentFile().exists()) {
				destFile.getParentFile().mkdirs();
			}
			multipartFile.transferTo(destFile);
			return destPath;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<FileInfo> browser(String path, FileType fileType, OrderType orderType) {
		if (path != null) {
			if (!path.startsWith("/")) {
				path = "/" + path;
			}
			if (!path.endsWith("/")) {
				path += "/";
			}
		} else {
			path = "/";
		}
		String uploadPath;
		if (fileType == FileType.flash) {
			uploadPath = "flash";
		} else if (fileType == FileType.media) {
			uploadPath = "media";
		} else if (fileType == FileType.file) {
			uploadPath = "file";
		} else {
			uploadPath = "images";
		}
		String browsePath = StringUtils.substringBefore(uploadPath, "${");
		browsePath = StringUtils.substringBeforeLast(browsePath, "/") + path;

		List<FileInfo> fileInfos = new ArrayList<FileInfo>();
		if (browsePath.indexOf("..") >= 0) {
			return fileInfos;
		}
		for (StoragePlugin storagePlugin : pluginService.getStoragePlugins(true)) {
			fileInfos = storagePlugin.browser(browsePath);
			break;
		}
		if (orderType == OrderType.size) {
			Collections.sort(fileInfos, new SizeComparator());
		} else if (orderType == OrderType.type) {
			Collections.sort(fileInfos, new TypeComparator());
		} else {
			Collections.sort(fileInfos, new NameComparator());
		}
		return fileInfos;
	}

	private class NameComparator implements Comparator<FileInfo> {
		public int compare(FileInfo fileInfos1, FileInfo fileInfos2) {
			return new CompareToBuilder().append(!fileInfos1.getIsDirectory(), !fileInfos2.getIsDirectory())
					.append(fileInfos1.getName(), fileInfos2.getName()).toComparison();
		}
	}

	private class SizeComparator implements Comparator<FileInfo> {
		public int compare(FileInfo fileInfos1, FileInfo fileInfos2) {
			return new CompareToBuilder().append(!fileInfos1.getIsDirectory(), !fileInfos2.getIsDirectory())
					.append(fileInfos1.getSize(), fileInfos2.getSize()).toComparison();
		}
	}

	private class TypeComparator implements Comparator<FileInfo> {
		public int compare(FileInfo fileInfos1, FileInfo fileInfos2) {
			return new CompareToBuilder().append(!fileInfos1.getIsDirectory(), !fileInfos2.getIsDirectory())
					.append(FilenameUtils.getExtension(fileInfos1.getName()),
							FilenameUtils.getExtension(fileInfos2.getName()))
					.toComparison();
		}
	}

}