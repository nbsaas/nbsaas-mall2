package com.openyelp.data.page;

import com.ada.data.core.Pagination;
import com.ada.data.dto.PageRpc;
import com.openyelp.data.entity.TalkReply;
public class TalkReplyPage extends PageRpc<TalkReply> {

	public TalkReplyPage(Pagination<TalkReply> page) {
		super(page);
	}

}
