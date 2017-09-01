package com.openyelp.web.freemaker;

import static freemarker.template.ObjectWrapper.DEFAULT_WRAPPER;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.openyelp.data.entity.ShopReviewVote;
import com.openyelp.data.service.ShopReviewVoteService;
import com.openyelp.web.utils.DirectiveUtils;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

public class HaveVoteDirective implements TemplateDirectiveModel{

	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars,  
            TemplateDirectiveBody body) throws TemplateException, IOException {

		
		
		 //其实完全可以不用它，params是个Map，自己通过key取值就可以了，做一下空值判断  
        Long uid = DirectiveUtils.getLong("uid", params);  
        Long shopreviewid = DirectiveUtils.getLong("rid", params);  
        Integer catalog = DirectiveUtils.getInt("catalog", params);  

       ShopReviewVote page = voteService.findByUser(uid, shopreviewid, catalog);
        
        Map<String, TemplateModel> paramWrap = new HashMap<String, TemplateModel>(params);
		paramWrap.put("vote_m", DEFAULT_WRAPPER.wrap(page));

		Map<String, TemplateModel> origMap = DirectiveUtils
				.addParamsToVariable(env, paramWrap);
		if (body != null) {
			body.render(env.getOut());
		}
		DirectiveUtils.removeParamsFromVariable(env, paramWrap, origMap);

	}

	@Autowired
	ShopReviewVoteService voteService;
}