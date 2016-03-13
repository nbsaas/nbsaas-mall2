package com.openyelp.template;

import com.ada.template_ace.ModuleMavenGenerator;

public class CmsModuleGenerator {
	private static String packName = "com.openyelp.template";
private static String fileName = "mendao.properties"; 

	public static void main(String[] args) {
		new ModuleMavenGenerator(packName, fileName).generate();
	}
}
