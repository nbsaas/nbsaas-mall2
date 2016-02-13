package com.openyelp.services.qiniu;

import java.io.File;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

public class AuthApps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Auth auth = Auth.create("U5VKtUFe6bCJ642tnFu4--fP2DSydhNxJ13Dc74O",
				"Exi35KBoHRKw6ensQMJBECKnRTEIEsu4aXvMJDA2");
		String token = auth.uploadToken("appsdata");
		System.out.println(token);
		UploadManager manager=new UploadManager();
		
		File file = new File("D:\\header.jpg");

		try {
			Response r=	manager.put(file, "ada", token);
			System.out.println(r.address);
			System.out.println(r.bodyString());
		} catch (QiniuException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
