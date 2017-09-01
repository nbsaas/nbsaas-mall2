package com.openyelp.plugs.qiniu;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ada.plug.api.StoragePlugin;
import com.ada.plug.data.vo.FileInfo;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.young.security.md5.MD5Utils;


@Component("qiNiuStoragePlugin")
public class QiNiuStoragePlugin extends StoragePlugin {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "七牛云存储";
	}

	@Override
	public String getVersion() {
		// TODO Auto-generated method stub
		return "1.1";
	}

	public boolean getIsEnabled() {
		
		return true;
	}

	@Override
	public String getAuthor() {
		// TODO Auto-generated method stub
		return "ada";
	}

	@Override
	public String getSiteUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInstallUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUninstallUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSettingUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	String domain = "openyelp";
	final String url = "http://zzdp.yichisancun.com/";;

	@Override
	public void upload(String path, File file, String contentType) {

		Auth auth = Auth.create("U5VKtUFe6bCJ642tnFu4--fP2DSydhNxJ13Dc74O", "Exi35KBoHRKw6ensQMJBECKnRTEIEsu4aXvMJDA2");
		String token = auth.uploadToken(domain);
		UploadManager manager = new UploadManager();
		try {
			MD5Utils md5 = new MD5Utils(path);
			String key = md5.compute();
			String murl = url + key;
			Response r = manager.put(file, key, token);
		} catch (QiniuException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public String getUrl(String path) {
		System.out.println(path);
		MD5Utils md5 = new MD5Utils(path);
		String key = md5.compute();
		String murl = url + key;
		
		System.out.println(murl);

		return murl;
	}

	@Override
	public List<FileInfo> browser(String path) {
		// TODO Auto-generated method stub
		return null;
	}

}
