package com.quhaodian.data.entity;

import com.ada.area.data.entity.Area;
import com.ada.user.data.entity.UserInfo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "shop_back")
public class ShopBack {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Long id;

	@Override
	public String toString() {
		return "Shop [id=" + id + ", name=" + name + "]";
	}

	@Column(length = 100)
	private String address;

	/**
	 * 商家所有分类
	 */
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.REMOVE })
	@JoinTable(name = "shop_category_links_backs")
	private Set<ShopCategory> categorys = new HashSet<ShopCategory>();

	@Column(length = 100)
	private String gps;

	/**
	 * poi的唯一标示
	 */
	@Column(length = 100)
	private String uid;

	@Column(length = 100)
	private String name;
	
	@Column(length = 300)
	private String image;
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(length = 100)
	private String phone;

	@Column(length = 100)
	private String website;

	/**
	 * 经度
	 */
	private Double longitude;

	/**
	 * 纬度
	 */
	private Double latitude;
	private Date addDate;

	private Date lastDate;
	/**
	 * 距离中心点的距离
	 */
	private Integer distance;

	/**
	 * 照片
	 */
	private Integer photos;

	/**
	 * 0为未审核 1为审核过的
	 */
	private Integer state;

	/**
	 * poi的详情页
	 */
	private String detail_url;

	/**
	 * poi商户的价格
	 */
	private Float price;

	/**
	 * 营业时间
	 */
	private String shop_hours;

	/**
	 * 总体评分
	 */
	private Float overall_rating;

	/**
	 * 口味评分
	 */
	private Float taste_rating;
	/**
	 * 服务评分
	 */
	private Float service_rating;

	/**
	 * 环境评分
	 */
	private Float environment_rating;

	/**
	 * 星级（设备）评分
	 */
	private Float facility_rating;

	/**
	 * 卫生评分
	 */
	private Float hygiene_rating;

	/**
	 * 技术评分
	 */
	private Float technology_rating;

	/**
	 * 图片数
	 */
	private Float image_num;
	/**
	 * 团购数
	 */
	private Integer groupon_num;

	/**
	 * 优惠数
	 */
	private Integer discount_num;

	/**
	 * 评论数
	 */
	private Integer comment_num;
	/**
	 * 收藏数
	 */
	private Integer favorite_num;
	/**
	 * 签到数
	 */
	private Integer checkin_num;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "shop_tag_links_back")
	private Set<ShopTag> tags = new HashSet<ShopTag>();
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userid")
	private UserInfo user;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "areaid")
	private Area area;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "shopid")
	private Shop shop;

	private String note;
	/**
	 * 商店已經關閉或搬遷         
	 */
	private Integer business_closed;
	
	/**
	 *  此商店與另一在Yelp上的商店重複 
	 */
	private Integer dupBusiness;
	public Date getAddDate() {
		return addDate;
	}

	public String getAddress() {
		return address;
	}

	public Area getArea() {
		return area;
	}

	public Set<ShopCategory> getCategorys() {
		return categorys;
	}

	public Integer getCheckin_num() {
		return checkin_num;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getBusiness_closed() {
		return business_closed;
	}

	public void setBusiness_closed(Integer business_closed) {
		this.business_closed = business_closed;
	}

	public Integer getDupBusiness() {
		return dupBusiness;
	}

	public void setDupBusiness(Integer dupBusiness) {
		this.dupBusiness = dupBusiness;
	}

	public Integer getComment_num() {
		return comment_num;
	}

	public String getDetail_url() {
		return detail_url;
	}

	public Integer getDiscount_num() {
		return discount_num;
	}

	public int getDistance() {
		return distance;
	}

	public Float getEnvironment_rating() {
		return environment_rating;
	}

	public Float getFacility_rating() {
		return facility_rating;
	}

	public Integer getFavorite_num() {
		return favorite_num;
	}

	public String getGps() {
		return gps;
	}

	public Integer getGroupon_num() {
		return groupon_num;
	}

	public Float getHygiene_rating() {
		return hygiene_rating;
	}

	public Long getId() {
		return id;
	}

	public Float getImage_num() {
		return image_num;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public String getName() {
		return name;
	}

	public Float getOverall_rating() {
		return overall_rating;
	}

	public String getPhone() {
		return phone;
	}

	public Integer getPhotos() {
		return photos;
	}

	public Float getPrice() {
		return price;
	}

	public Float getService_rating() {
		if (service_rating==null) {
			service_rating=0f;
		}
		return service_rating;
	}

	public String getShop_hours() {
		return shop_hours;
	}

	public Integer getState() {
		return state;
	}

	public Set<ShopTag> getTags() {
		return tags;
	}

	public Float getTaste_rating() {
		return taste_rating;
	}

	public Float getTechnology_rating() {
		return technology_rating;
	}

	public String getUid() {
		return uid;
	}

	public UserInfo getUser() {
		return user;
	}

	public String getWebsite() {
		return website;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public void setCategorys(Set<ShopCategory> categorys) {
		this.categorys = categorys;
	}

	public void setCheckin_num(Integer checkin_num) {
		this.checkin_num = checkin_num;
	}

	public void setComment_num(Integer comment_num) {
		this.comment_num = comment_num;
	}

	public void setDetail_url(String detail_url) {
		this.detail_url = detail_url;
	}

	public void setDiscount_num(Integer discount_num) {
		this.discount_num = discount_num;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}

	public void setEnvironment_rating(Float environment_rating) {
		this.environment_rating = environment_rating;
	}

	public void setFacility_rating(Float facility_rating) {
		this.facility_rating = facility_rating;
	}

	public void setFavorite_num(Integer favorite_num) {
		this.favorite_num = favorite_num;
	}

	public void setGps(String gps) {
		this.gps = gps;
	}

	public void setGroupon_num(Integer groupon_num) {
		this.groupon_num = groupon_num;
	}

	public void setHygiene_rating(Float hygiene_rating) {
		this.hygiene_rating = hygiene_rating;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setImage_num(Float image_num) {
		this.image_num = image_num;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOverall_rating(Float overall_rating) {
		this.overall_rating = overall_rating;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setPhotos(Integer photos) {
		this.photos = photos;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public void setService_rating(Float service_rating) {
		this.service_rating = service_rating;
	}

	public void setShop_hours(String shop_hours) {
		this.shop_hours = shop_hours;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public void setTags(Set<ShopTag> tags) {
		this.tags = tags;
	}

	public void setTaste_rating(Float taste_rating) {
		this.taste_rating = taste_rating;
	}

	public void setTechnology_rating(Float technology_rating) {
		this.technology_rating = technology_rating;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

}
