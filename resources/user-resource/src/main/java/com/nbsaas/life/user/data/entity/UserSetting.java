package com.nbsaas.life.user.data.entity;


import com.nbsaas.boot.jpa.data.entity.AbstractEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "user_setting")
public class UserSetting extends AbstractEntity {

	private String title = "";

	private String description = "";


	@OneToOne(fetch = FetchType.LAZY)
	private UserInfo user;

	private String share_setting;

	private Integer bookmarksPublic;

	private Integer memberSearch;

}
