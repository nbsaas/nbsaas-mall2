package com.haoxuer.haodian.actions.front;

import com.haoxuer.discover.area.data.entity.Area;
import com.haoxuer.discover.area.data.service.AreaService;
import com.haoxuer.discover.data.core.Pagination;
import com.haoxuer.discover.data.page.Filter;
import com.haoxuer.discover.user.data.entity.UserAccount;
import com.haoxuer.discover.user.data.entity.UserInfo;
import com.haoxuer.discover.user.data.service.UserAccountService;
import com.haoxuer.discover.user.data.vo.UserAccountVo;
import com.haoxuer.discover.user.utils.ListUtils;
import com.haoxuer.discover.web.controller.front.BaseController;
import com.haoxuer.haodian.data.apps.ObjectFactory;
import com.haoxuer.haodian.data.entity.EntityContent;
import com.haoxuer.haodian.data.service.*;
import com.haoxuer.haodian.services.haoservice.lifeservice.joke.ContentList;
import com.haoxuer.haodian.services.haoservice.lifeservice.joke.JokeApi;
import com.haoxuer.haodian.services.haoservice.lifeservice.joke.JokeContent;
import com.haoxuer.haodian.shiro.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SiteAction extends BaseController{


	@Autowired
	ShopReviewGoodService shopReviewGoodService;
	
	
	@Autowired
	FeedService feedService;

	@Autowired
	AreaService areaService;

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		Integer id = UserUtil.getCurrentCity().getId();
		List<Area> as = null;
		if (id < 0) {
			Area area = areaService.findByName(UserUtil.getCurrentCity()
					.getName());
			if (area != null) {
				UserUtil.setCurrentCity(area);


				//as = areaService.pageByLevel(UserUtil.getCurrentCity().getId(),5,1,20).getList();
				List<Filter> filters= ListUtils.list(Filter.eq("parent.id",UserUtil.getCurrentCity().getId()));
				filters.add(Filter.eq("levelInfo",5));
				as = areaService.list(1,20,filters,null);
			}
		} else {
			List<Filter> filters= ListUtils.list(Filter.eq("parent.id",UserUtil.getCurrentCity().getId()));
			filters.add(Filter.eq("levelInfo",5));
			as = areaService.list(1,20,filters,null);
		}

		model.addAttribute("curpage", curpage);
		model.addAttribute("pagesize", pagesize);
		model.addAttribute("towns", as);

		Pagination rs = shopReviewGoodService.pageByArea(UserUtil
				.getCurrentCity().getId(), 1, 1);
		model.addAttribute("goods", rs.getList());

		List<Area> a1 = new ArrayList<Area>();
		List<Area> a2 = new ArrayList<Area>();
		List<Area> a3 = new ArrayList<Area>();
		List<Area> a4 = new ArrayList<Area>();

		if (as != null && as.size() > 0) {
			for (int i = 0; i < as.size(); i++) {
				if (i > 0) {

					if (i % 4 == 0) {
						a1.add(as.get(i));
					}
					if (i % 4 == 1) {
						a2.add(as.get(i));
					}
					if (i % 4 == 2) {
						a3.add(as.get(i));
					}
					if (i % 4 == 3) {
						a4.add(as.get(i));
					}

				} else if (i == 0) {
					a1.add(as.get(i));
				}
			}

		}
		model.addAttribute("towns1", a1);
		model.addAttribute("towns2", a2);
		model.addAttribute("towns3", a3);
		model.addAttribute("towns4", a4);

		Pagination pagination = shopService.pageByNew(UserUtil.getCurrentCity()
				.getId(), 1, 3);
		model.addAttribute("newlist", pagination.getList());

		Integer areaid = UserUtil.getCurrentCity().getId();
		Pagination events = eventInfoService.pageByNew(areaid, 1, 3);
		model.addAttribute("eventslist", events.getList());

		UserInfo u = UserUtil.getCurrentUser();
		if (u.getId() > 0) {
			try {
				model.addAttribute("shop", shopService.findByRand(id));
			}
			catch (Exception e){
				e.printStackTrace();
			}

		}
		model.addAttribute("siteindex", 1);

		model.addAttribute("feeds", feedService.pageByArea(areaid, 1, 10)
				.getList());
		model.addAttribute("reviewlists", listService.pageByArea(areaid, 1, 5)
				.getList());

		return getView("index");
	}

	@Autowired
	ShopReviewListService listService;
	
	
	@Autowired
	ShopReviewService reviewService;

	@Autowired
	EventInfoService eventInfoService;

	@Autowired
	EventInfoJoinService joinService;

	/**
	 * 活动首页
	 * 
	 * @param curpage
	 * @param pagesize
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "events", method = RequestMethod.GET)
	public String events(
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		
		
		Integer areaid = UserUtil.getCurrentCity().getId();
		
		//CookieLocaleResolver
		
		
		Pagination hots = eventInfoService.pageByHot(areaid, 1, 6);
		model.addAttribute("hots", hots.getList());

		Pagination recents = eventInfoService.pageByHot(areaid, 1, 8);
		model.addAttribute("recents", recents.getList());

		Pagination tops = eventInfoService.pageByTop(areaid, 1, 1);
		model.addAttribute("tops", tops.getList());

		Long userid = UserUtil.getCurrentUser().getId();
		Pagination mes = eventInfoService.pageByMe(userid, 1, 1);
		model.addAttribute("mes", mes.getList());

		Pagination weeks = eventInfoService.pageByWeek(areaid, 1, 6);
		model.addAttribute("weeks", weeks.getList());

		Pagination govs = eventInfoService.pageByGov(areaid, 1, 3);
		model.addAttribute("govs", govs.getList());
		Pagination joinpage = joinService.pageByArea(areaid, 1, 10);
		model.addAttribute("joins", joinpage.getList());

		model.addAttribute("siteindex", 7);

		return getView("events");
	}

	@RequestMapping(value = "locations", method = RequestMethod.GET)
	public String locations(
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		return getView("locations");
	}

	@Autowired
	ShopService shopService;

	@RequestMapping(value = "search", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String search(

			@RequestParam(value = "find_desc", required = true, defaultValue = "") String find_desc,
			String find_loc,
			@RequestParam(value = "catalog", required = true, defaultValue = "1") int catalog,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		if (find_loc == null) {
			find_loc = UserUtil.getCurrentCity().getName();
		}
		Pagination rs = shopService.search(find_loc, find_desc, catalog,
				curpage, pagesize);

		if (rs != null) {
			model.addAttribute("list", rs.getList());
			model.addAttribute("page", rs);
		}
		model.addAttribute("catalogs", categoryService.findByPid(catalog));
		model.addAttribute("tops", categoryService.findByTops(catalog));
		model.addAttribute("catalog", catalog);
		model.addAttribute("curcatalog", categoryService.findById(catalog));

		model.addAttribute("curpage", curpage);
		model.addAttribute("pagesize", pagesize);
		model.addAttribute("find_loc", find_loc);
		model.addAttribute("find_desc", find_desc);
		model.addAttribute("totalcount", rs.getTotalCount());
		model.addAttribute("firstno", rs.getFirstNo());
		model.addAttribute("endno", rs.getEndNo());

		return getView("search");
	}

	@RequestMapping(value = "guidelines", method = RequestMethod.GET)
	public String guidelines(
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		return getView("guidelines");
	}

	@RequestMapping(value = "signup", method = RequestMethod.GET)
	public String signup(
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		return getView("signup");
	}

	@RequestMapping(value = "joke", method = RequestMethod.GET)
	public String joke(
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		EntityContentService s = ObjectFactory.get().getBean(
				EntityContentService.class);
		ContentList list = JokeApi.ContentList(curpage, pagesize);
		List<JokeContent> imgs = list.getResult();
		for (JokeContent jokeContent : imgs) {
			EntityContent e = new EntityContent();
			e.setContent(jokeContent.getContent());
			e.setType(jokeContent.getType());
			e.setTitle(jokeContent.getTitle());
			e.setUpdatetime(jokeContent.getUpdatetime());
			s.save(e);
		}
		return "index";
	}

	@RequestMapping(value = "login1", method = RequestMethod.GET)
	public String login1(HttpServletRequest request,
			HttpServletResponse response, Model model) {

		return "login";
	}

	@Autowired
	UserService userService;

	@Autowired
	UserAccountService accountService;

	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public String signup(HttpServletRequest request, UserAccount user,
			HttpServletResponse response, Model model) {
		//user.setEmail("");

		UserAccountVo  result = accountService.reg(user);
		if (result.getCode() != 0) {
			model.addAttribute("msg", ""+result.getMsg());
			return getView("signup");
		} else {
			return getView("login");

		}
	}

	@RequestMapping(value = "forgot", method = RequestMethod.GET)
	public String forgot(HttpServletRequest request,
			HttpServletResponse response, Model model) {

		return getView("forgot");
	}

	@RequestMapping(value = "forgotwork", method = RequestMethod.POST)
	public String forgotwork(String email, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		if (email != null && email.indexOf("@") < 0) {
			model.addAttribute("msg", "邮件地址不正确");
			return getView("forgot");

		}

		model.addAttribute("email", email);
		return getView("forgotok");
	}

	@Autowired
	ShopCategoryService categoryService;
	@Autowired
	ShopImageService shopImageService;

	@Autowired
	ShopReviewService shopReviewService;

	@RequestMapping(value = "/city/{cityid}/catalog/{catalog}", method = RequestMethod.GET)
	public String catalog(@PathVariable("cityid") int cityid,
			@PathVariable("catalog") int catalog, HttpServletRequest request,
			HttpServletResponse response, Model model) {

		model.addAttribute("catalogs", categoryService.findByPid(catalog));
		model.addAttribute("tops", categoryService.findByTops(catalog));
		model.addAttribute("catalog", catalog);
		model.addAttribute("areaid", cityid);
		model.addAttribute("curcatalog", categoryService.findById(catalog));
		model.addAttribute("areas", areaService.list(0,99,ListUtils.list(Filter.eq("parent.id",cityid)),null));
		model.addAttribute("area", areaService.findById(cityid));
		model.addAttribute("shops",
				shopService.search("", cityid, catalog, 1, 8).getList());
		model.addAttribute("images",
				shopImageService.page(cityid, catalog, 1, 8).getList());
		model.addAttribute("reviews",
				shopReviewService.page(cityid, catalog, 1, 8).getList());

		return getView("catalog");
	}

}