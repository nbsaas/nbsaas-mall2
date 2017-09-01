/*
 * 
 * 
 * 
 */
package com.openyelp.services.file;


import com.ada.plug.api.StoragePlugin;

import java.util.List;

/**
 * Service - 插件
 * 
 * 
 * 
 */
public interface PluginFileService {


	/**
	 * 获取存储插件
	 * 
	 * @return 存储插件
	 */
	List<StoragePlugin> getStoragePlugins();


	/**
	 * 获取存储插件
	 * 
	 * @param isEnabled
	 *            是否启用
	 * @return 存储插件
	 */
	List<StoragePlugin> getStoragePlugins(boolean isEnabled);


	/**
	 * 获取存储插件
	 * 
	 * @param id
	 *            ID
	 * @return 存储插件
	 */
	StoragePlugin getStoragePlugin(String id);

}