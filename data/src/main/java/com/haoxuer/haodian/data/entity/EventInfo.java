package com.haoxuer.haodian.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.haoxuer.discover.area.data.entity.Area;
import com.haoxuer.discover.user.data.entity.UserInfo;

@Entity
@Table(name = "eventinfo_entity")
public class EventInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userid")
	private UserInfo user;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "areaid")
	private Area area;
	
	private Integer photos;

	public Integer getPhotos() {
		return photos;
	}

	public void setPhotos(Integer photos) {
		this.photos = photos;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryid")
	private EventInfoCategory category;

	/**
	 * 免费还是收费
	 */
	private Integer free;
	
	private Integer use_end_time;

	/**
	 * 公共 还是私有
	 */
	private Integer community;
	 
	private String img;

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	/**
	 * 最低开销
	 */
	private Float cost;
	
	/**
	 * 私有地址联系人
	 */
	private String venue_name;
	/**
	 * 私有还是公共
	 */
	private String venue_type;
	
	/**
	 * 私有地址城市
	 */
	private String venue_city_state_zip;
	
	/**
	 * 私有地址
	 */
	@Column(length=100)
	private String venue_street;
	/**
	 * 最低开销
	 */
	private Float cost_max;
	
	@Column(length=100)
	private String event_site_url;

	@Column(length=100)
	private String tickets_url;

	@Column(length=500)
	private String  description;

	private String name;
	
	
	private Date ends_month_day_year;
	private Date starts_month_day_year;
	private Date addDate;
	private String starts_time;

	private String ends_time;
	
	private Integer views=0;
	
	private Integer joins=0;
	private Integer favs=0;

	public Integer getFavs() {
		return favs;
	}

	public void setFavs(Integer favs) {
		this.favs = favs;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public Integer getJoins() {
		return joins;
	}

	public void setJoins(Integer joins) {
		this.joins = joins;
	}

	public Date getAddDate() {
		return addDate;
	}

	public EventInfoCategory getCategory() {
		return category;
	}
	
	public Integer getCommunity() {
		return community;
	}

	public Float getCost() {
		return cost;
	}

	public Float getCost_max() {
		return cost_max;
	}

	public String getDescription() {
		return description;
	}

	public Date getEnds_month_day_year() {
		return ends_month_day_year;
	}

	public String getEnds_time() {
		return ends_time;
	}

	public String getEvent_site_url() {
		return event_site_url;
	}

	public Integer getFree() {
		return free;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getStarts_month_day_year() {
		return starts_month_day_year;
	}

	public String getStarts_time() {
		return starts_time;
	}

	public String getTickets_url() {
		return tickets_url;
	}

	public Integer getUse_end_time() {
		return use_end_time;
	}

	public UserInfo getUser() {
		return user;
	}
	public String getVenue_city_state_zip() {
		return venue_city_state_zip;
	}
	
	public String getVenue_name() {
		return venue_name;
	}
	
	
	
	public String getVenue_street() {
		return venue_street;
	}
	public String getVenue_type() {
		return venue_type;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public void setCategory(EventInfoCategory category) {
		this.category = category;
	}

	public void setCommunity(Integer community) {
		this.community = community;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public void setCost_max(Float cost_max) {
		this.cost_max = cost_max;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setEnds_month_day_year(Date ends_month_day_year) {
		this.ends_month_day_year = ends_month_day_year;
	}

	public void setEnds_time(String ends_time) {
		this.ends_time = ends_time;
	}

	public void setEvent_site_url(String event_site_url) {
		this.event_site_url = event_site_url;
	}

	public void setFree(Integer free) {
		this.free = free;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStarts_month_day_year(Date starts_month_day_year) {
		this.starts_month_day_year = starts_month_day_year;
	}

	public void setStarts_time(String starts_time) {
		this.starts_time = starts_time;
	}

	public void setTickets_url(String tickets_url) {
		this.tickets_url = tickets_url;
	}

	public void setUse_end_time(Integer use_end_time) {
		this.use_end_time = use_end_time;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public void setVenue_city_state_zip(String venue_city_state_zip) {
		this.venue_city_state_zip = venue_city_state_zip;
	}

	public void setVenue_name(String venue_name) {
		this.venue_name = venue_name;
	}

	public void setVenue_street(String venue_street) {
		this.venue_street = venue_street;
	}

	public void setVenue_type(String venue_type) {
		this.venue_type = venue_type;
	}
}
