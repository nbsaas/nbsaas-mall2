package com.openyelp.actions.event;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import com.ada.data.core.Pagination;
import com.openyelp.data.entity.EventInfo;
import com.openyelp.data.entity.EventInfoCategory;
import com.openyelp.data.entity.EventInfoComment;
import com.openyelp.data.entity.EventInfoJoin;
import com.openyelp.data.entity.EventInfoPhoto;
import com.openyelp.data.entity.Shop;
import com.openyelp.data.entity.ShopImage;
import com.openyelp.data.service.EventInfoCategoryService;
import com.openyelp.data.service.EventInfoCommentService;
import com.openyelp.data.service.EventInfoJoinService;
import com.openyelp.data.service.EventInfoPhotoService;
import com.openyelp.data.service.EventInfoService;
import com.openyelp.shiro.utils.UserUtil;
import com.openyelp.web.utils.FrontUtils;
import com.openyelp.web.webbinding.CustomTimestampEditor;

@Controller
@RequestMapping(value = "events")
public class EventsAction {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);

		SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd");
		datetimeFormat.setLenient(false);

		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(
				dateFormat, true));
		binder.registerCustomEditor(java.sql.Timestamp.class,
				new CustomTimestampEditor(datetimeFormat, true));
		
	}

	@Autowired
	EventInfoService eventInfoService;
	@Autowired
	EventInfoCategoryService eventInfoCategoryService;
	@Autowired
	EventInfoJoinService eventInfoJoinService;

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String create(HttpServletRequest request,
			HttpServletResponse response, Model model) {

		model.addAttribute("list", eventInfoCategoryService.findByPid(1));
		return FrontUtils.getPath("events/create");
	}

	@RequiresUser
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join(Long id, Integer type, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		EventInfoJoin bean = new EventInfoJoin();
		bean.setUser(UserUtil.getCurrentUser());
		bean.setAddDate(new Date());
		bean.setType(type);
		EventInfo eventInfo = new EventInfo();
		eventInfo.setId(id);
		bean.setEventInfo(eventInfo);
		eventInfoJoinService.save(bean);
		return FrontUtils.redirect("/events/view.htm?id=" + id);
	}

	@RequiresUser
	@RequestMapping(value = "unjoin", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String unjoin(Long id, Integer type, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		EventInfoJoin join = eventInfoJoinService.findById(id);
		if (join != null) {
			Long eid = join.getEventInfo().getId();
			eventInfoJoinService.deleteById(id);
			return FrontUtils.redirect("/events/view.htm?id=" + eid);
		} else {
			return FrontUtils.redirect("/index.htm");
		}

	}

	@Autowired
	EventInfoJoinService joinService;

	@RequestMapping(value = "feed", method = RequestMethod.GET)
	public String feed(
			HttpServletRequest request,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletResponse response, Model model) {
		int areadid = UserUtil.getCurrentCity().getId();
		Pagination rs = joinService.pageByArea(areadid, curpage, pagesize);
		if (rs != null) {
			if (rs.getList() != null && rs.getList().size() > 0) {
				model.addAttribute("list", rs.getList());
			}
			model.addAttribute("page", rs);
		}
		model.addAttribute("curpage", curpage);
		model.addAttribute("pagesize", pagesize);

		Integer areaid = UserUtil.getCurrentCity().getId();
		Pagination hots = eventInfoService.pageByHot(areaid, 1, 6);
		model.addAttribute("hots", hots.getList());

		Pagination recents = eventInfoService.pageByHot(areaid, 1, 8);
		model.addAttribute("recents", recents.getList());

		Pagination tops = eventInfoService.pageByTop(areaid, 1, 1);
		model.addAttribute("tops", tops.getList());

		Long userid = UserUtil.getCurrentUser().getId();
		Pagination mes = eventInfoService.pageByMe(userid, 1, 1);
		model.addAttribute("mes", mes.getList());

		Pagination govs = eventInfoService.pageByGov(areaid, 1, 3);
		model.addAttribute("govs", govs.getList());

		return FrontUtils.getPath("events/feed");
	}

	@RequestMapping(value = "browse", method = RequestMethod.GET)
	public String browse(
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			@RequestParam(value = "sort_by", required = true, defaultValue = "10") String sort_by,

			HttpServletRequest request, Integer[] c, String start_date,
			String end_date, String[] audience, HttpServletResponse response,
			Model model) {
		Pagination rs = eventInfoService.browse(UserUtil.getCurrentUser()
				.getId(), start_date, end_date, sort_by, c, audience, curpage,
				pagesize);
		if (rs != null) {
			if (rs.getList() != null && rs.getList().size() > 0) {
				model.addAttribute("list", rs.getList());
			}
			model.addAttribute("page", rs);
		}
		model.addAttribute("curpage", curpage);
		model.addAttribute("pagesize", pagesize);
		List<EventInfoCategory> ls = eventInfoCategoryService.findByPid(1);
		List<Integer> ids = new ArrayList<Integer>();
		if (c != null) {
			for (Integer integer : c) {
				ids.add(integer);
			}
		}

		List<EventCategory> es = EventCategory.show(ls, ids);
		model.addAttribute("es", es);
		if (ids.size() > 0) {
			model.addAttribute("showall", false);

		} else {
			model.addAttribute("showall", true);

		}
		Integer areaid = UserUtil.getCurrentCity().getId();
		Pagination hots = eventInfoService.pageByHot(areaid, 1, 6);
		model.addAttribute("hots", hots.getList());

		Pagination recents = eventInfoService.pageByHot(areaid, 1, 8);
		model.addAttribute("recents", recents.getList());

		Pagination tops = eventInfoService.pageByTop(areaid, 1, 1);
		model.addAttribute("tops", tops.getList());

		Long userid = UserUtil.getCurrentUser().getId();
		Pagination mes = eventInfoService.pageByMe(userid, 1, 1);
		model.addAttribute("mes", mes.getList());

		Pagination govs = eventInfoService.pageByGov(areaid, 1, 3);
		model.addAttribute("govs", govs.getList());

		model.addAttribute("curl", makeUrl(ids, "c"));

		return FrontUtils.getPath("events/browse");

	}

	public static String makeUrl(List<Integer> ids, String p) {
		StringBuffer result = new StringBuffer();
		if (ids != null) {
			for (Object integer : ids) {
				result.append("&");
				result.append(p);
				result.append("=");
				result.append(integer);
			}
		}
		return result.toString();

	}

	@RequiresUser
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String creatework(HttpServletRequest request,
			HttpServletResponse response, EventInfo info, Model model) {

		info.setAddDate(new Date());
		info.setUser(UserUtil.getCurrentUser());
		info.setArea(UserUtil.getCurrentCity());
		info = eventInfoService.save(info);
		model.addAttribute("event", info);

		return FrontUtils.redirect("/events/addphotos.htm?id=" + info.getId());
	}

	@RequiresUser
	@RequestMapping(value = "addphotos", method = RequestMethod.GET)
	public String addphotos(HttpServletRequest request,
			HttpServletResponse response, Long id, Model model) {

		EventInfo info = eventInfoService.findById(id);
		model.addAttribute("event", info);

		return FrontUtils.getPath("events/addphoto");
	}

	@Autowired
	EventInfoPhotoService eventInfoPhotoService;

	@RequiresUser
	@RequestMapping(value = "addphoto", method = RequestMethod.POST)
	public String addphoto(HttpServletRequest request,
			HttpServletResponse response, EventInfoPhoto info, Model model) {

		info.setAddDate(new Date());
		info.setUser(UserUtil.getCurrentUser());
		info = eventInfoPhotoService.save(info);
		return FrontUtils.redirect("/events/view.htm?id="
				+ info.getEventinfo().getId());
	}

	@RequiresUser
	@RequestMapping(value = "comment", method = RequestMethod.POST)
	public String comment(EventInfoComment comment, HttpServletRequest request,
			HttpServletResponse response, Model model) {

		comment.setAddDate(new Date());
		comment.setUser(UserUtil.getCurrentUser());
		comment = eventInfoCommentService.save(comment);
		model.addAttribute("event", comment);
		model.addAttribute("msg", "评论成功!");
		return FrontUtils.redirect("/events/view.htm?id="
				+ comment.getEventInfo().getId());
	}

	@Autowired
	EventInfoCommentService eventInfoCommentService;

	@RequestMapping(value = "view", method = RequestMethod.GET)
	public String view(
			Long id,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		EventInfo eventInfo = eventInfoService.findById(id);
		if (eventInfo == null) {
			eventInfo = new EventInfo();
		}
		model.addAttribute("event", eventInfo);

		Pagination rs = eventInfoCommentService.pageByEventId(id, curpage,
				pagesize);
		if (rs != null) {
			model.addAttribute("comments", rs.getList());
			model.addAttribute("page", rs);
		}
		model.addAttribute("curpage", curpage);
		model.addAttribute("pagesize", pagesize);
		model.addAttribute("id", id);
		model.addAttribute("totalcount", rs.getTotalCount());
		model.addAttribute("firstno", rs.getFirstNo());
		model.addAttribute("endno", rs.getEndNo());
		List joins = eventInfoJoinService.pageByType(id, 1, 1, 10).getList();
		if (joins != null) {
			if (joins.size() > 5) {
				model.addAttribute("joins", joins.subList(0, 5));
				int size = joins.size();
				model.addAttribute("joins2", joins.subList(5, size));
			} else {
				model.addAttribute("joins", joins);

			}
		}
		List infos = eventInfoJoinService.pageByType(id, 2, 1, 10).getList();
		if (infos != null) {
			if (infos.size() > 5) {
				model.addAttribute("infos", infos.subList(0, 5));
				int size = infos.size();
				model.addAttribute("infos2", infos.subList(5, size));
			} else {
				model.addAttribute("infos", infos);

			}
		}
		model.addAttribute("mys", eventInfoJoinService.findByMe(UserUtil
				.getCurrentUser().getId(), id));

		return FrontUtils.getPath("events/view");
	}

	@Autowired
	EventInfoPhotoService photoService;

	@RequiresUser
	@RequestMapping(value = "photos", method = RequestMethod.GET)
	public String photos(
			HttpServletRequest request,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletResponse response, Long id, Model model) {

		EventInfo info = eventInfoService.findById(id);
		if (info == null) {
			FrontUtils.redirect("/index.htm");
		}
		model.addAttribute("event", info);
		Pagination rs = photoService.pageByEvent(id, curpage, pagesize);
		if (rs != null) {
			model.addAttribute("list", rs.getList());
			model.addAttribute("page", rs);
		}
		model.addAttribute("curpage", curpage);
		model.addAttribute("pagesize", pagesize);
		return FrontUtils.getPath("events/photos");
	}

	
	
	@RequiresUser
	@RequestMapping(value = "preaddimages", method = RequestMethod.GET)
	public String preaddphotos(HttpServletRequest request,
			HttpServletResponse response, Long id, Model model) {

		EventInfo info = eventInfoService.findById(id);
		model.addAttribute("event", info);

		return FrontUtils.getPath("events/addimages");
	}
	
	
	
	@RequiresUser
	@RequestMapping(value = "addimage", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String addimage(
			int id,
			EventInfoPhoto image,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		image.setUser(UserUtil.getCurrentUser());
		photoService.save(image);
		return FrontUtils.redirect("/events/photos.htm?id=" + id);
	}

	/**
	 * 添加图片
	 * 
	 * @param id
	 * @param images
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequiresUser
	@RequestMapping(value = "addimages", method = { RequestMethod.POST })
	public String addimages(long id, String[] images,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		if (images != null) {
			for (String string : images) {
				if (string == null) {
					continue;
				}
				EventInfoPhoto photo = new EventInfoPhoto();
				photo.setAddDate(new Date());
				photo.setUrl(string);
				EventInfo event = new EventInfo();
				event.setId(id);
				photo.setEventinfo(event);
				photo.setUser(UserUtil.getCurrentUser());
				photoService.save(photo);
			}
		}

		return FrontUtils.redirect("/events/photos.htm?id=" + id);
	}

}
