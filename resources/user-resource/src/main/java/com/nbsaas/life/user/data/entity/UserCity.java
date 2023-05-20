package com.nbsaas.life.user.data.entity;


import com.nbsaas.life.area.data.entity.Area;
import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import lombok.Data;
import org.hibernate.annotations.Comment;

import javax.persistence.*;


/**
 * 用户的 关联的城市
 * @author 年高
 *
 */

@org.hibernate.annotations.Table(comment = "用户城市关联表",appliesTo = "user_city")
@Data
@Entity
@Table(name = "user_city")
public class UserCity extends AbstractEntity {
	

	@Comment("用户id")
	@ManyToOne
	private UserInfo user;

	private Integer state;

	@Comment("所在城市")
	@ManyToOne
	private Area area;

	@Comment("所在地址")
	@Column(length=150)
	private String address;

	/**
	 * 地点的名称
	 */
	@Comment("地点的名称")
	@Column(length=100)
	private String name;
	

}
