package com.quhaodian.haodian.actions.front;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.quhaodian.haodian.data.entity.ShopImage;
import com.quhaodian.haodian.shiro.utils.UserUtil;
import com.quhaodian.web.controller.front.BaseController;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quhaodian.area.data.entity.Area;
import com.quhaodian.data.core.Pagination;
import com.quhaodian.haodian.data.entity.Shop;
import com.quhaodian.haodian.data.entity.ShopBack;
import com.quhaodian.haodian.data.entity.ShopCategory;
import com.quhaodian.haodian.data.entity.ShopImageList;
import com.quhaodian.haodian.data.entity.ShopReview;
import com.quhaodian.haodian.data.service.ShopBackService;
import com.quhaodian.haodian.data.service.ShopCategoryService;
import com.quhaodian.haodian.data.service.ShopImageListService;
import com.quhaodian.haodian.data.service.ShopImageService;
import com.quhaodian.haodian.data.service.ShopReviewService;
import com.quhaodian.haodian.data.service.ShopService;
import com.quhaodian.haodian.web.utils.FrontUtils;

@Controller
@RequestMapping(value = "shop")
public class ShopFrontAction extends BaseController {
	@Autowired
	private ShopService shopService;

	@Autowired
	private ShopReviewService shopReviewService;

	@RequestMapping(value = "view", method = RequestMethod.GET)
	public String view(Long id, @RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response, Model model) {
		Shop shop = shopService.findById(id);
		model.addAttribute("shop", shop);
		Pagination rs = shopReviewService.pageByShop(id, curpage, pagesize);
		if (rs != null) {
			model.addAttribute("list", rs.getList());
			model.addAttribute("page", rs);
		}

		Pagination<ShopImage> images = shopImageService.pageByShop(id, 1, 3);
		model.addAttribute("images", images.getList());
		model.addAttribute("imagesize", images.getTotalCount());

		model.addAttribute("curpage", curpage);
		model.addAttribute("id", id);
		model.addAttribute("pagesize", pagesize);
		return getView("shop/view");
	}

