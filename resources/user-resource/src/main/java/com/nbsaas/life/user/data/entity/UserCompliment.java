package com.nbsaas.life.user.data.entity;

import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * 赞美
 *
 * @author andrea
 */
@Data
@Entity
@Table(name = "user_compliment")
public class UserCompliment extends AbstractEntity {


	private String messages;


	@ManyToOne
	private UserInfo userInfo;


	@ManyToOne
	private UserInfo compliment;
	/**
	 * 类型
	 */
	private String type;


	/**
	 * 0为初始状态 1为审核通过
	 */
	private Integer state;


}
