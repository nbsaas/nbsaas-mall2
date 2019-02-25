package com.quhaodian.haodian.qiniu;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.haoxuer.discover.plug.api.StoragePlugin;
import com.haoxuer.discover.plug.data.vo.FileInfo;
import org.springframework.stereotype.Component;

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
		return "1.0.1";
	}

	@Override
	public String viewName() {
		return "qiniu";
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
