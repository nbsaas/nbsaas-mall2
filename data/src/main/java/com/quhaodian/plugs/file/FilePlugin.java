/*
 * 
 * 
 * 
 */
package com.quhaodian.plugs.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import com.ada.plug.api.StoragePlugin;
import com.ada.plug.data.entity.PluginConfig;
import com.ada.plug.data.vo.FileInfo;

/**
 * Plugin - 本地文件存储
 * 
 * 
 * 
 */
@Component("filePlugin")
public class FilePlugin extends StoragePlugin implements ServletContextAware {

	/** servletContext */
	private ServletContext servletContext;

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	@Override
	public String getName() {
		return "本地文件存储";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public String getAuthor() {
		return "ada.young";
	}

	@Override
	public String getSiteUrl() {
		return "";
	}

	@Override
	public String getInstallUrl() {
		return null;
	}

	@Override
	public String getUninstallUrl() {
		return null;
	}
	/**
	 * 获取是否已启用
	 * 
	 * @return 是否已启用
	 */
	public boolean getIsEnabled() {
		return false;
	}
	@Override
	public String getSettingUrl() {
		return "file/setting.jhtml";
	}

	@Override
	public void upload(String path, File file, String contentType) {
		if (servletContext!=null) {
			System.out.println(path);
			System.out.println(servletContext);
			String url=servletContext.getRealPath(path);
			System.out.println(url);
			if (url==null) {
				url="H:\\server\\apache-tomcat-8.0.28\\webapps\\icontact_web\\"+path;
			}
			File destFile = new File(url);
			try {
				FileUtils.copyFile(file, destFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public String getUrl(String path) {
		return  path;
	}

	@Override
	public List<FileInfo> browser(String path) {
		List<FileInfo> fileInfos = new ArrayList<FileInfo>();
		File directory = new File(servletContext.getRealPath(path));
		if (directory.exists() && directory.isDirectory()) {
			for (File file : directory.listFiles()) {
				FileInfo fileInfo = new FileInfo();
				fileInfo.setName(file.getName());
				fileInfo.setUrl(""+ path + file.getName());
				fileInfo.setIsDirectory(file.isDirectory());
				fileInfo.setSize(file.length());
				fileInfo.setLastModified(new Date(file.lastModified()));
				fileInfos.add(fileInfo);
			}
		}
		return fileInfos;
	}

}