	@RequestMapping(value = "findbytype", method = RequestMethod.GET)
	public String findbytype(int id, @RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "6") int pagesize,
			HttpServletRequest request, HttpServletResponse response, Model model) {
		Pagination rs = shopService.page(curpage, pagesize);
		if (rs != null) {
			model.addAttribute("list", rs.getList());
			model.addAttribute("page", rs);
		}
		model.addAttribute("curpage", curpage);
		model.addAttribute("category", shopCategoryService.findById(id));
		model.addAttribute("id", id);
		model.addAttribute("pagesize", pagesize);
		return getView("shop/findbytype");
	}

	@RequestMapping(value = "findbytype2", method = RequestMethod.GET)
	public String findbytype2(@RequestParam(value = "catalog", required = true, defaultValue = "1") int catalog,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "6") int pagesize,
			HttpServletRequest request, HttpServletResponse response, Model model) {
		Area area = UserUtil.getCurrentCity();

		Pagination rs = shopService.pageByType(area.getId(), catalog, 1, pagesize);
		if (rs != null) {
			model.addAttribute("list", rs.getList());
			model.addAttribute("page", rs);
		}
		model.addAttribute("curpage", curpage);
		model.addAttribute("category", shopCategoryService.findById(catalog));
		model.addAttribute("catalog", catalog);
		model.addAttribute("pagesize", pagesize);
		return getView("shop/findbytype2");
	}

	@Autowired
	ShopImageService shopImageService;

	@RequestMapping(value = "photos", method = RequestMethod.GET)
	public String photos(Long id, @RequestParam(value = "num", required = true, defaultValue = "1") int num,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "35") int pagesize,
			HttpServletRequest request, HttpServletResponse response, Model model) {
		Shop shop = shopService.findById(id);
		model.addAttribute("shop", shop);
		Pagination rs = shopImageService.pageByShop(id, curpage, pagesize);
		if (rs != null) {
			model.addAttribute("list", rs.getList());
			model.addAttribute("page", rs);
		}
		model.addAttribute("curpage", curpage);
		model.addAttribute("id", id);
		model.addAttribute("pagesize", pagesize);
		model.addAttribute("num", num);
		model.addAttribute("photo", shopImageService.findById(id, num));

		model.addAttribute("url", FrontUtils.urls(request));
		return getView("shop/photos");
	}

	@RequiresUser
	@RequestMapping(value = "addphoto", method = { RequestMethod.GET, RequestMethod.POST })
	public String addphoto(int id, ShopImage image,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response, Model model) {
		image.setUser(UserUtil.getCurrentUser());
		shopImageService.save(image);
		return FrontUtils.redirect("/shop/photos.htm?id=" + id);
	}

	@RequiresUser
	@RequestMapping(value = "addphotos", method = { RequestMethod.GET, RequestMethod.POST })
	public String addphotos(long id, String[] images, HttpServletRequest request, HttpServletResponse response,
			Model model) {
		if (images != null) {
			ShopImageList bean = new ShopImageList();
			bean.setAddDate(new Date());
			bean.setLastDate(new Date());
			bean.setUser(UserUtil.getCurrentUser());
			bean.setArea(UserUtil.getCurrentCity());

			Set<ShopImage> imagess = new HashSet<ShopImage>();
			for (String string : images) {
				if (string == null || string.length() < 10) {
					continue;
				}
				ShopImage image = new ShopImage();
				image.setAddDate(new Date());
				image.setUrl(string);
				Shop shop = new Shop();
				shop.setId(id);
				image.setShop(shop);
				image.setUser(UserUtil.getCurrentUser());
				imagess.add(image);
				bean.setShop(shop);
			}
			bean.setImages(imagess);
			service.save(bean);
		}

		return FrontUtils.redirect("/shop/photos.htm?id=" + id);
	}

	@Autowired
	ShopImageListService service;

	@RequiresUser
	@RequestMapping(value = "writeareview", method = RequestMethod.GET)
	public String writeareview(Long id,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response, Model model) {
		Shop shop = shopService.findById(id);
		model.addAttribute("shop", shop);

		Pagination rs = shopReviewService.pageByShop(id, curpage, pagesize);

		model.addAttribute("list", rs.getList());
		model.addAttribute("page", rs);
		model.addAttribute("curpage", curpage);
		model.addAttribute("id", id);
		model.addAttribute("pagesize", pagesize);

		return getView("shop/writeareview");
	}

	@RequiresUser
	@RequestMapping(value = "biz_attribute", method = RequestMethod.GET)
	public String biz_attribute(Long id, HttpServletRequest request, HttpServletResponse response, Model model) {
		Shop shop = shopService.findById(id);
		model.addAttribute("shop", shop);
		model.addAttribute("maxtimes", TimeVo.times(1, 62));
		model.addAttribute("mintimes", TimeVo.times(0, 48));

		return getView("shop/biz_attribute");
	}

	@Autowired
	private ShopBackService shopBackService;

	@RequiresUser
	@RequestMapping(value = "biz_attribute_update", method = { RequestMethod.GET, RequestMethod.POST })
	public String biz_attribute_update(ShopBack shop, Integer[] ids, String city, HttpServletRequest request,
									   HttpServletResponse response, Model model) {

		String cname = "";
		if (city != null) {
			cname = city.replace("市", "");
		}
		if (ids != null) {
			for (Integer integer : ids) {
				shop.getCategorys().add(ShopCategory.fromId(integer));
			}
		}
		ShopBack s = shopBackService.save(shop);
		if (s != null && s.getId() != null) {
			return FrontUtils.redirect("/shop/view.htm?id=" + s.getShop().getId());
		} else {
			return getView("user/biz_attribute.htm?id=" + s.getShop().getId());

		}
	}

	@RequiresUser
	@RequestMapping(value = "commentshop", method = { RequestMethod.GET, RequestMethod.POST })
	public String comment(ShopReview shopReview,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response, Model model) {
		shopReview.setUser(UserUtil.getCurrentUser());
		shopReviewService.save(shopReview);

		return FrontUtils.redirect("/shop/view.htm?id=" + shopReview.getShop().getId());
	}

	@RequiresUser
	@RequestMapping(value = "user_photos", method = RequestMethod.GET)
	public String user_photos(Long id,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response, Model model) {
		Shop shop = shopService.findById(id);
		model.addAttribute("shop", shop);

		return getView("shop/user_photos");
	}

	@RequestMapping(value = "user_photos_upload_finished", method = RequestMethod.GET)
	public String user_photos_upload_finished(Long id,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response, Model model) {
		Shop shop = shopService.findById(id);
		model.addAttribute("shop", shop);

		return getView("shop/user_photos_upload_finished");
	}

	@RequestMapping(value = "send_to_friend", method = RequestMethod.GET)
	public String send_to_friend(Long id,
			@RequestParam(value = "curpage", required = true, defaultValue = "1") int curpage,
			@RequestParam(value = "pagesize", required = true, defaultValue = "10") int pagesize,
			HttpServletRequest request, HttpServletResponse response, Model model) {
		Shop shop = shopService.findById(id);
		model.addAttribute("shop", shop);

		return getView("shop/send_to_friend");
	}

	@Autowired
	ShopCategoryService shopCategoryService;

	@RequestMapping(value = "types", method = RequestMethod.GET)
	public String types(@RequestParam(value = "id", required = true, defaultValue = "1") int id, Model model) {
		String cs = shopCategoryService.findByPidForJson(id);
		model.addAttribute("text", cs);
		return getView("common/text");
	}

	@ResponseBody
	@RequestMapping(value = "random", method = RequestMethod.GET)
	public Shop random(Model model) {

		return shopService.findByRand(UserUtil.getCurrentCity().getId());
	}

}
