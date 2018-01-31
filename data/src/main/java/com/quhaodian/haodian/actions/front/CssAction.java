package com.quhaodian.haodian.actions.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quhaodian.haodian.web.utils.FrontUtils;

@Controller
public class CssAction {

	@RequestMapping(value = "css", method = RequestMethod.GET, consumes = {
			"text/css", "application/*" })
	public String css() {
		return FrontUtils.getPath("css");
	}
}
