package com.openyelp.template;


public class CmsModuleGenerator {
	private static String packName = "com.openyelp.template";
private static String fileName = "mendao.properties"; 

	public static void main(String[] args) {
		new ModuleGenerator(packName, fileName).generate();
	}
}
