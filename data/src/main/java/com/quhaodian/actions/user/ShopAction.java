package com.quhaodian.actions.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quhaodian.data.page.Filter;
import com.quhaodian.data.page.Pageable;
import com.quhaodian.data.entity.Shop;
import com.quhaodian.data.entity.ShopCategory;
import com.quhaodian.data.service.ShopService;
import com.quhaodian.shiro.utils.UserUtil;
import com.quhaodian.web.utils.FrontUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quhaodian.area.data.entity.Area;
import com.quhaodian.area.data.service.AreaService;
import com.quhaodian.data.core.Pagination;

@Controller
@RequestMapping(value = "user")
public class ShopAction {

	@Autowired
	AreaService areaService;

	@Autowired
	private ShopService shopService;

	@RequestMapping(value = "writeareview", method = RequestMethod.GET)
	public String writeareview(
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		
		
		model.addAttribute("siteindex",3);
		return FrontUtils.getPath("user/writeareview");
	}

	@RequestMapping(value = "search", method = {RequestMethod.GET,RequestMethod.POST})
	public String searchareview(
			@RequestParam(value = "find_desc", required = true, defaultValue = "") String find_desc,
			String find_loc,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		if(find_loc==null){
			find_loc= UserUtil.getCurrentCity().getName();
		}
		Pagination rs = shopService.search(find_loc, find_desc, curpage,
				pagesize);
		if (rs != null) {
			model.addAttribute("list", rs.getList());
			model.addAttribute("page", rs);
		}
		
		model.addAttribute("curpage", curpage);
		model.addAttribute("pagesize", pagesize);
		model.addAttribute("find_loc", find_loc);
		model.addAttribute("find_desc", find_desc);
		model.addAttribute("totalcount", rs.getTotalCount());
		model.addAttribute("firstno", rs.getFirstNo());
		model.addAttribute("endno", rs.getEndNo());

		return FrontUtils.getPath("user/search");
	}

	@RequestMapping(value = "newbiz", method = RequestMethod.GET)
	public String newbiz(
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		//List<Area> areas = areaService.pageByLevelState(3, 1, 1, 100).getList();
		Pageable pager=new Pageable();
		pager.setPageSize(99);
		pager.getFilters().add(Filter.eq("levelInfo",3));
		List<Area> areas = areaService.page(pager).getContent();

		model.addAttribute("areas", areas);
		return FrontUtils.getPath("user/newbiz");
	}

	@RequestMapping(value = "newbiz", method = RequestMethod.POST)
	public String newbizwork(Shop shop, Integer[] ids, String city,
                             HttpServletRequest request, HttpServletResponse response,
                             Model model) {
//		String cname = "";
//		if (city != null) {
//			cname = city.replace("市", "");
//		}
//		Area area = areaService.findByNames(cname);
//		if (area != null) {
//			shop.setArea(area);
//		}
		shop.setUser(UserUtil.getCurrentUser());
		if(ids!=null){
			for (Integer integer : ids) {
				shop.getCategorys().add(ShopCategory.fromId(integer));
			}
		}
		Shop s = shopService.save(shop);
		if (s != null && s.getId() != null) {
			return FrontUtils.redirect("/shop/view.htm?id=" + s.getId());
		} else {
			return FrontUtils.getPath("user/newbiz");

		}
	}
}
