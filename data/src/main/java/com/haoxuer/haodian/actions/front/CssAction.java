package com.haoxuer.haodian.actions.front;

import com.haoxuer.haodian.web.utils.FrontUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CssAction {

	@RequestMapping(value = "css", method = RequestMethod.GET, consumes = {
			"text/css", "application/*" })
	public String css() {
		return FrontUtils.getPath("css");
	}
}
