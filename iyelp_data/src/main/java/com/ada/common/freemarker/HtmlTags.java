package com.ada.common.freemarker;

import freemarker.template.SimpleHash;

public class HtmlTags extends SimpleHash {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HtmlTags() {
		put("htmlcut", new HtmlCutDirective());
		put("textcut", new TextCutDirective());
		put("date", new DateTag());
		put("dateweek", new DateWeekTag());

	}
}
