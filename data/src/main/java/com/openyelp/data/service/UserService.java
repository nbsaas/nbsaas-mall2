package com.openyelp.data.service;

import com.ada.data.core.Pagination;
import com.ada.user.data.entity.UserInfo;
import com.ada.user.data.entity.UserRole;

public interface UserService {
	/**加密方法*/
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	public static final int SALT_SIZE = 8;	//盐长度
	public Pagination getPage(int pageNo, int pageSize);

	public UserInfo findById(Long id);

	public UserInfo save(UserInfo bean);
	/**
	 * 
	 * @param userid 用户id
	 * @param oldpassword 以前的密码
	 * @param password 新密码
	 * @return 修改成功后id>0
	 */
	public UserInfo updatePassword(Long userid,String oldpassword,String password);

	public boolean addRole(Long id, UserRole bean);

	public UserInfo update(UserInfo bean);

	public UserInfo deleteById(Long id);

	public UserInfo login(String username, String password, String macaddress);
	public UserInfo loginqq(String openid, String nickname, String figureurl_qq_1);

	public UserInfo[] deleteByIds(Long[] ids);

	public UserInfo findByUsername(String username);
	public UserInfo findByName(String name);

	public boolean checkPassword(UserInfo user,String oldPassword);

	public UserInfo updateUserLogin(UserInfo user);
	
	public Pagination findByName(String name,int pageNo, int pageSize);
	public Pagination findByFollowName(String name,long userid,int pageNo, int pageSize);

	public UserInfo updatePhoto(Long uid, Long id);
	
}